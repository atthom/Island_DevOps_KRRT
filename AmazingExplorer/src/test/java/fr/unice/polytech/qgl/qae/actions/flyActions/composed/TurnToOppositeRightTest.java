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
        assertEquals( new Coordinates(0, -2),ttorE.getCoords());
        assertEquals(E.opposite(),ttorE.getDir());
        
        assertEquals(new Coordinates(0, 2),ttorW.getCoords());
        assertEquals(W.opposite(), ttorW.getDir());
        
        assertEquals(new Coordinates(-2, 0) , ttorS.getCoords());
        assertEquals(S.opposite(), ttorS.getDir());
        
        assertEquals(new Coordinates(2, 0), ttorN.getCoords());
        assertEquals(N.opposite(),ttorN.getDir());
    }
    
}
