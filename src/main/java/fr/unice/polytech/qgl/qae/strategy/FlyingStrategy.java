/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
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
    AbstractAction lastaction;
    ManageReply manager;
    Direction old_direction;
    boolean phase1 = true, phase2 = true, phase3 = true;
    int turnback = 0, flyandscan = 0, flyuntil = 0;

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
    }

    private Heading change_heading(Direction d) {
         old_direction = h.getValueParameter();
        h = new Heading(d);
        return h;
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

    }

    String phase1() {
        switch (nbtours) {
            case 0:
                lastaction = new Echo(h.getValueParameter().gauche());
                return lastaction.toJSON().toString();
            case 1:
                lastaction = new Echo(h.getValueParameter().droite());
                return lastaction.toJSON().toString();
            default:
                lastaction = new Echo(h.getValueParameter());
                phase1 = false;
                return lastaction.toJSON().toString();
        }
    }

    String turnaround() {
        switch (turnback) {
            case 0:
                turnback++;
                lastaction = change_heading(h.getValueParameter().gauche());
                return lastaction.toJSON().toString();
            case 1:
                turnback++;
                lastaction = new Fly();
                return lastaction.toJSON().toString();
            case 2:
                turnback++;
                lastaction = change_heading(h.getValueParameter().gauche());
                return lastaction.toJSON().toString();
            default:
                turnback = 0;
                lastaction = new Fly();
                return lastaction.toJSON().toString();
        }
    }

    String phase2() {
        //si on ne connais pas d'endoit ground ou aller...

        // sinon
        //Tile map.getTileground()
        // Donc comme ce n'est pas encore codé on part du principe qu'il y a de la terre dans notre map
        Direction d = Direction.E;
        try {
            d = flyingMap.go_ground(currents_coords);
        } catch (MapExeption ex) {
            phase2 = false;
            return phase3();
        }

        if (d == h.getValueParameter()) {
            lastaction = new Fly();
            return lastaction.toJSON().toString();
        } else {
            if(d.opposite() ==  h.getValueParameter()) {
                turnaround();
            }
            lastaction = change_heading(d);
            return lastaction.toJSON().toString();
        }
    }

    String flyandScan() {
        if (flyandscan == 0) {
            flyandscan++;
            lastaction = new Fly();
            return lastaction.toJSON().toString();
        } else {
            flyandscan = 0;
            lastaction = new Scan();
            return lastaction.toJSON().toString();
        }
    }

    String phase3() {
        //etat initial :  on connais une case de terre
        lastaction = new Stop();
        return lastaction.toJSON().toString();
    }

    /**
     * execute les actions du drone
     *
     * @return
     */
    @Override
    public String execute() {
        if (turnback > 0) {
            return turnaround();
        }
        if (flyandscan > 0) {
            return flyandScan();
        }

        //  flyingtest();
        if (phase1) {
            return phase1();
        } else if (phase2) {
            return phase2();
        } else if (phase3) {
            return phase3();
        }
        return phase3();
    }

    private String flyingtest() {
        for (int i = 0; i < 10; i++) {
            return flyandScan();
        }
        h = change_heading(h.getValueParameter());
        lastaction = h;

        for (int i = 0; i < 10; i++) {
            return flyandScan();
        }
        return new Stop().toJSON().toString();
    }

    private String flyaway(Coordinates c) {
        while (currents_coords.equals(c)) {
            lastaction = new Fly();
            return lastaction.toJSON().toString();
        }
        lastaction = new Stop();
        return lastaction.toJSON().toString();
    }

    void maj_coord() {
        if (null != old_direction) { 
            super.maj_pos(currents_coords, old_direction);   
            old_direction = null;
        }
        super.maj_pos(currents_coords, h.getValueParameter());
        flyingMap.put(currents_coords, new FlyTile(Type.UNKNOWN_TYPE));
        // currents_coords;
    }

    /**
     *
     * @param s l'object JSON (réponse) renvoyé par le moteur de jeu
     */
    @Override
    public void acknowledge(JSONObject s) {
        nbtours++;
        if (lastaction != null && lastaction.getName().equals("fly")) {
            maj_coord();
        }
        manager.manage(s, flyingMap, h.getValueParameter().gauche(), currents_coords);
    }

}
