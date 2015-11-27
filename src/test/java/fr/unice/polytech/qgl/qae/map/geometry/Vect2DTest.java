/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class Vect2DTest {

    Vect2D v2;

    public Vect2DTest() {
    }

    @Before
    public void setUp() {
        v2 = new Vect2D(new Vect(5, Direction.E));
        v2 = new Vect2D(new Vect(4, Direction.E), new Vect(7, Direction.S));
    }

    /**
     * Test of add method, of class Vect2D.
     */
    @Test
    public void testAdd_Vect() {
    
    
    }

    /**
     * Test of getDistance method, of class Vect2D.
     */
    @Test
    public void testGetDistance() {
    }

    /**
     * Test of is_colinear method, of class Vect2D.
     */
    @Test
    public void testIs_colinear() {
    }

    /**
     * Test of add method, of class Vect2D.
     */
    @Test
    public void testAdd_Vect2D() {
    }

    /**
     * Test of toCoord method, of class Vect2D.
     */
    @Test
    public void testToCoord() {
    }

}
