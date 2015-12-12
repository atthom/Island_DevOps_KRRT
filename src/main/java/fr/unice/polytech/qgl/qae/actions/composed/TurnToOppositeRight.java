/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Fait un demi tour simple vers la droite
 * @author user
 */
public class TurnToOppositeRight extends ComposedAction {
    
    public TurnToOppositeRight(Coordinates c, Direction d) {
        super(c, d);
        super.add(new Scan());
        super.add(new Heading(d.right()));
        super.add(new Scan());
        super.add(new Heading(d.right().right()));
        super.add(new Scan());

        maj_coord(d, c);
    }
    
       
    private void maj_coord(Direction d, Coordinates c_curent) {
        switch (d) {
            case E:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() -2 );
                this.dir = Direction.W;
                break;
            case W:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() +2 );
                this.dir = Direction.E;
                break;
            case S:
                this.coords = new Coordinates(c_curent.getX() + 2, c_curent.getY());
                this.dir = Direction.N;
                break;
            default:
                this.coords = new Coordinates(c_curent.getX()  - 2 , c_curent.getY());
                this.dir = Direction.S;
                break;
        }
    }
}
