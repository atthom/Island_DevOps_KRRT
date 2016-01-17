package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.composed.Glimpse360;
import fr.unice.polytech.qgl.qae.actions.groundActions.composed.MoveDiag;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

/**
 * Created by user on 26/12/15.
 */
public class InitTerrestre extends AbstractPhase {

    public InitTerrestre(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d,m);

        manageComposedAction(new Glimpse360(currents_coords,3));
        manageComposedAction(new MoveDiag(currents_coords,Direction.N, Direction.E,3));

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
            return new ScoutPhase(parent,currents_coords,d,map);
        else
            return  this;
    }


    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

}
