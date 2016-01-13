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
        assertEquals(ttolE.getCoords(), new Coordinates(0, 2));
        assertEquals(ttolE.getDir(), E.opposite());

        assertEquals(ttolW.getCoords(), new Coordinates(0, -2));
        assertEquals(ttolW.getDir(), W.opposite());

        assertEquals(ttolS.getCoords(), new Coordinates(-2, 0));
        assertEquals(ttolS.getDir(), S.opposite());

        assertEquals(ttolN.getCoords(), new Coordinates(2, 0));
        assertEquals(ttolN.getDir(), N.opposite());

    }

}
