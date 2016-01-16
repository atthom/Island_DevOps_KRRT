package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.GroundPhase;

/**
 * Created by user on 26/12/15.
 */
public class InitTerrestre extends GroundPhase {

    public InitTerrestre(AbstractStrategy parent, Coordinates currents_coords, FlyingMap m, GroundMap gm) {
        super(parent, currents_coords, m, gm);

        actions.add(new Scout(Direction.N));
        /*
           for(int i =0; i<parent.getObjectif().getContract().size(); i++) {

        }

        actions.add(new Glimpse(Direction.N,3));
        actions.add(new Glimpse(Direction.S,3));
        actions.add(new Glimpse(Direction.E,3));
        actions.add(new Glimpse(Direction.W,3));
        */
    }

    @Override
    public AbstractPhase getNext() {
        if(actions.isEmpty())
            return new ScoutPhase(parent,currents_coords, map, gm);
        else
            return this;
    }


    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

}
