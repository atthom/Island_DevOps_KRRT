/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class HeadingTest {
    Heading h;
    public HeadingTest() {
    }
    
    @Before
    public void setUp() {
        h = new Heading(Direction.E);
    }

    @Test
    public void testSomeMethod() {
        h = new Heading("{\"direction\":\"N\"}");
        assertEquals(h.toJSON().toString(), new JSONObject("{\"action\":\"heading\",\"parameters\":{\"direction\":\"N\"}}").toString());
    }
    
}
