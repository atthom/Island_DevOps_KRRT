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
public class PrettyTTOLTest {
    PrettyTTOL PrettyttolE, PrettyttolS, PrettyttolN, PrettyttolW ;
    Coordinates c;
    Direction E,S,N,W;
    
    public PrettyTTOLTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0,0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        PrettyttolE = new PrettyTTOL(c, E);
        PrettyttolS = new PrettyTTOL(c, S);
        PrettyttolW = new PrettyTTOL(c, W);
        PrettyttolN = new PrettyTTOL(c, N);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(PrettyttolE.getCoords(), new Coordinates(0, 1));
        assertEquals(PrettyttolE.getDir(), E.opposite());

        assertEquals(PrettyttolW.getCoords(), new Coordinates(0, -1));
        assertEquals(PrettyttolW.getDir(), W.opposite());

        assertEquals(PrettyttolS.getCoords(), new Coordinates(-1, 0));
        assertEquals(PrettyttolS.getDir(), S.opposite());

        assertEquals(PrettyttolN.getCoords(), new Coordinates(1, 0));
        assertEquals(PrettyttolN.getDir(), N.opposite());
    }
    
}
