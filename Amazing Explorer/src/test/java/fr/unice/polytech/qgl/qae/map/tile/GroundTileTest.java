package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.resources.ResourceAmountType;
import fr.unice.polytech.qgl.qae.resources.ResourceConditionType;
import fr.unice.polytech.qgl.qae.resources.ResourceTile;
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

  /**
   * Test of addResource method, of class GroundTile.
   */
  @Test
  public void testAddGetResource() {
    ResourceTile rt = new ResourceTile("WOOD", ResourceAmountType.HIGH, ResourceConditionType.HARSH);
    gt.addResource(rt);
    assertEquals(rt, gt.getResource("WOOD"));
  }




}
