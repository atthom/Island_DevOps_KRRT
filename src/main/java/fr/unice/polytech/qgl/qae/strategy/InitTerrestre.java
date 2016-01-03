package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Glimpse;
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
        /*
           for(int i =0; i<parent.getObjectif().getContract().size(); i++) {

        }

        actions.add(new Glimpse(Direction.N,3));
        actions.add(new Glimpse(Direction.S,3));
        actions.add(new Glimpse(Direction.E,3));
        actions.add(new Glimpse(Direction.W,3));
        */
    }

    public AbstractPhase getNext() {
        if(actions.isEmpty())
            return new ScoutPhase(parent,currents_coords,d,map);
        else
            return  this;
    }


    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

}
