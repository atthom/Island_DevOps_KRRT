package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Loic on 11/21/2015.
 */
public class GroundTileTest {

    GroundTile gt;
    Biome b;
    Biome bb;

    @Before
    public void setUp() {
        b = new Biome();
        bb = new Biome(BiomeType.LAKE);
        gt = new GroundTile();
    }

    @Test
    public void testAddRessource() {

    }

    @Test
    public void testGetB() {
        gt.addBiome(b);
        assertTrue(gt.have_biome(BiomeType.UNKNOWN_BIOME));

        assertFalse(gt.have_biome(BiomeType.LAKE));

    }

    @Test
    public void testaddB() {
        gt.addBiome(bb);
        assertTrue(gt.have_biome(BiomeType.LAKE));
    }

    @Test
    public void testGetAltitude() {
        assertEquals(-1, gt.getAltitude());
    }

    @Test
    public void testSetAltitude() {
        gt.setAltitude(2);
        assertEquals(2, gt.getAltitude());
    }
}
