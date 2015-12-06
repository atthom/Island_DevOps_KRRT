/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.composed.*;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 * Classe travaillant sur la stratégie du drone pour se déplacer et scanner la
 * map et trouver des points d'abordage avec un cout minimum
 *
 * @author user
 */
public class FlyingStrategy extends Strategy {

    Coordinates currents_coords;
    Heading h;
    int nbtours;
    Map flyingMap;
    ArrayList<AbstractAction> actions;
    ManageReply manager;
    Direction old_direction;
    boolean phase1 = true, phase2 = true, phase3 = true, phase0 = true;
    int i;
    /**
     *
     * @param heading
     */
    public FlyingStrategy(String heading) {
        super();
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        manager = new ManageReply();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        currents_coords = new Coordinates(0, 0);
        old_direction = null;
        actions = new ArrayList<>();
    }
    
    
    /**
     *
     * @param heading
     */
    public FlyingStrategy(Heading heading) {
        super();
        h = heading;
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        manager = new ManageReply();
        currents_coords = new Coordinates(0, 0);
        old_direction = null;
        actions = new ArrayList<>();
    }

    private void change_heading(Direction d) {
        if(!d.equals(h.getValueParameter())) {
            old_direction = h.getValueParameter();
            actions.add(new Heading(d));
        }
    }

    void phase0() {

        actions.add(new Echo(h.getValueParameter().gauche()));
        actions.add(new Echo(h.getValueParameter().droite()));
        actions.add(new Echo(h.getValueParameter()));

        phase0 = false;
    }

    void phase1() {

        FlyTile t = (FlyTile) flyingMap.getTile(flyingMap.get_lastcoordinate());
        FlyTile t1 = (FlyTile) flyingMap.getTile(flyingMap.get_coordinate(3));

        if (t1.getT() == Type.GROUND) {
            phase1 = false;
        }

        manageComposedAction(new FlyAndEcho(currents_coords, h.getValueParameter(),flyingMap.chooseDirEcho(h.getValueParameter())));

        if (t.getT() == Type.GROUND && t1.getT() == Type.OUT_OF_RANGE) {
            change_heading(flyingMap.chooseDirEcho(h.getValueParameter()));
            actions.add(new Fly());
            phase1 = false;
        }


        /*FlyTile t = (FlyTile) flyingMap.getTile(flyingMap.get_lastcoordinate());
        if (t.getT() == Type.GROUND) {
            if (gauche)
                actions.add(new Heading(h.getValueParameter().gauche()));
                //lastaction = change_heading(h.getValueParameter().gauche());
            else
                actions.add(new Heading(h.getValueParameter().droite()));
                //lastaction = change_heading(h.getValueParameter().droite());
            phase1 = false;
            //phase2 = true;
        }
        else {
            if (flyingMap.get_coordinate(0).getX() > flyingMap.get_coordinate(0).getX()) {
                gauche = true;
                manageComposedAction(new FlyAndEcho(currents_coords, h.getValueParameter(),h.getValueParameter().gauche()));
            } else {
                gauche = false;
                manageComposedAction(new FlyAndEcho(currents_coords, h.getValueParameter(),h.getValueParameter().droite()));
            }
        }*/
    }
 
    void phase2() {
        //si on ne connais pas d'endoit ground ou aller...

        // sinon
        //Tile map.getTileground()
        // Donc comme ce n'est pas encore codé on part du principe qu'il y a de la terre dans notre map

        if (flyingMap.have_ground()) {
            int dist = currents_coords.distance(flyingMap.getfirstground()); 
            manageComposedAction(new FlyUntil(dist, currents_coords, h.getValueParameter()));
            phase2 = false;
        } else {
            actions.add(new Stop());
        }

    }
    
    void manageComposedAction(ComposedAction ac) {
        actions.addAll(ac.getAll());
        currents_coords = ac.getCoords();
        h = new Heading(ac.getDir());
     //   change_heading(ac.getDir());
    }

    void phase3() {
        //etat initial :  on connais une case de terre
    
        /*if(flyingMap.last_is_ocean()) {
            manageComposedAction(new TurnToOpposite(currents_coords, h.getValueParameter()));
            
//            int dist = currents_coords.distance(flyingMap.getfirstground()); 
//            manageComposedAction(new FlyUntil(dist, currents_coords, h.getValueParameter()));   
        } else {
            manageComposedAction(new FlyAndScan(currents_coords, h.getValueParameter()));
        }
      
      if(flyingMap.already_here(currents_coords)) {
           actions.add(new Stop());
       }*/
        actions.add(new Scan());
        actions.add(new Stop());
        
    }

    /**
     * execute les actions du drone
     *
     * @return
     */
    @Override
    public String execute() {

        if (actions.isEmpty()) {
            //  flyingtest();
            if (phase0) {
                phase0();
                return actions.get(0).toJSON().toString();
            }
            if (phase1) {
                phase1();

            } else if (phase2) {
                phase2();
            } else if (phase3) {
                phase3();
            }

        }

        return actions.get(0).toJSON().toString();

    }

//    void maj_coord() {
//        if (null != old_direction) {
//            super.maj_pos(currents_coords, old_direction);
//            old_direction = null;
//        }
//        super.maj_pos(currents_coords, h.getValueParameter());
//        flyingMap.put(currents_coords, new FlyTile(Type.UNKNOWN_TYPE));
//        // currents_coords;
//    }

    /**
     *
     * @param s l'object JSON (réponse) renvoyé par le moteur de jeu
     */
    @Override
    public void acknowledge(JSONObject s) {
        nbtours++;
       
        if(!actions.isEmpty()) {
            actions.remove(0);
        }
       
        manager.manage(s, flyingMap, h.getValueParameter().gauche(), currents_coords);
        
    }

}
