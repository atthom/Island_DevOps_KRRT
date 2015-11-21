/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Echo;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.map.FlyTile;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Tile;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class FlyingStrategy extends Strategy {

    Heading h;
    int nbtours;
    Map flyingMap;
    AbstractAction lastaction;
    ManageReply manager;

    public FlyingStrategy(String heading) {
        super();
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        manager = new ManageReply();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());

    }

    public FlyingStrategy(Heading heading) {
        super();
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
            default:
                lastaction = new Stop();
                return lastaction.toJSON().toString();
        }

    }

    @Override
    public String execute() {
        return phase1();
    }

    @Override
    public void acknowledge(JSONObject s) {
        nbtours++;
        if (nbtours == 1) {
           
            manager.manage_echo(s, flyingMap, gauche(h.getValueParameter()));
        } else if (nbtours == 2) {

            manager.manage_echo(s, flyingMap, droite(h.getValueParameter()));
        }

    }

}
