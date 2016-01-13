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
public class FlyAndScanTest {
    FlyAndScan fsE, fsS, fsN, fsW ;
    Coordinates c;
    Direction E,S,N,W;
    
    public FlyAndScanTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0,0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        fsE = new FlyAndScan(c, E);
        fsS = new FlyAndScan(c, S);
        fsW = new FlyAndScan(c, W);
        fsN = new FlyAndScan(c, N);
        
    }

    /**
     * Test of maj_coord method, of class FlyAndScan.
     */
    @Test
    public void testMaj_coord() {
        assertEquals(fsE.getCoords(),new Coordinates(1, 0) );
        assertEquals(fsE.getDir(), E);

        assertEquals(fsW.getCoords(), new Coordinates(-1, 0));
        assertEquals(fsW.getDir(), W);

        assertEquals(fsS.getCoords(),new Coordinates(0, -1) );
        assertEquals(fsS.getDir(), S);

        assertEquals(fsN.getCoords(), new Coordinates(0, 1) );
        assertEquals(fsN.getDir(), N);
    }
    
}
