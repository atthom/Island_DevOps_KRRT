/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
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
        assertEquals(map.getFlyTile(new Coordinates(0,0)), new FlyTile());
    }

    /**
     * Test of put method, of class Map.
     */
    @Test
    public void testPut() {
        FlyTile ft = new FlyTile();
        map.put(new Coordinates(5, -5),ft );
        assertEquals( ft  ,map.getFlyTile(new Coordinates(5, -5)));
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
        //assertFalse(map.last_is_only_ocean());

        ab.clear();
        ab.add(new Biome(BiomeType.BEACH));
        ab.add(new Biome(BiomeType.OCEAN));
        map.put(new Coordinates(10, 10), new FlyTile(ab, cr , Type.UNKNOWN_TYPE));
        //assertFalse(map.last_is_only_ocean());

        ab.clear();
        ab.add(new Biome(BiomeType.OCEAN));
        
        FlyTile a =  new FlyTile(ab, cr , Type.UNKNOWN_TYPE);
        System.out.println(a.nb_biomes());
        map.put(new Coordinates(11, 11), a);
        map.getFlyTile(new Coordinates(11, 11)).print_biomes();
     
        
       //assertTrue(map.last_is_only_ocean());
    }

    @Test
    public void last_havecreek() {
        ArrayList<Creek> lc = new ArrayList<Creek>();
        ArrayList<Biome> lb = new ArrayList<Biome>();
        lb.add(new Biome(BiomeType.ALPINE));
        lc.add(new Creek("id"));
        map.put(new Coordinates(5, 5), new FlyTile(lb,lc,Type.GROUND));
       // assertEquals(true,map.last_havecreek());
    }




}
