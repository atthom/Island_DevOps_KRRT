/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.*;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import org.json.JSONObject;

/**
 * Classe travaillant sur la stratégie du drone pour se déplacer
 * et scanner la map et trouver des points d'abordage avec un cout minimum
 * @author user
 */
public class FlyingStrategy extends Strategy {
    Coordinates currentCord;
    Heading h;
    int nbtours;
    Map flyingMap;
    AbstractAction lastaction;
    ManageReply manager;

    /**
     *
     * @param heading
     */
    public FlyingStrategy(String heading) {
        super();
        currentCord = new Coordinates(0,0);
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        manager = new ManageReply();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());

    }

    /**
     *
     * @param heading
     */
    public FlyingStrategy(Heading heading) {
        super();
        currentCord = new Coordinates(0,0);
        h = heading;
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        manager = new ManageReply();
    }

    String phase1() {
        switch (nbtours) {
            case 0:
                lastaction = new Echo(gauche(h.getValueParameter()));
                return lastaction.toJSON().toString();
            case 1:
                lastaction = new Echo(droite(h.getValueParameter()));
                return lastaction.toJSON().toString();
            case 2:
                lastaction = new Echo(h.getValueParameter());
                return lastaction.toJSON().toString();
            default:
                Coordinates c = flyingMap.get_lastcoordinate();
                FlyTile t = (FlyTile) flyingMap.getTile(c);
                if(t.getT() == Type.OUT_OF_RANGE) {
                    //generate();
                    phase2();
                }
                //while()
                if(h.getValueParameter() == Direction.E && currentCord.getX() < c.getX()) {
                    lastaction = new Fly();
                    currentCord.setX(currentCord.getX()+1);
                }
                if(h.getValueParameter() == Direction.N && currentCord.getY() < c.getY()) {
                    lastaction = new Fly();
                    currentCord.setX(currentCord.getY()+1);
                }
                if(h.getValueParameter() == Direction.W && currentCord.getX() < c.getX()) {
                    lastaction = new Fly();
                    currentCord.setX(currentCord.getX()-1);
                }
                if(h.getValueParameter() == Direction.S && currentCord.getY() < c.getY()) {
                    lastaction = new Fly();
                    currentCord.setX(currentCord.getY()-1);
                }
                return lastaction.toJSON().toString();
        }

    }

    String phase2() {
        lastaction = new Stop();
        return lastaction.toJSON().toString();
    }
    /**
     * execute les actions du drone
     * @return
     */
    @Override
    public String execute() {
        return phase1();
    }

    /**
     *
     * @param s l'object JSON (réponse) renvoyé par le moteur de jeu
     */
    @Override
    public void acknowledge(JSONObject s) {
        nbtours++;
        if (nbtours == 1) {
            manager.manage_echo(s, flyingMap, gauche(h.getValueParameter()));
        } else if (nbtours == 2) {
            manager.manage_echo(s, flyingMap, droite(h.getValueParameter()));
        }
        else if (nbtours == 3) {
            manager.manage_echo(s, flyingMap, h.getValueParameter());
        }
    }

}
