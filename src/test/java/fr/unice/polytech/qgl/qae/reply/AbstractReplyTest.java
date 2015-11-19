/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class AbstractReplyTest {
    AbstractReply ar;
    
    public AbstractReplyTest() {
    }
    
    @Before
    public void setUp() {
        ar = new FlyReply("{\"cost\":2,\"extras\":{},\"status\":\"OK\"}");
    }

    /**
     * Test of getCost method, of class AbstractReply.
     */
    @Test
    public void testGetCost() {
        assertEquals(ar.getCost(), 2);
    }

    /**
     * Test of getStatus method, of class AbstractReply.
     */
    @Test
    public void testGetStatus() {
        assertEquals(ar.getStatus(), true);     
    }
    
    /**
     * Test of addextra method, of class AbstractReply.
     */
    @Test
    public void testAddextra() {
        
    }
    
    @Test
    public void testEchoReply() {
        ar = new EchoReply("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        
    }
    
    /**
     *
     */
    @Test
    public void testScanReply() {
        ar = new ScanReply("{\"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": []}, \"status\": \"OK\"}");
    }
    
    
}
