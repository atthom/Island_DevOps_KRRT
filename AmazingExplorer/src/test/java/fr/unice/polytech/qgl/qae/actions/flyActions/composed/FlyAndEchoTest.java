/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyAndEchoTest {
    FlyAndEcho feE, feS, feN, feW ;
    Coordinates c;
    Direction E,S,N,W;
    
    public FlyAndEchoTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0,0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        feE = new FlyAndEcho(c, E, Direction.E);
        feS = new FlyAndEcho(c, S, Direction.E);
        feW = new FlyAndEcho(c, W, Direction.E);
        feN = new FlyAndEcho(c, N, Direction.E);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(feE.getCoords(),new Coordinates(1, 0) );
        assertEquals(feE.getDir(), E);

        assertEquals(feW.getCoords(), new Coordinates(-1, 0));
        assertEquals(feW.getDir(), W);

        assertEquals(feS.getCoords(),new Coordinates(0, -1) );
        assertEquals(feS.getDir(), S);

        assertEquals(feN.getCoords(), new Coordinates(0, 1) );
        assertEquals(feN.getDir(), N);
    }
    
}
