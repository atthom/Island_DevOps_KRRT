/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public final class FlyAndScan extends ComposedAction {
    
    public FlyAndScan(Coordinates current, Direction dir) {
        super(current, dir);
        super.add(new Fly());
        super.add(new Scan());
        maj_coord(current, dir);
    }
    
}
