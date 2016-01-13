/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ParameterTest {
    Parameter p;
    public ParameterTest() {
    }
    
    @Before
    public void setUp() {
        p = new Parameter("Direction", Direction.E);
    }

    /**
     * Test of getArgument method, of class Parameter.
     */
    @Test
    public void testGetArgument() {
        assertEquals(p.getArgument(), "Direction");
    }

    /**
     * Test of getValeur method, of class Parameter.
     */
    @Test
    public void testGetValeur() {
        assertEquals(p.getValeur(), Direction.E);
    
    }

    /**
     * Test of equals method, of class Parameter.
     */
    @Test
    public void testEquals() {
    }
    
}
