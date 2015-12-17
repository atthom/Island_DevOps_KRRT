/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author Thom
 */
public class FStrategy extends AbstractStrategy {

    public FStrategy(Direction d) {
        super();
        setPhase(new Phase1(this, new Coordinates(0, 0), d));
    }
        
    
}
