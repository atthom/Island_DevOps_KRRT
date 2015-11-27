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
public class CoordinatesTest {
    Coordinates c;
    
    public CoordinatesTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(5, -6);
    }

    /**
     * Test of getX method, of class Coordinates.
     */
    @Test
    public void testGetX() {
        assertEquals(5, c.getX());
    }

    /**
     * Test of getY method, of class Coordinates.
     */
    @Test
    public void testGetY() {
        assertEquals(-6, c.getY());
    }

    /**
     * Test of distance method, of class Coordinates.
     */
    @Test
    public void testDistance_Coordinates() {
        assertEquals(12, c.distance(new Coordinates(0, 1)));
    }

    /**
     * Test of distance method, of class Coordinates.
     */
    @Test
    public void testDistance_0args() {
         assertEquals(11, c.distance());
    }
    
}
