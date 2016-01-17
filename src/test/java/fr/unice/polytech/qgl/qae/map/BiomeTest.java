package fr.unice.polytech.qgl.qae.map;


import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Loïc on 11/21/2015.
 */
public class BiomeTest {

    Biome b;

    @Before
    public void setUp(){b = new Biome();}

    @Test
    public void testGetB(){assertEquals(BiomeType.UNKNOWN_BIOME, b.getBiomeType());}

    @Test
    public void testSetB(){
        b.setBiomeType(BiomeType.ALPINE);
        assertEquals(BiomeType.ALPINE, b.getBiomeType());
    }
}
