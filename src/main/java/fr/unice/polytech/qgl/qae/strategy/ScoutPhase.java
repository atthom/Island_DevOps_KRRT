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
public class ScoutPhase extends AbstractPhase {

    public ScoutPhase(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d,m);

        for(Direction dir : Direction.values()) {
            if (m.getGroundmap().getTile(currents_coords.getClose(dir)) == null) {
                actions.add(new Scout(dir));
            }
        }
    }

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