/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public class PrettyTTOL extends ComposedAction {

    public PrettyTTOL(Coordinates c_current, Direction d) {
        super(c_current, d);
     
        super.add(new Heading(d.right()));
        
        super.add(new Heading(d));
       
        super.add(new Heading(d.left()));
       
        super.add(new Fly());
       
        super.add(new Heading(d.opposite()));
       
        super.add(new Fly());
        
        super.add(new Fly());
      
        maj_coord(d, c_current);
    }

    private void maj_coord(Direction d, Coordinates c_curent) {
        this.dir = d.opposite();

        switch (d) {
            case E:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() + 1);
                break;
            case W:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() - 1);
                break;
            case S:
                this.coords = new Coordinates(c_curent.getX() - 1, c_curent.getY());
                break;
            default:
                this.coords = new Coordinates(c_curent.getX() + 1, c_curent.getY());
                break;
        }
    }


}
