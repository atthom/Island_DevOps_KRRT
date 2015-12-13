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
 * Fait un demi tour simple vers la gauche
 * @author user
 */
public class TurnToOppositeLeft extends ComposedAction {

    public TurnToOppositeLeft(Coordinates c_current, Direction d) {
        super(c_current, d);
        
        super.add(new Heading(d.left()));
        super.add(new Scan());
        super.add(new Heading(d.left().left()));
        super.add(new Scan());

        maj_coord(d, c_current);
    }
    
    private void maj_coord(Direction d, Coordinates c_curent) {
        this.dir = d.opposite();
        switch (d) {
            case E:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() +2 );           
                break;
            case W:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() -2 );          
                break;
            case S:
                this.coords = new Coordinates(c_curent.getX() - 2, c_curent.getY());        
                break;
            default:
                this.coords = new Coordinates(c_curent.getX() +2 , c_curent.getY());
                break;
        }
    }

}
