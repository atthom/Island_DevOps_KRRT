/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 *
 * @author Thom
 */
public class FStrategy extends AbstractStrategy {

    public FStrategy(Direction d) {
        super();
        setPhase(new Init(this, new Coordinates(0, 0), d, new Map(new FlyTile())));
    }
        
    
}
