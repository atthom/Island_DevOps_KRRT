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
public class AbstractActionTest {
    AbstractAction aa;
    
    public AbstractActionTest() {
    }
    
    @Before
    public void setUp() {
        aa = new Scan();
    }

    /**
     * Test of getName method, of class AbstractAction.
     */
    @Test
    public void testGetName() {
        assertEquals(aa.getName(), "scan");
    }

    /**
     * Test of setActionCost method, of class AbstractAction.
     */
    @Test
    public void testSetGetActionCost() {
        assertEquals(aa.getActionCost(), 0);
        aa.setActionCost(3);
        assertEquals(aa.getActionCost(),3);
    }

    /**
     * Test of toJSON method, of class AbstractAction.
     */
    @Test
    public void testScanToJSON() {
        JSONObject o = new JSONObject("{ \"action\": \"scan\" }");
        assertEquals(aa.toJSON().toString(), o.toString());
    }
    
    /**
     * Test of toJSON method, of class AbstractAction.
     */
    @Test
    public void testFlyToJSON() {
        JSONObject o = new JSONObject("{ \"action\": \"fly\" }");
        aa = new Fly();
        assertEquals(aa.toJSON().toString(), o.toString());
    }
    
        /**
     * Test of toJSON method, of class AbstractAction.
     */
    @Test
    public void testStopToJSON() {
        JSONObject o = new JSONObject("{ \"action\": \"stop\" }");
        aa = new Stop();
        assertEquals(aa.toJSON().toString(), o.toString());
    }
    
}
