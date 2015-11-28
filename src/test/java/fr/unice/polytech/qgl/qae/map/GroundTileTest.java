package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Loïc on 11/21/2015.
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
        assertEquals(b, gt.getB(BiomeType.UNKNOWN_BIOME));

        try {
            gt.getB(BiomeType.LAKE);
            fail("This should fail.");
        } catch (Exception e) {
        }

    }

    @Test
    public void testaddB() {
        gt.addBiome(bb);
        assertEquals(bb, gt.getB(BiomeType.LAKE));
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
