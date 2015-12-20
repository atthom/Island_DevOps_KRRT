package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;

/**
 *
 * @author user
 */
public final class FlyAndEcho extends ComposedAction {

    public FlyAndEcho(Coordinates current, Direction dir, Direction dirEcho) {
        super(current, dir);
        super.add(new Fly());
        super.add(new Echo(dirEcho));
        maj_coord(current, dir);
    }

}