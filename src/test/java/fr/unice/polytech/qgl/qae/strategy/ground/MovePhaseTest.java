/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import org.junit.Before;

/**
 *
 * @author user
 */
public class MovePhaseTest {

    AbstractStrategy ex;
    AbstractPhase ph0, ph1;
    Objectif ob;

    public MovePhaseTest() {
    }

    @Before
    public void setUp() {
        GroundMap m = new GroundMap();
        ex = new FlyingStrategy(Direction.E, ob);
        ph0 = new InitTerrestre(ex, new Coordinates(0, 0), new FlyingMap(), m);
        ph1 = new MovePhase(ex, new Coordinates(0, 0), new FlyingMap(), m);

    }

}
