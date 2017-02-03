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
public class LandTest {
    Land l;
    
    public LandTest() {
    }
    
    @Before
    public void setUp() {
    
        l = new Land("la", 8);
    }

    /**
     * Test of getValueParameter method, of class Land.
     */
    @Test
    public void testToJSON() {
        JSONObject o = new JSONObject("{ \"action\": \"land\", \"parameters\": { \"creek\": \"la\", \"people\": 8}}");
        
        assertEquals(o.get("action"), l.toJSON().get("action"));
        
        assertEquals(o.getJSONObject("parameters").get("creek"), l.toJSON().getJSONObject("parameters").get("creek"));
        assertEquals(o.getJSONObject("parameters").get("people"), l.toJSON().getJSONObject("parameters").get("people"));
    }
    
}
