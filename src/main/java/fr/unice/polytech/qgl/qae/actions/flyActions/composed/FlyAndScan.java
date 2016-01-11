/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.ComposedAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Pouvoir Voler Puis Scanner
 * @author user
 */
public final class FlyAndScan extends ComposedAction {
    
    /**
     * Pouvoir Voler et scanner
     * @param current une coordonnée actuelle
     * @param dir une direction
     */
    public FlyAndScan(Coordinates current, Direction dir) {
        super(current, dir);
        super.add(new Fly());
        super.add(new Scan());
        maj_coord(current, dir);
    }

    /**
     * Mise à jour des coordonnées et de la direction
     * @param c
     * @param dir
     */
    @Override
    public void maj_coord(Coordinates c, Direction dir) {
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
