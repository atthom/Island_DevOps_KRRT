/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.resources.ExtractedResource;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<ExtractedResource> a = new ArrayList<>();
        a.add(new ExtractedResource(600, "WOOD"));
        a.add(new ExtractedResource(200, "GLASS"));
        JSONObject o = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        manager.manage(o, map,Direction.E, new Coordinates(0, 0));
        
        assertEquals(new FlyTile(Type.GROUND), map.getTile(new Coordinates(2, 0)));

        
    }

    /**
     * Test of manage method, of class ManageReply.
     */
    @Test
    public void testManage() {
        JSONObject o = new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"BEACH\"], \"creeks\": [\"id\"]}, \"status\": \"OK\"}");
                
        manager.manage(o, map, Direction.E, new Coordinates(5, 5));
        
        ArrayList<Biome> b = new ArrayList<>();
        b.add(new Biome(BiomeType.BEACH));
        ArrayList<Creek> c= new ArrayList<>();
        c.add(new Creek("id"));
        FlyTile ft = new FlyTile(b, c, Type.UNKNOWN_TYPE);
        assertEquals(ft, map.getTile(new Coordinates(5,5)));   
        
        
        
        o = new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"OCEAN\"], \"creeks\": []}, \"status\": \"OK\"}");
        manager.manage(o, map, Direction.E, new Coordinates(10, 10));
        assertTrue(map.last_is_ocean());
        
        
        
  
        
    }
    
}
