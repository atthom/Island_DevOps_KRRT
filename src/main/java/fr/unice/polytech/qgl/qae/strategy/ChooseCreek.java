package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Land;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 20/12/2015.
 */
public class ChooseCreek  extends AbstractPhase{

    public ChooseCreek(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);
    }

    @Override
    public AbstractPhase getNext() {
        return this;
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty()) {
            if(map.last_have_creek()) {
                actions.add(new Land(map.getlast_creek(), 1));
            }
            actions.add(new Stop());
        }
        return actions.get(0);
    }
}
