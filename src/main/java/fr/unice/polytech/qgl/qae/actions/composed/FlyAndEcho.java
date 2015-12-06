package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public final class FlyAndEcho extends ComposedAction {

    public FlyAndEcho(Coordinates current, Direction dir,Direction dirEcho) {
        super(current, dir);
        super.add(new Fly());
        super.add(new Echo(dirEcho));
        maj_coord(current, dir);
    }

}