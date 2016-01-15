/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Ignore;
/**
 *
 * @author user
 */
public class ManageReplyTest {
    ManageReply manager;
    Map map;
    ArrayList<PrimaryResource> a;
    public ManageReplyTest() {
    }
    
    @Before
    public void setUp() {
        a = new ArrayList<>();
        manager = new ManageReply();
        map = new Map();
    }

    /**
     * Test of manage_echo method, of class ManageReply.
     */
    @Ignore
    public void testManage_echo() {
        a.add(new PrimaryResource(600, "WOOD"));
        a.add(new PrimaryResource(200, "GLASS"));
        JSONObject o = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        manager.manage(o, map,Direction.E, new Coordinates(0, 0));
        
        FlyTile t = map.getLastFlyTile();

        assertEquals(new FlyTile(Type.GROUND), map.getFlyTile(new Coordinates(2, 0)));
        assertEquals(t.getT(),Type.GROUND);
    }

    /**
     * Second test of manage_echo method, of class ManageReply.
     * Allow to see that the case are add in the right order in the map from the 1 index (the first index is matching
     * with the initial coordinate (0,0) created with the map
     */
    @Ignore
    public void addWithManage() {
        JSONObject o = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 0, \"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }");
        JSONObject o1 = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 30, \"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }");
        JSONObject o2 = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 15, \"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }");

        manager.manage(o, map,Direction.E, new Coordinates(0, 0));
        manager.manage(o1, map,Direction.E, new Coordinates(0, 0));
        manager.manage(o2, map,Direction.E, new Coordinates(0, 0));

        assertEquals(0,map.getFlyingmap().getCoordinates(1).getX());
        assertEquals(30,map.getFlyingmap().getCoordinates(2).getX());
        assertEquals(15,map.getFlyingmap().getCoordinates(3).getX());
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
        assertEquals(ft, map.getFlyTile(new Coordinates(5,5)));
        o = new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"OCEAN\"], \"creeks\": []}, \"status\": \"OK\"}");
        manager.manage(o, map, Direction.E, new Coordinates(10, 10));
        assertTrue(map.getLastFlyTile().have_only(BiomeType.OCEAN));
        
    }

    /**
     * Test of manage_scoot method, of class ManageReply.
     */
    @Test
    public void testManage_scoot(){
        JSONObject scoot_reply = new JSONObject("{ \"cost\": 5, \"extras\": { \"altitude\": 5, \"resources\": [\"FUR\", \"WOOD\"] }, \"status\": \"OK\" }");
        
        manager.manage(scoot_reply, map, Direction.E, new Coordinates(5, 5));
        GroundTile g = map.getLastGroundTile();
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
