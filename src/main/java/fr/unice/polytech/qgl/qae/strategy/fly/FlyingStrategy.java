/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.resources.Contract;
import fr.unice.polytech.qgl.qae.resources.MissionAssignment;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

import java.util.ArrayList;

/**
 *
 * @author Thom
 */
public class FlyingStrategy extends AbstractStrategy {

    final Direction first;
    private MissionAssignment mission;

    public FlyingStrategy(Direction theHeading, MissionAssignment theMission) {
        super(theMission);
        this.first = theHeading;
        setPhase(new Init(this, new Coordinates(0, 0), theHeading, new Map()));
    }

    public Direction getFirst() {
        return first;
    }
}
