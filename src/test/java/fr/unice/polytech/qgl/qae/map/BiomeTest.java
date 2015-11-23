package fr.unice.polytech.qgl.qae.map;


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
    public void testGetB(){assertEquals(BiomeType.UNKNOWN_BIOME, b.getType());}

    @Test
    public void testSetB(){
        b.setType(BiomeType.ALPINE);
        assertEquals(BiomeType.ALPINE, b.getType());
    }
}
