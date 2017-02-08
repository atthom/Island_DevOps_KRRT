/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.simple;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyTest {
    Fly f;
    public FlyTest() {
    }
    
    @Before
    public void setUp() {
        f = new Fly();
    }

    @Test
    public void testSomeMethod() {
        assertEquals(new JSONObject("{ \"action\": \"fly\" }").get("action"), f.toJSON().get("action"));
    }
    
}
