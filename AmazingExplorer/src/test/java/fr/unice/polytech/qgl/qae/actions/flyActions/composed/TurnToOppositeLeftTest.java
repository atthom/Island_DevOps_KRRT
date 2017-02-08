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
public class TurnToOppositeLeftTest {

    TurnToOppositeLeft ttolE, ttolS, ttolN, ttolW;
    Coordinates c;
    Direction E, S, N, W;

    public TurnToOppositeLeftTest() {
    }

    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        ttolE = new TurnToOppositeLeft(c, E);
        ttolS = new TurnToOppositeLeft(c, S);
        ttolW = new TurnToOppositeLeft(c, W);
        ttolN = new TurnToOppositeLeft(c, N);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(new Coordinates(0, 2),ttolE.getCoords() );
        assertEquals(E.opposite(),ttolE.getDir() );

        assertEquals( new Coordinates(0, -2),ttolW.getCoords());
        assertEquals(W.opposite(), ttolW.getDir());

        assertEquals(new Coordinates(2, 0), ttolS.getCoords());
        assertEquals(S.opposite() , ttolS.getDir());

        assertEquals(new Coordinates(-2, 0), ttolN.getCoords() );
        assertEquals(N.opposite(), ttolN.getDir());

    }

}
