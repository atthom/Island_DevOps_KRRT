package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 05/12/15.
 */
public class GoGround extends AbstractPhase {

    public GoGround(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);
        int dist = currents_coords.distance(map.getfirstground());

        manageComposedAction(new FlyUntil(dist, currents_coords, d));
    }

    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

    public AbstractPhase getNext() {
        if (actions.isEmpty()) {
            return new CreeksFinder(parent, currents_coords, d, map);
        } else {
            return this;
        }

    }

}
