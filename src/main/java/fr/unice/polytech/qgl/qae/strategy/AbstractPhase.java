/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class AbstractPhase {

    public final FlyingMap map;
    public Coordinates currents_coords;
    
    protected final AbstractStrategy parent;
    protected boolean next = false;
    public final ArrayList<AbstractAction> actions;
    public AbstractPhase(AbstractStrategy parent, Coordinates currents_coords, FlyingMap m) {
        this.currents_coords = currents_coords;
        this.parent = parent;
        this.map = m;
        
        this.actions = new ArrayList<>();
    }

   

    

    public abstract AbstractPhase getNext();

    public abstract AbstractAction execute();

    public abstract void acknowledge(JSONObject s);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractPhase that = (AbstractPhase) o;

        if (!map.equals(that.map)) {
            return false;
        }
        if (!currents_coords.equals(that.currents_coords)) {
            return false;
        }
       
        return parent.equals(that.parent);

    }

    @Override
    public int hashCode() {
        int result = map.hashCode();
        result = 31 * result + currents_coords.hashCode();
        result = 31 * result + parent.hashCode();
        return result;
    }
}
