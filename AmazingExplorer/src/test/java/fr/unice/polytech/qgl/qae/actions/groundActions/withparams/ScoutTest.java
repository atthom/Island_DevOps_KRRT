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
public class ScoutTest {
    Scout s1, s2;
    
    
    public ScoutTest() {
    }
    
    @Before
    public void setUp() {
        s1 = new Scout(Direction.E);
        s2 = new Scout("{\"direction\":\"E\"}");
        assertEquals(s1,s2);
      
    }
    
    

    /**
     * Test of getValueParameter method, of class Scout.
     */
    @Test
    public void testGetValueParameter() {
        JSONObject o = new JSONObject("{\"action\":\"scout\",\"parameters\":{\"direction\":\"E\"}}");
        assertEquals(o.get("action"), s1.toJSON().get("action"));
        assertEquals(o.getJSONObject("parameters").getEnum(Direction.class, "direction"),
                s1.toJSON().getJSONObject("parameters").getEnum(Direction.class, "direction"));
        
    }
    
    
}
