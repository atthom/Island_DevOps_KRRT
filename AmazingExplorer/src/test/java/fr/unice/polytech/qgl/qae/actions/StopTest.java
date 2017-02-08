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
public class StopTest {
    Stop s;
    public StopTest() {
    }
    
    @Before
    public void setUp() {
        s = new Stop();
    }

    @Test
    public void testSomeMethod() {
        assertEquals(s.toJSON().get("action"), new JSONObject("{\"action\":\"stop\"}").get("action"));
    }
    
}
