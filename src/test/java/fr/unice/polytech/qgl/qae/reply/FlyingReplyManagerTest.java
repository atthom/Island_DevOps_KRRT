/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import java.util.ArrayList;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyingReplyManagerTest {
    FlyingReplyManager frm;
    FlyingMap map;
    
    public FlyingReplyManagerTest() {
    }
    
    @Before
    public void setUp() {
        frm = new FlyingReplyManager();
        map = new FlyingMap();
       
    }

     /**
     * Test of manage_echo method, of class ManageReply.
     */
    @Test
    public void testManage_echo() {

        JSONObject o = new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        frm.manage(o, map,Direction.E, new Coordinates(0, 0));
        FlyTile t = map.getLastTile().getValue();
        assertEquals(new FlyTile(Type.GROUND), map.getTile(new Coordinates(2, 0)));
        assertEquals(t.getT(),Type.GROUND);
    }
    
     /**
     * Test of manage method, of class ManageReply.
     */
    @Test
    public void testManageScan() {
        JSONObject o = new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"BEACH\"], \"creeks\": [\"id\"]}, \"status\": \"OK\"}");
                
        frm.manage(o, map, Direction.E, new Coordinates(5, 5));
        
        ArrayList<Biome> b = new ArrayList<>();
        b.add(new Biome(BiomeType.BEACH));
        ArrayList<String> c= new ArrayList<>();
        c.add("id");
        FlyTile ft = new FlyTile(b, c, Type.UNKNOWN_TYPE);
        assertEquals(ft, map.getTile(new Coordinates(5,5)));
        o = new JSONObject("{\"cost\": 2, \"extras\": { \"biomes\": [\"OCEAN\"], \"creeks\": []}, \"status\": \"OK\"}");
        frm.manage(o, map, Direction.E, new Coordinates(10, 10));
        assertTrue(map.getLastTile().getValue().have_only(BiomeType.OCEAN));
        
    }
    
}
