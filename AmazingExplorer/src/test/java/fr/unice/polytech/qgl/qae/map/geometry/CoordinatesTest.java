/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CoordinatesTest {
    Coordinates c, c2;
    
    public CoordinatesTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(5, -6);
        c2 = new Coordinates(-5, 6);
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

    /**
     * Test of add method, of class Coordinates.
     */
    @Test
    public void testAdd() {
        c.add(c2);
        assertEquals(new Coordinates(0, 0), c);
    }

    /**
     * Test of coords_between method, of class Coordinates.
     */
    @Test
    public void testCoords_between() {
        Coordinates c3 = c.coords_between(c2);
        
        assertEquals(new Coordinates(-10, 12), c3);
    }

    /**
     * Test of vectorize method, of class Coordinates.
     */
    @Test
    public void testVectorize() {
        Vect2D v1 = c.vectorize();
        
        assertEquals(new Vect2D(c), v1);
               
    }

    /**
     * Test of addX method, of class Coordinates.
     */
    @Test
    public void testAddX() {
        c.addX(1);
        assertEquals(new Coordinates(6, -6), c);
    }

    /**
     * Test of addY method, of class Coordinates.
     */
    @Test
    public void testAddY() {
        c.addY(-1);
        assertEquals(new Coordinates(5, -7), c);
    }


  /**
   * Test of equals method, of class Coordinates.
   */
  @Test
  public void testEquals() {
    Coordinates cc = new Coordinates(5, -6);
    assertEquals(cc, c);
    assertNotSame(cc, c);
    assertNotEquals(cc, new Coordinates(5, 5));
  }

  /**
   * Test of getClose method, of class Coordinates.
   */
  @Test
  public void testGetClose() {
    assertEquals(new Coordinates(6, -6), c.getClose(Direction.E));
    assertEquals(new Coordinates(4, -6), c.getClose(Direction.W));
    assertEquals(new Coordinates(5, -5), c.getClose(Direction.N));
    assertEquals(new Coordinates(5, -7), c.getClose(Direction.S));
  }
    
}
