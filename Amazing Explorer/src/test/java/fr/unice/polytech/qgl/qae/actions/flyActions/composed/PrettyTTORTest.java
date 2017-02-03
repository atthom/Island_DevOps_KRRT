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
public class PrettyTTORTest {
    PrettyTTOR PrettyttorE, PrettyttorS, PrettyttorN, PrettyttorW ;
    Coordinates c;
    Direction E,S,N,W;
    
    public PrettyTTORTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0,0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        PrettyttorE = new PrettyTTOR(c, E);
        PrettyttorS = new PrettyTTOR(c, S);
        PrettyttorW = new PrettyTTOR(c, W);
        PrettyttorN = new PrettyTTOR(c, N);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(new Coordinates(0, -1),PrettyttorE.getCoords() );
        assertEquals(E.opposite(),PrettyttorE.getDir());
        
        assertEquals(new Coordinates(0, 1), PrettyttorW.getCoords() );
        assertEquals(W.opposite(), PrettyttorW.getDir() );
        
        assertEquals(new Coordinates(-1, 0),PrettyttorS.getCoords() );
        assertEquals(S.opposite(),PrettyttorS.getDir() );
        
        assertEquals(new Coordinates(1, 0), PrettyttorN.getCoords());
        assertEquals(N.opposite(),PrettyttorN.getDir() );
    }
    
}
