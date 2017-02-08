/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.simple;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ExploreTest {
    Explore e;
    public ExploreTest() {
    }
    
    @Before
    public void setUp() {
        e = new Explore();
      
    }
    
    @Test
    public void toJSON() {
          assertEquals(e.toJSON().get("action"), new JSONObject("{\"action\":\"explore\"}").get("action"));
    }

    
}
