/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MapTest {

    Map map;
    ArrayList<Creek> cr;

    public MapTest() {
    }

    @Before
    public void setUp() {
        map = new Map(new FlyTile());
        cr = new ArrayList<>();
    }

    /**
     * Test of getTile method, of class Map.
     */
    @Test
    public void testGetTile() {
        assertEquals(map.getTile(new Coordinates(0,0)), new FlyTile());
    }

    /**
     * Test of put method, of class Map.
     */
    @Test
    public void testPut() {
        FlyTile ft = new FlyTile();
        map.put(new Coordinates(5, -5),ft );
        assertEquals( ft  ,map.getTile(new Coordinates(5, -5)));
    }

    /**
     * Test of goaway method, of class Map.
     */
    @Test
    public void testGoaway() {
        map.put(new Coordinates(5, 5), new FlyTile(Type.GROUND));
        for(int i = 0; i < 6; i++) {
            Direction d = map.go_ground(new Coordinates(0, 0));        
            assertEquals(Direction.E,  d);
        }
                
        for(int i = 0; i < 4; i++) {
            Direction d = map.go_ground(new Coordinates(5, 0));
            assertEquals(Direction.N, d);
        }
    }

    /**
     * Test of get_lastcoordinate method, of class Map.
     */
    @Test
    public void testGet_lastcoordinate() {
        assertEquals(new Coordinates(0, 0), map.get_lastcoordinate());
    }


    /**
     * Test of last_is_ocean method, of class Map.
     */
    @Test
    public void testLast_is_ocean() {
        ArrayList<Biome> ab = new ArrayList<>();
        
        ab.add(new Biome(BiomeType.BEACH));
        
        map.put(new Coordinates(5, 5), new FlyTile(ab, cr , Type.UNKNOWN_TYPE));
        assertFalse(map.last_is_ocean());
        
        ab.add(new Biome(BiomeType.BEACH));
        ab.add(new Biome(BiomeType.OCEAN));
        map.put(new Coordinates(10, 10), new FlyTile(ab, cr , Type.UNKNOWN_TYPE));
        assertTrue(map.last_is_ocean());
    }




}
