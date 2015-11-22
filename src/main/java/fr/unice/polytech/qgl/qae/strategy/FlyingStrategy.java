/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.*;
import fr.unice.polytech.qgl.qae.map.*;

import fr.unice.polytech.qgl.qae.reply.ManageReply;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class FlyingStrategy extends Strategy {
    int move = 0;
    Heading h;
    int nbtours;
    Map flyingMap;
    AbstractAction lastaction;
    ManageReply manager;
    Objectif o;

    public FlyingStrategy(String heading, Objectif o) {
        super();
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        manager = new ManageReply();
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        this.o = o;
    }

    public FlyingStrategy(Heading heading, Objectif o) {
        super();
        h = heading;
        nbtours = 0;
        flyingMap = new Map(new FlyTile());
        manager = new ManageReply();
        this.o = o;
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
                if(o.getBudget() < 6990)
                    lastaction = new Stop();
                if(h.getValueParameter() == Direction.E && move == flyingMap.getMaxXCord()-2 ) {
                    lastaction = new Heading(Direction.S);
                    move = 0;
                }
                if(h.getValueParameter() == Direction.W && move == flyingMap.getMinXCord()-2 ) {
                    lastaction = new Heading(Direction.S);
                    move = 0;
                }
                else
                    lastaction = new Fly();
                move++;
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
            manager.manage_echo(s, flyingMap, gauche(h.getValueParameter()), o);
        } else if (nbtours == 2) {
            manager.manage_echo(s, flyingMap, droite(h.getValueParameter()), o);
        }
        else if (nbtours == 3) {
            manager.manage_echo(s, flyingMap, h.getValueParameter(), o);
        }
    }

}
