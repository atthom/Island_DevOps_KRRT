/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.GroundMap;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class GroundReplyManagerTest {
    GroundReplyManager grm;
    GroundMap gm;
    public GroundReplyManagerTest() {
    }
    
    @Before
    public void setUp() {
        grm = new GroundReplyManager();
        gm = new GroundMap();
    }

   /**
     * Test of manage_scoot method, of class ManageReply.
     */
    @Test
    public void testManage_scoot(){
        JSONObject scoot_reply = new JSONObject("{ \"cost\": 5, \"extras\": { \"altitude\": 5, \"resources\": [\"FUR\", \"WOOD\"] }, \"status\": \"OK\" }");
        
        grm.manage(scoot_reply, gm, Direction.E, new Coordinates(5, 5));
        GroundTile g = gm.getLastTile().getValue();
        assertEquals(5, g.getAltitude());
       
        PrimaryResource fur = new PrimaryResource();
        fur.setName("FUR");
        PrimaryResource wood = new PrimaryResource();
        wood.setName("WOOD");
        assertEquals(fur, g.getRessource().get(0));
        assertEquals(wood, g.getRessource().get(1));
        assertEquals(2,g.getRessource().size());
    
    }
    
}
