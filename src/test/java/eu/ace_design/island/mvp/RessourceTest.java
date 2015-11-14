/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RessourceTest {

    Ressource r;

    public RessourceTest() {

    }

    @Before
    public void setUp() {
        r = new Ressource(10, "WOOD");
    }

    /**
     * Test of getNb method, of class Ressource.
     */
    @Test
    public void testGetNb() {
        assertEquals(10, r.getNb()); 
    }

    /**
     * Test of enleve method, of class Ressource.
     */
    @Test
    public void testEnleve() {
        r.enleve(2);
        assertEquals(8, r.getNb());
        r.enleve(20);
        assertEquals(8, r.getNb());
    }

    /**
     * Test of getName method, of class Ressource.
     */
    @Test
    public void testGetName() {
           assertEquals("WOOD", r.getName()); 
    }

}
