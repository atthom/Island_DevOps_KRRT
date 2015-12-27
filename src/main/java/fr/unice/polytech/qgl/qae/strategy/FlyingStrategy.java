/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author Thom
 */
public class FlyingStrategy extends AbstractStrategy {
    final Direction first;
    public FlyingStrategy(Direction d) {
        super();
        this.first = d;
        setPhase(new Init(this, new Coordinates(0, 0), d, new Map()));
    }

    public Direction getFirst() {
        return first;
    }
}
