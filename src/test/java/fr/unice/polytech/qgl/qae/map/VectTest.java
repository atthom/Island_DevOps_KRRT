/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class VectTest {
    Vect v;
    public VectTest() {
    }
    
    @Before
    public void setUp() {
        v=new Vect(4, Direction.E);
        v = new Vect(5, new Heading(Direction.E));
    }

    /**
     * Test of getValeur method, of class Vect.
     */
    @Test
    public void testGetValeur() {
        assertEquals(v.getValeur(), 5);
    }

    /**
     * Test of getD method, of class Vect.
     */
    @Test
    public void testGetD() {
        assertEquals(v.getD(), Direction.E);
    
    }

    /**
     * Test of issimilare method, of class Vect.
     */
    @Test
    public void testIssimilare() {
        assertTrue(v.colinear(v));
        assertTrue(v.colinear(new Vect(4, Direction.W)));
    }
    
}
