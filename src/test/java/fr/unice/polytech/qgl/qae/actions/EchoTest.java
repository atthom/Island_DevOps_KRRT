/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class EchoTest {
    Echo e;
    
    public EchoTest() {
    }
    
    @Before
    public void setUp() {
        e = new Echo(Direction.E);
    }

    /**
     * Test of actionExecute method, of class Echo.
     */
    @Test
    public void testActionExecute() {
        assertEquals(e.toJSON().toString(), "{\"action\":\"echo\",\"parameters\":{\"direction\":\"E\"}}");
    }
    
}
