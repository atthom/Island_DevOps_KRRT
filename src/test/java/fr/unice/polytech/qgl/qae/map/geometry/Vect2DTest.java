/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.Direction;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class Vect2DTest {

    Vect2D v2, v3, v4, v5;

    public Vect2DTest() {
    }

    @Before
    public void setUp() {
        v2 = new Vect2D(new Vect(5, Direction.E));
        v3 = new Vect2D(new Vect(4, Direction.E), new Vect(7, Direction.S));
       
        
        v4 = new Vect2D(new Coordinates(-1, 1), new Coordinates(5, -8));
      
        v5 = new Vect2D(new Vect(5, Direction.S), new Vect(4, Direction.E));
               
        assertEquals(v3, v4);
        
        
    }

    /**
     * Test of add method, of class Vect2D.
     */
    @Ignore
    public void testAdd_Vect() {
        v3.add(v5);
        assertEquals(new Vect2D(new Vect(8, Direction.E), new Vect(12, Direction.S)), v3);
        v3.add(new Vect(5, Direction.N));
        assertEquals(new Vect2D(new Vect(8, Direction.E), new Vect(17, Direction.S)), v3);
    
    }

    /**
     * Test of getDistance method, of class Vect2D.
     */
    @Test
    public void testGetDistance() {
        assertEquals(9, v5.getDistance());
    }

    /**
     * Test of is_colinear method, of class Vect2D.
     */
    @Test
    public void testIs_colinear() {
        assertTrue(v3.is_colinear(v5));
        
        assertTrue(v3.is_colinear(v4));
    }

    /**
     * Test of add method, of class Vect2D.
     */
    @Ignore
    public void testAdd_Vect2D() {
        v3.add(v5);
        
        assertEquals(new Vect2D(new Coordinates(8, -12)), v3);
    }

    /**
     * Test of toCoord method, of class Vect2D.
     */
    @Test
    public void testToCoord() {
        Coordinates c = v5.toCoord();
        System.out.println("V5 x : " + v5.getV_x().getValeur() + " y :" + v5.getV_y().getValeur() );
        assertEquals(new Coordinates(4, -5), c);
    
    }

    /**
     * Test of getV_x method, of class Vect2D.
     */
    @Test
    public void testGetV_x() {
        
    }

    /**
     * Test of getV_y method, of class Vect2D.
     */
    @Test
    public void testGetV_y() {
    }

}
