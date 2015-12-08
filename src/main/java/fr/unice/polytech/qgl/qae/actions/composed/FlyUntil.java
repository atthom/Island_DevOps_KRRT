/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public class FlyUntil extends ComposedAction {

    /**
     * Voler sur une distance donnée
     * @param nbfly distance de vol
     * @param current une coordonnée actuelle
     * @param dir une direction
     */
    public FlyUntil(int nbfly, Coordinates current, Direction dir) {
        super(current, dir);

        maj_coord(nbfly, current);
        for (int i = 0; i < nbfly; i++) {
            super.add(new Fly());
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
