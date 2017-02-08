package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 16/01/16.
 */
public class MoveDiag extends ComposedAction {
    public MoveDiag(Coordinates current, Direction dir, Direction dir2,int nb){
        super(current,dir);
        goTo(current,dir,dir2,nb);
    }

    public void goTo(Coordinates c,Direction dir,Direction dir2,int nb){
        super.coords = new Coordinates(c.getX(), c.getY());
        if(dir == Direction.N || dir == Direction.S) {
           if(dir2 == Direction.E || dir2 == Direction.W) {
               for(int i = 0; i<nb; i++)
                   maj_coord(super.coords,dir,dir2);
           }
            //else lever une erreur
        }
        else {
            if(dir2 == Direction.N || dir2 == Direction.S) {
                for(int i = 0; i<nb; i++)
                    maj_coord(super.coords,dir,dir2);            }
            //else lever une erreur
        }

    }

    /**
     * Mise à jour des coordonnées et de la direction
     *
     * @param c,dir,dir2,nb
     */

    private void maj_coord(Coordinates c, Direction dir,Direction dir2) {
            actions.add(new MoveTo(dir2));
            actions.add(new MoveTo(dir));
            if(dir == Direction.N && dir2 == Direction.E) {
                c.setX(c.getX() + 1);
                c.setY(c.getY() + 1);
            }
            if(dir == Direction.N && dir2 == Direction.W) {
                c.setX(c.getX() - 1);
                c.setY(c.getY() + 1);
            }
            if(dir == Direction.S && dir2 == Direction.E) {
                c.setX(c.getX() + 1);
                c.setY(c.getY() - 1);
            }
            if(dir == Direction.S && dir2 == Direction.W) {
                c.setX(c.getX() - 1);
                c.setY(c.getY() - 1);
            }

    }
}
