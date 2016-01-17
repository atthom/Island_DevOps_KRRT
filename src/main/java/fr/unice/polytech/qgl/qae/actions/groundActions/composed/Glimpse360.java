package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Glimpse;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 16/01/16.
 */
public class Glimpse360 extends ComposedAction {
    public Glimpse360(Coordinates current, Direction dir, int nb) {
        super(current, dir);
        super.add(new Glimpse(Direction.N,nb));
        super.add(new Glimpse(Direction.E,nb));
        super.add(new Glimpse(Direction.S,nb));
        super.add(new Glimpse(Direction.W,nb));
    }
}
