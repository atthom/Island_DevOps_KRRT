package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 26/12/15.
 */
public class InitTerrestre extends AbstractPhase {

    public InitTerrestre(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d,m);
        actions.add(new Scout(Direction.N));
    }

    public AbstractPhase getNext() {
        return new ScoutPhase(parent,currents_coords,d,map);
    }


    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

}
