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
    AbstractStrategy parent;
    boolean next = false;
    ArrayList<AbstractAction> actions;
    ManageReply manager;
    Direction old_direction;
 private static Phase2 instance = null;
    public AbstractPhase(AbstractStrategy parent, Coordinates currents_coords, Direction d) {
        this.currents_coords = currents_coords;
        this.d = d;
        this.parent = parent;
        manager = new ManageReply();
        actions = new ArrayList<>();
    }
    
    
    protected void setnext(AbstractPhase p) {
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
    
    public abstract void next();

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
    
    public abstract AbstractAction execute();
    

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
