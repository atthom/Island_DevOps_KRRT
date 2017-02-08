package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
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
    
    /**
     * Mise à jour des coordonnées et de la direction
     * @param c
     * @param dir
     */
    private void maj_coord(Coordinates c, Direction dir) {
        switch (dir) {
            case N:
                super.coords = new Coordinates(c.getX(), c.getY() +1 );
                break;
            case S:
                super.coords = new Coordinates(c.getX(), c.getY() -1 );
                break;
            case E:
                super.coords = new Coordinates(c.getX() +1, c.getY());
                break;
            default:
               super.coords = new Coordinates(c.getX() -1, c.getY());
                break;
        }
    }

}