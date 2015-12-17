package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 05/12/15.
 */
public class Phase2 extends AbstractPhase {

    public Phase2(AbstractStrategy parent, Coordinates currents_coords, Direction d) {
        super(parent, currents_coords, d);
      map = new Map(new FlyTile());
    }
    
    @Override
    public AbstractAction execute() {
        //if (!next) {
        
            int dist = currents_coords.distance(map.getfirstground());
            manageComposedAction(new FlyUntil(dist, currents_coords, d));
            actions.add(new Stop());
            next = true;
        //}
        return actions.get(0);
    }

    @Override
    public void next() {
        
    }

}
