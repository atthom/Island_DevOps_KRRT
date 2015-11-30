/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.exceptions.VectorExeption;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class VectTest {

    Vect v1, v2, v3, v4, v5, v6;

    public VectTest() {
    }

    @Before
    public void setUp() {
        v1 = new Vect(5, Direction.E);
        v2 = new Vect(-5, Direction.E);

        // valeur negative non cohérente donc valeur absolue 
        v3 = new Vect(5, new Heading(Direction.E));
        v4 = new Vect(5, Direction.W);
        v5 = new Vect(5, new Heading(Direction.S));

        v6 = new Vect(5, new Heading(Direction.N));
    }

    /**
     * Test of equals method, of class Vect.
     */
    @Test
    public void testEquals() {
        assertEquals(v1, v3);
        assertEquals(v1, v2);
        assertNotEquals(v1, v4);
    }

    /**
     * Test of colinear method, of class Vect.
     */
    @Test
    public void testColinear() {
        assertTrue(v1.colinear(v4));
        assertTrue(v1.colinear(v3));
        assertFalse(v1.colinear(v5));
        assertFalse(v1.colinear(v6));

    }

    /**
     * Test of getValeur method, of class Vect.
     */
    @Test
    public void testGetValeur() {

        assertEquals(5, v1.getValeur());
        assertEquals(5, v2.getValeur());

        assertEquals(-5, v4.getValeur());
    }

    /**
     * Test of is_xaxis method, of class Vect.
     */
    @Test
    public void testIs_xaxis() {

        assertTrue(v1.is_xaxis());
        assertTrue(v2.is_xaxis());
        assertTrue(v3.is_xaxis());

        assertFalse(v5.is_xaxis());
        assertFalse(v6.is_xaxis());
    }

    /**
     * Test of getD method, of class Vect.
     */
    @Test
    public void testGetD() {

        assertEquals(Direction.S, v5.getD());
        assertEquals(Direction.N, v6.getD());
        assertEquals(Direction.E, v2.getD());
    }

    /**
     * Test of toCoord method, of class Vect.
     */
    @Test
    public void testToCoord() {
        assertEquals(new Coordinates(5, 0), v1.toCoord());
        assertEquals(new Coordinates(5, 0), v2.toCoord());

        assertEquals(new Coordinates(-5, 0), v4.toCoord());

        assertEquals(new Coordinates(0, -5), v5.toCoord());
        assertEquals(new Coordinates(0, 5), v6.toCoord());

    }

}
