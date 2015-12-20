/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
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

    final Map map;
    Coordinates currents_coords;
    Direction d;
    final AbstractStrategy parent;
    boolean next = false;
    final ArrayList<AbstractAction> actions;
    private final ManageReply manager;
    private Direction old_direction;

    public AbstractPhase(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        this.currents_coords = currents_coords;
        this.d = d;
        this.parent = parent;
        this.map = m;
        this.manager = new ManageReply();
        this.actions = new ArrayList<>();
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

    public abstract AbstractPhase getNext();
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPhase that = (AbstractPhase) o;

        if (!map.equals(that.map)) return false;
        if (!currents_coords.equals(that.currents_coords)) return false;
        if (d != that.d) return false;
        return parent.equals(that.parent);

    }

    @Override
    public int hashCode() {
        int result = map.hashCode();
        result = 31 * result + currents_coords.hashCode();
        result = 31 * result + d.hashCode();
        result = 31 * result + parent.hashCode();
        return result;
    }
}
