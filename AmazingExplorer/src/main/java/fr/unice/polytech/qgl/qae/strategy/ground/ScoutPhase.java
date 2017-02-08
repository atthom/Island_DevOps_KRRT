package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.GroundMap;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.GroundPhase;

/**
 * Created by user on 26/12/15.
 */
public class ScoutPhase extends GroundPhase {

    public ScoutPhase(AbstractStrategy parent, Coordinates currents_coords,FlyingMap m, GroundMap g) {
        super(parent, currents_coords,m, g);

        if(parent.getMission().getBudget() < 50) {
            actions.add(new Stop());
        }

        for(Direction dir : Direction.values()) {
            if (gm.getTile(currents_coords.getClose(dir)) == null) {
                actions.add(new Scout(dir));
            }
        }
    }

    @Override
    public AbstractPhase getNext() {
        if(actions.isEmpty())
            return new MovePhase(parent,currents_coords,map, gm);
        else
            return  this;
    }


    @Override
    // attention si la liste d'acton est vide
    public AbstractAction execute() {
        if(actions.isEmpty()) {
            actions.add(new Scout(Direction.N));
        }
        return actions.get(0);
    }

}
