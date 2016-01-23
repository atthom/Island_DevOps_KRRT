/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class Vect2DTest {

    Vect2D v1, v2, v3, v4, v5, v6, v7,v8;

    public Vect2DTest() {
    }

    @Before
    public void setUp() {
        v1 = new Vect2D(new Coordinates(0, 0));
        v2 = new Vect2D(new Coordinates(5, 0));
        v3 = new Vect2D(new Coordinates(4, -7));
        v4 = new Vect2D(new Coordinates(-1, 1), new Coordinates(5, -8));
        
        v5 = new Vect2D(new Coordinates(4, -5));
        
        v6 = new Vect2D(new Coordinates(8, -12));
        
        v7 = new Vect2D(new Coordinates(-1, 1), new Coordinates(3, -6));
        
        v8 = new Vect2D(new Coordinates(-2, 3));  
        
    }

    /**
     * Test of getDistance method, of class Vect2D.
     */
    @Test
    public void testGetDistance() {
        assertEquals(9, v5.getDistance());
        assertEquals(6 + 9, v4.getDistance());
    }

    /**
     * Test of is_colinear method, of class Vect2D.
     */
    @Test
    public void testIs_colinear() {
        assertTrue(v3.is_colinear(v5));
        assertTrue(v3.is_colinear(v4));
        assertTrue(v4.is_colinear(v8));  
        assertTrue(v3.is_colinear(v1));
    }

    /**
     * Test of toCoord method, of class Vect2D.
     */
    @Test
    public void testToCoord() {
        Coordinates c = v5.toCoord();
        assertEquals(new Coordinates(4, -5), c);
    
    }

    /**
     * Test of equals method, of class Vect2D.
     */
    @Test
    public void testEquals() {
         assertEquals(v3, v7);
    }


}
