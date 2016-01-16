/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class GlimpseTest {
    Glimpse gE, gJ;
    
    
    public GlimpseTest() {
    }
    
    @Before
    public void setUp() {
        gE = new Glimpse(Direction.E, 2);
    }

    /**
     * Test of getValueParameter method, of class Glimpse.
     */
    @Test
    public void testGetValueParameter() {
        JSONObject o = new JSONObject("{ \"action\": \"glimpse\", \"parameters\": { \"direction\": \"E\", \"range\": 2 } }");
        JSONObject paraO = o.getJSONObject("parameters");
        JSONObject parage = gE.toJSON().getJSONObject("parameters");
        assertEquals(o.get("action"), gE.toJSON().get("action"));
        assertEquals(paraO.getEnum(Direction.class, "direction"), parage.getEnum(Direction.class, "direction"));
        assertEquals(paraO.getInt("range"), parage.getInt("range"));
     
    }
    
}
