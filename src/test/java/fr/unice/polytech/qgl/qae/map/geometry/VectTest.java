/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.exceptions.VectorExeption;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        v = new Vect(5, Direction.E);
        v = new Vect(-5, Direction.E);
        // valeur negative non cohérente donc valeur absolue 
        v = new Vect(5, new Heading(Direction.E));
    }

    /**
     * Test of equals method, of class Vect.
     */
    @Test
    public void testEquals() {
        assertEquals(v, new Vect(5, Direction.E));

    }

    /**
     * Test of colinear method, of class Vect.
     */
    @Test
    public void testColinear() {
        assertTrue(v.colinear(new Vect(5, Direction.W)));
        assertTrue(v.colinear(new Vect(2, Direction.E)));
        assertFalse(v.colinear(new Vect(2, Direction.N)));
        assertFalse(v.colinear(new Vect(0, Direction.S)));

    }

    /**
     * Test of getValeur method, of class Vect.
     */
    @Test
    public void testGetValeur() {
         v = new Vect(5, new Heading(Direction.E));
        assertEquals(5, v.getValeur());

        v = new Vect(5, new Heading(Direction.W));
        assertEquals(-5, v.getValeur());

       
    }

    /**
     * Test of add method, of class Vect.
     */
    @Test
    public void testAdd() {
        v = new Vect(5, new Heading(Direction.E));
        try {
            v.add(new Vect(3, Direction.E));
            assertEquals(8, v.getValeur());
            assertEquals(v.getD(), Direction.E);

            v.add(new Vect(5, Direction.W));
            assertEquals(3, v.getValeur());
            assertEquals(v.getD(), Direction.E);

            v.add(new Vect(5, Direction.W));
            assertEquals(-2, v.getValeur());
            assertEquals(v.getD(), Direction.W);
        } catch (VectorExeption ex) {
            fail("Should not fail");
        }

        try {
            v.add(new Vect(5, Direction.S));
            fail("This should fail !");
        } catch (Exception e) {

        }

    }

    /**
     * Test of is_xaxis method, of class Vect.
     */
    @Test
    public void testIs_xaxis() {
         v = new Vect(5, new Heading(Direction.E));
        assertTrue(v.is_xaxis());
        v = new Vect(5, new Heading(Direction.W));
       assertTrue(v.is_xaxis());

        v = new Vect(5, Direction.S);
        assertFalse(v.is_xaxis());
        v = new Vect(5, Direction.N);
        assertFalse(v.is_xaxis());
    }

    /**
     * Test of getD method, of class Vect.
     */
    @Test
    public void testGetD() {
        v = new Vect(5, Direction.S);
        assertEquals(v.getD(), Direction.S);
    }

}
