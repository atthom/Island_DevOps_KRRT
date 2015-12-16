/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Explorer;
import fr.unice.polytech.qgl.qae.actions.composed.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class AbstractPhase {

    Map map;
    Coordinates currents_coords;
    Direction d;
    Explorer parent;
    boolean next = false;
    ArrayList<AbstractAction> actions;
    ManageReply manager;
    Direction old_direction;

    public AbstractPhase(Explorer parent, Coordinates currents_coords, Direction d) {
        this.currents_coords = currents_coords;
        this.d = d;
        manager = new ManageReply();
        actions = new ArrayList<>();
    }

    protected void nextphase(AbstractPhase p) {
        parent.setPhase(p);
    }

    protected void manageComposedAction(ComposedAction ac) {
        actions.addAll(ac.getAll());
        currents_coords = ac.getCoords();
        if (ac.getDir() != d) {
            old_direction = d;
            d = ac.getDir();
        }
    }

    protected void change_dir(Direction dd) {
        if (dd != d) {
            old_direction = d;
            d = dd;
            Heading h = new Heading(dd);
            actions.add(h);
            h.maj_coord(currents_coords, old_direction, dd);
        }
    }

    public Coordinates getCurrents_coords() {
        return currents_coords;
    }

    abstract void execute();

    protected void next_phase() {
        next = true;
    }

    public AbstractAction act() {

        if (actions.isEmpty()) {
            if (next) {
                nextphase(new Phase2(parent, currents_coords, d));
            }
            execute();
            if (next) {
                nextphase(new Phase2(parent, currents_coords, d));
            }

        }
        return actions.get(0);

    }

    public void acknowledge(JSONObject s) {
        Direction dd = d;
        if (!actions.isEmpty()) {
            JSONObject act = actions.get(0).toJSON();
            if (act.has("parameters") && act.getJSONObject("parameters").has("direction")) {
                dd = act.getJSONObject("parameters").getEnum(Direction.class, "direction");
            }
            actions.remove(0);
        }

        manager.manage(s, map, dd, currents_coords);
    }

}
