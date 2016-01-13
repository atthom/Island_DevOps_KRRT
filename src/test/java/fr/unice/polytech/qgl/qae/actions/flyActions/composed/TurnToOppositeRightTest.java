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
public class TurnToOppositeRightTest {
    TurnToOppositeRight ttorE, ttorS, ttorN, ttorW ;
    Coordinates c;
    Direction E,S,N,W;
    
    public TurnToOppositeRightTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0,0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        ttorE = new TurnToOppositeRight(c, E);
        ttorS = new TurnToOppositeRight(c, S);
        ttorW = new TurnToOppositeRight(c, W);
        ttorN = new TurnToOppositeRight(c, N);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(ttorE.getCoords(), new Coordinates(0, -2));
        assertEquals(ttorE.getDir(), E.opposite());
        
        assertEquals(ttorW.getCoords(), new Coordinates(0, 2));
        assertEquals(ttorW.getDir(), W.opposite());
        
        assertEquals(ttorS.getCoords(), new Coordinates(2, 0));
        assertEquals(ttorS.getDir(), S.opposite());
        
        assertEquals(ttorN.getCoords(), new Coordinates(-2, 0));
        assertEquals(ttorN.getDir(), N.opposite());
    }
    
}
