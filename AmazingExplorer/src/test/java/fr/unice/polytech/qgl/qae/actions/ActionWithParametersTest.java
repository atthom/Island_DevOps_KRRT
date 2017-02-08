/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.*;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ActionWithParametersTest {
    ActionWithParameters awp;
    public ActionWithParametersTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    /**
     * Test of toJSON method, of class ActionWithParameters.
     */
    @Test
    public void testEchoToJSON() {
        awp = (ActionWithParameters) new Echo(Direction.E);
        JSONObject o = new JSONObject("{\"action\":\"echo\",\"parameters\":{\"direction\":\"E\"}}");
         
        assertEquals(o.get("action"), awp.toJSON().get("action"));
        
        assertEquals(o.getJSONObject("parameters").getEnum(Direction.class, "direction"), awp.toJSON().getJSONObject("parameters").get("direction"));
    }
    
     /**
     * Test of toJSON method, of class ActionWithParameters.
     */
    @Test
    public void testHeadingToJSON() {
        awp =(ActionWithParameters) new Heading(Direction.S);
        String b = "{ \"action\": \"heading\", \"parameters\": { \"direction\": \"S\" } }";
        assertEquals(awp.toJSON().toString(), new JSONObject(b).toString());
        
    }
    


    
}
