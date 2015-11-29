/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import com.vividsolutions.jts.geom.Coordinate;
import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Echo;
import fr.unice.polytech.qgl.qae.actions.Fly;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.actions.Scan;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
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
    boolean phase1 = true, phase2 = true, phase3 = true;
    int turnback = 0, flyandscan = 0, flyuntil = 0;
    int ind = 1;
    /**
     *
     * @param heading
     */
    public FlyingStrategy(String heading) {
        super();
        int i = 0;
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        manager = new ManageReply();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        currents_coords = new Coordinates(0, 0);
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
        
    }

    String phase1() {
        switch (nbtours) {
            case 0:
                lastaction = new Echo(gauche(h.getValueParameter()));
                return lastaction.toJSON().toString();
            case 1:
                ind++;
                lastaction = new Echo(droite(h.getValueParameter()));
                return lastaction.toJSON().toString();
            case 2:
                ind++;
                lastaction = new Echo(h.getValueParameter());
                return lastaction.toJSON().toString();
            default:
                Coordinates c = flyingMap.get_coordinate(ind);
                //Coordinates c = flyingMap.get_lastcoordinate();
                FlyTile t = (FlyTile) flyingMap.getTile(c);

                if(t.getT() == Type.OUT_OF_RANGE) {
                    flyingMap.generate();
                    phase2();
                }

                if(h.getValueParameter() == Direction.E) {
                    if(currents_coords.getX() < 10) {
                        lastaction = new Fly();
                        currents_coords.setX(currents_coords.getX() + 1);
                    }
                    else
                        phase1 = false;
                        phase2();
                        //lastaction = new Echo(h.getValueParameter());
                }

                if(h.getValueParameter() == Direction.N) {
                    if(currents_coords.getY() < c.getY()) {
                        lastaction = new Fly();
                        currents_coords.setY(currents_coords.getY()+1);
                    }
                    else {
                        phase1 = false;
                        phase2();
                    }
                }

                if(h.getValueParameter() == Direction.W) {
                    if(currents_coords.getX() < c.getX()) {
                        lastaction = new Fly();
                        currents_coords.setX(currents_coords.getX()-1);
                    }
                    else {
                        phase1 = false;
                        phase2();
                    }
                }

                if(h.getValueParameter() == Direction.S) {
                    if(currents_coords.getY() < c.getY()) {
                        lastaction = new Fly();
                        currents_coords.setY(currents_coords.getY()-1);
                    }
                    else {
                        phase1 = false;
                        phase2();
                    }
                }

                return lastaction.toJSON().toString();
        }
    }

    String turnaround() {
        switch (turnback) {
            case 0:
                turnback++;
                return new Heading(gauche(h.getValueParameter())).toJSON().toString();
            case 1:
                turnback++;
                return new Fly().toJSON().toString();
            case 2:
                turnback++;
                return new Heading(gauche(h.getValueParameter())).toJSON().toString();
            default:
                turnback = 0;
                return new Fly().toJSON().toString();
        }
    }
    
    String phase2() {
        //si on ne connais pas d'endoit ground ou aller...
        
        
        // sinon
        //Tile map.getTileground()
       // Donc comme ce n'est pas encore codé on part du principe qu'il y a de la terre dans notre map
        Direction d = Direction.E;
        try {
            d = flyingMap.goaway(currents_coords);
            System.out.println(d);
        } catch (MapExeption ex) {
            phase2 = false;
            return phase3();
        }     
        
        if(d==h.getValueParameter()) {
            lastaction = new Fly();
            return lastaction.toJSON().toString();
        } else {
            lastaction = new Heading(d);
            return lastaction.toJSON().toString();
        }

    }

    String flyandScan() {
        if (flyandscan == 0) {
            flyandscan++;
            return new Fly().toJSON().toString();
        } else {
            flyandscan = 0;
            return new Scan().toJSON().toString();
        }
    }

    String phase3() {
        //etat initial :  on connais une case de terre

        return new Stop().toJSON().toString();
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

        if (phase1) {
            return phase1();
        } else if (phase2) {
            return phase2();
        }else if (phase3) {
            return phase3();
        }
        return phase3();
    }
    
    private String flyaway(Coordinates c) {
        while(currents_coords.equals(c)) {
            return new Fly().toJSON().toString();
        }
        return new Stop().toJSON().toString();
    }

    private void maj_coord() {

        switch (h.getValueParameter()) {
            case E:
                currents_coords.addX(1);
                break;
            case N:
                currents_coords.addY(1);
                break;
            case S:
                currents_coords.addY(-1);
                break;
            case W:
                currents_coords.addX(-1);
                break;
            default:
                break;
        }
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
        if (lastaction!=null && lastaction.getName().equals("fly")) {
            maj_coord();
        }
        if(nbtours == 1)
            manager.manage(s, flyingMap, gauche(h.getValueParameter()));
        else if(nbtours == 2)
            manager.manage(s, flyingMap, droite(h.getValueParameter()));
        else if(nbtours == 3)
            manager.manage(s, flyingMap, h.getValueParameter());

    }

}
