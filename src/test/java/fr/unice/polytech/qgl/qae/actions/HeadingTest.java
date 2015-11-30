/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
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
        h = new Heading("{\"direction\":\"N\"}");
    }

    @Test
    public void testSomeMethod() {
               
        JSONObject o = new JSONObject("{\"action\":\"heading\",\"parameters\":{\"direction\":\"N\"}}");
        assertEquals(o.get("action"), h.toJSON().get("action"));
        assertEquals(o.getJSONObject("parameters").getEnum(Direction.class, "direction"),
                h.toJSON().getJSONObject("parameters").getEnum(Direction.class, "direction"));
    }
    
}
