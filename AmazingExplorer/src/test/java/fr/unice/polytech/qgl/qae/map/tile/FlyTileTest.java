/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyTileTest {
     FlyTile ft;
     FlyTile wicree;
     FlyTile witype;
    
    public FlyTileTest() {
    }
    
    @Before
    public void setUp() {
        ft = new FlyTile();
        ArrayList<String> cs = new ArrayList<>();
        cs.add("aaa");
        wicree = new FlyTile(new ArrayList<>(), cs, Type.OCEAN); 
        witype = new FlyTile(Type.UNKNOWN_TYPE);
        assertEquals(witype, ft);
        assertNotEquals(witype, wicree);
    }

    /**
     * Test of havecreeks method, of class FlyTile.
     */
    @Test
    public void testHavecreeks() {
        assertFalse(ft.havecreeks());
        assertTrue(wicree.havecreeks());
    }
   
    @Test
    public void testGetT(){
        assertEquals(Type.UNKNOWN_TYPE, ft.getT());
    }

    @Test
    public void testSetT(){
        ft.setT(Type.GROUND);
        assertEquals(Type.GROUND, ft.getT());
    }
    
    @Test
    public void testTile(){
        assertTrue(ft.have_only(BiomeType.UNKNOWN_BIOME));
        ft.addBiome(new Biome(BiomeType.LAKE));
        assertTrue(ft.have_biome(BiomeType.LAKE));
        assertFalse(ft.have_biome(BiomeType.GLACIER));
        assertTrue(ft.have_only(BiomeType.LAKE));
        assertEquals(1, ft.nb_biomes());
        
    }

}
