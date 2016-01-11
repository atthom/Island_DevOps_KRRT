/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.strategy.ground.MovePhase;
import fr.unice.polytech.qgl.qae.strategy.ground.InitTerrestre;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author user
 */
public class MovePhaseTest {

    AbstractStrategy ex;
    AbstractPhase ph0,ph1;
    Objectif ob;

    public MovePhaseTest() {
    }

    @Before
    public void setUp() {
        Map m = new Map();
        ex = new FlyingStrategy(Direction.E, ob);
        ph0 = new InitTerrestre(ex,new Coordinates(0, 0),Direction.E, m);
        ph1 = new MovePhase(ex,new Coordinates(0, 0), Direction.E, m);

    }


}