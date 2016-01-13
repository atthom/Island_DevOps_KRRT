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
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Tourner et scanner ( fait un 3/4 de tour)
 * @author user
 */
public class TurnAround extends ComposedAction {

    public TurnAround(Coordinates c_current, Direction d) {
        super(c_current, d);
        super.add(new Heading(d.left()));
        super.add(new Scan());
        super.add(new Heading(d.left().left()));
        super.add(new Scan());
        super.add(new Heading(d.left().left().left()));
        super.add(new Scan());
        super.add(new Fly());
        maj_coord(d, c_current);
    }

    private void maj_coord(Direction d, Coordinates c_curent) {
        switch (d) {
            case E:
                this.coords = new Coordinates(c_curent.getX() - 1, c_curent.getY());
                this.dir = Direction.S;
                break;
            case W:
                this.coords = new Coordinates(c_curent.getX() + 1, c_curent.getY());
                this.dir = Direction.N;
                break;
            case S:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() + 1);
                this.dir = Direction.W;
                break;
            default:
                this.coords = new Coordinates(c_curent.getX(), c_curent.getY() - 1);
                this.dir = Direction.E;
                break;
        }

    }
}
