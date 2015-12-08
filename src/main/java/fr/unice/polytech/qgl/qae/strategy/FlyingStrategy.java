/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.composed.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.composed.TurnToOppositeLeft;
import fr.unice.polytech.qgl.qae.actions.composed.TurnToOppositeRight;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
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
    Direction d;
    int nbtours;
    Map flyingMap;
    ArrayList<AbstractAction> actions;
    ManageReply manager;
    Direction old_direction;
    boolean turnleft = false;
    boolean phase0 = true, phase1 = true, phase2 = true, phase3 = true;
    
    /**
     * Chaine de caractères
     *
     * @param heading
     */
    public FlyingStrategy(String heading) {
        this(new JSONFactory().build_heading(heading));
    }

    /**
     * Heading contient un parametre direction
     *
     * @param heading
     */
    public FlyingStrategy(Heading heading) {
        super();
        d = heading.getValueParameter();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        manager = new ManageReply();
        currents_coords = new Coordinates(0, 0);
        old_direction = null;
        actions = new ArrayList<>();
    }

    private void change_heading(Direction dd) {
        if (dd != d) {
            old_direction = d;
            Heading h = new Heading(dd);
            actions.add(h);
            h.maj_coord(currents_coords, old_direction, dd);
        }
    }

    void phase0() {
        actions.add(new Echo(d.left()));
        actions.add(new Echo(d.right()));
        actions.add(new Echo(d));
        phase0 = false;
    }

      void phase1() {

        FlyTile t = (FlyTile) flyingMap.getTile(flyingMap.get_lastcoordinate());
        FlyTile t1 = (FlyTile) flyingMap.getTile(flyingMap.get_coordinate(1));
        FlyTile t2 = (FlyTile) flyingMap.getTile(flyingMap.get_coordinate(2));
        FlyTile t3 = (FlyTile) flyingMap.getTile(flyingMap.get_coordinate(3));

        if (t3.getT() == Type.GROUND) {
            phase1 = false;
        }
        else if(t1.getT() == Type.GROUND || t2.getT() == Type.GROUND) {
            change_heading(flyingMap.chooseDirEcho(d));
            actions.add(new Fly());
            phase1 = false;
        }
        else if (t.getT() == Type.GROUND && t1.getT() == Type.OUT_OF_RANGE) {
            manageComposedAction(new FlyAndEcho(currents_coords, d,flyingMap.chooseDirEcho(d)));
            change_heading(flyingMap.chooseDirEcho(d));
            actions.add(new Fly());
            phase1 = false;
        }
    }
    void phase2() {
        //si on ne connais pas d'endoit ground ou aller...

        // sinon
        //Tile map.getTileground()
        // Donc comme ce n'est pas encore codé on part du principe qu'il y a de la terre dans notre map
        if (flyingMap.have_ground()) {
            int dist = currents_coords.distance(flyingMap.getfirstground());
            manageComposedAction(new FlyUntil(dist, currents_coords, d));
            phase2 = false;
        } else {
            actions.add(new Stop());
        }

    }

    void manageComposedAction(ComposedAction ac) {
        actions.addAll(ac.getAll());
        currents_coords = ac.getCoords();
        old_direction = d;
        d = ac.getDir();
        //   change_heading(ac.getDir());
    }

    void phase3() {
        //etat initial :  on connais une case de terre

        if (flyingMap.last_is_ocean()) {
            if (flyingMap.three_last_are_ocean()) {
                if (flyingMap.ten_last_are_ocean()) {
                    phase3 = false;
                } else if (turnleft) {
                    manageComposedAction(new TurnToOppositeLeft(currents_coords, d));
                    turnleft = false;
                } else {
                    manageComposedAction(new TurnToOppositeRight(currents_coords, d));
                    turnleft = true;
                }

                // manageComposedAction(new FlyUntil(2, currents_coords, d));
                // actions.add(new Scan());
            } else {
                manageComposedAction(new FlyAndScan(currents_coords, d));
                //   manageComposedAction(new TurnToOpposite(currents_coords, d));

//            change_heading(d.gauche());
//            
//            manageComposedAction(new FlyAndScan(currents_coords, d));
//            manageComposedAction(new FlyAndScan(currents_coords, d));
//            manageComposedAction(new FlyAndScan(currents_coords, d));
//            int dist = currents_coords.distance(flyingMap.getfirstground()); 
//            manageComposedAction(new FlyUntil(dist, currents_coords, h.getValueParameter()));   
            }

        } else {
            manageComposedAction(new FlyAndScan(currents_coords, d));
        }
        if (flyingMap.already_here(currents_coords)) {
            phase3 = false;
        }

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
            if(phase0) {
                phase0();
            } else if (phase1) {
                phase1();
            } else if (phase2) {
                phase2();
            } else if (phase3) {
                phase3();
            }

        }

        if (actions.isEmpty()) {
            return new Stop().toJSON().toString();
        } else {
            return actions.get(0).toJSON().toString();
        }

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

        if (!actions.isEmpty()) {
            actions.remove(0);
        }

        manager.manage(s, flyingMap, d.left(), currents_coords);

    }

}
