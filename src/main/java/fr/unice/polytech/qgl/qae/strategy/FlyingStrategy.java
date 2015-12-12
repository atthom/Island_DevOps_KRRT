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
import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
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
    Direction dir_to_echo;
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
        dir_to_echo = null;
        actions = new ArrayList<>();
    }

    private void change_heading(Direction dd) {
        if (dd != d) {
            old_direction = d;
            d = dd;
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
        
        if (flyingMap.have_ground()) {
            // si pas dans la bonne direction
            if (dir_to_echo != null) {
                if(d.opposite()==dir_to_echo.right()) {
                    turnleft=true;
                }
                change_heading(dir_to_echo);
                
            }
            
            phase1 = false;
            phase2();

        } else {
            dir_to_echo = flyingMap.best_dir(d);
            manageComposedAction(new FlyAndEcho(currents_coords, d, dir_to_echo));
        }

    }

    void phase2() {
        //si on ne connais pas d'endoit ground ou aller...
        int dist = currents_coords.distance(flyingMap.getfirstground());
        manageComposedAction(new FlyUntil(dist, currents_coords, d));
        
        phase2 = false;
        
    }

   
    void phase3() {
        //etat initial :  on est sur une case de terre
        if (flyingMap.last_is_ocean()) {
            phase3a();
        } else if (flyingMap.three_last_are_ground()) {
            phase3b();
        } else {
            actions.add(new Scan());
            manageComposedAction(new FlyAndScan(currents_coords, d));
        }
        if (flyingMap.already_here(currents_coords)) {
            phase3 = false;
        }
    }

    void phase3a() {
        if (flyingMap.three_last_are_ocean()) {
            if (flyingMap.ten_last_are_ocean()) {
                phase3 = false;
            } else {
                phase3b();
            }
        } else {
            manageComposedAction(new FlyAndScan(currents_coords, d));
        }
    }

    void phase3b() {
        if (turnleft) {
            manageComposedAction(new TurnToOppositeLeft(currents_coords, d));
            change_heading(d.left());
            
            turnleft = false;
        } else {
            manageComposedAction(new TurnToOppositeRight(currents_coords, d));
             change_heading(d.right());
            turnleft = true;
        }
    }
    
 void manageComposedAction(ComposedAction ac) {
        actions.addAll(ac.getAll());
        currents_coords = ac.getCoords();
        if(ac.getDir() != d) {
            old_direction = d;
            d = ac.getDir();
        }
      
        //   change_heading(ac.getDir());
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
        Direction dd = d;

        if (!actions.isEmpty()) {
            JSONObject act = actions.get(0).toJSON();
            if (act.has("parameters") && act.getJSONObject("parameters").has("direction")) {
                dd = act.getJSONObject("parameters").getEnum(Direction.class, "direction");
            }
            actions.remove(0);
        }

        manager.manage(s, flyingMap, dd, currents_coords);

    }

}
