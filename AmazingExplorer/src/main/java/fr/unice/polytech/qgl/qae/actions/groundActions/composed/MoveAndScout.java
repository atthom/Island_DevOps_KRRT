package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 19/12/15.
 */
public class MoveAndScout extends ComposedAction {

    public MoveAndScout(Coordinates current, Direction dir) {
        super(current, dir);
        super.add(new Scout(dir));
        super.add(new MoveTo(dir));
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
