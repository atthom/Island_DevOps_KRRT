package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

/**
 * Created by user on 26/12/15.
 */
public class ScoutPhase extends AbstractPhase {

    public ScoutPhase(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d,m);

        if(parent.getObjectif().getBudget() < 50) {
            actions.add(new Stop());
        }

        for(Direction dir : Direction.values()) {
            if (m.getGroundmap().getTile(currents_coords.getClose(dir)) == null) {
                actions.add(new Scout(dir));
            }
        }
    }

    @Override
    public AbstractPhase getNext() {
        if(actions.isEmpty())
            return new MovePhase(parent,currents_coords,d,map);
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
