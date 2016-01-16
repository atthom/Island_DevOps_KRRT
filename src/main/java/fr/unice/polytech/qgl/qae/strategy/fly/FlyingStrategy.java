/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

/**
 *
 * @author Thom
 */
public class FlyingStrategy extends AbstractStrategy {

    final Direction first;

    public FlyingStrategy(Direction d, Objectif ob) {
        super(ob);
        this.first = d;
        setPhase(new Init(this, new Coordinates(0, 0), d, new FlyingMap()));
    }

    public Direction getFirst() {
        return first;
    }
}
