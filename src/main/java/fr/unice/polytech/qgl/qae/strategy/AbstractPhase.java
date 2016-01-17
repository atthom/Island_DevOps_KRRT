/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import java.util.ArrayList;
import java.util.Objects;
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
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.map);
        hash = 83 * hash + Objects.hashCode(this.currents_coords);
        hash = 83 * hash + Objects.hashCode(this.actions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractPhase other = (AbstractPhase) obj;
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.currents_coords, other.currents_coords)) {
            return false;
        }
        return Objects.equals(this.actions, other.actions);
    }

    
}
