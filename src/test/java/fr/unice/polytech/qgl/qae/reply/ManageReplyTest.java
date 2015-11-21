/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.map.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.Vect;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author user
 */
public class ManageReplyTest {
    ManageReply manager;
    Map map;
    public ManageReplyTest() {
    }
    
    @Before
    public void setUp() {
        manager = new ManageReply();
        map = new Map(new FlyTile());
    }

    /**
     * Test of manage_echo method, of class ManageReply.
     */
    @Test
    public void testManage_echo() {
        JSONObject o = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        manager.manage_echo(o, map,Direction.E);
        assertEquals(map.getTile(new Vect(2, Direction.E), new Vect(0, Direction.S)).getClass(), new FlyTile(Type.GROUND).getClass());

        
    }
    
}
