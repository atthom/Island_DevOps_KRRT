package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 17/01/16.
 */
public class MoveUntil extends ComposedAction {

    /**
     * Voler sur une distance donnée
     * @param nb distance de vol
     * @param current une coordonnée actuelle
     * @param dir une direction
     */
    public MoveUntil(Coordinates current, Direction dir, int nb) {
        super(current, dir);

        maj_coord(nb, current);
        for (int i = 0; i < nb; i++) {
            super.add(new MoveTo(dir));
        }
    }

    private void maj_coord(int nb, Coordinates c) {
        switch (dir) {
            case N:
                super.coords = new Coordinates(c.getX(), c.getY() + nb);
                break;
            case S:
                super.coords = new Coordinates(c.getX(), c.getY() - nb);
                break;
            case E:
                super.coords = new Coordinates(c.getX() + nb, c.getY());
                break;
            default:
                super.coords = new Coordinates(c.getX() - nb, c.getY());
                break;
        }
    }
}
