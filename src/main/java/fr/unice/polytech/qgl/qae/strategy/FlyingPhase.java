/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class FlyingPhase extends AbstractPhase {

    public Direction d;
    protected Direction old_direction;
    
    public FlyingPhase(AbstractStrategy parent, Coordinates currents_coords, Direction d, FlyingMap m) {
        super(parent, currents_coords, d, m);
         this.d = d;
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

    @Override
    public void acknowledge(JSONObject s) {
        Direction dd = d;
        if (!actions.isEmpty()) {
            JSONObject act = actions.get(0).toJSON();
            if (act.has("parameters") && act.getJSONObject("parameters").has("direction")) {
                dd = act.getJSONObject("parameters").getEnum(Direction.class, "direction");
            }
            actions.remove(0);
        }
        
        super.acknowledge(s); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public AbstractPhase getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractAction execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
