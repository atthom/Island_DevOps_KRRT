package fr.unice.polytech.qgl.qae.map;


import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Loïc on 11/21/2015.
 */
public class BiomeTest {

    Biome b;

    public BiomeTest(){}

    @Before
    public void setUp(){b = new Biome();}

    @Test
    public void testGetB(){assertEquals(BiomeType.UNKNOWN_BIOME, b.getB());}

    @Test
    public void testSetB(){
        b.setB(BiomeType.ALPINE);
        assertEquals(BiomeType.UNKNOWN_BIOME, b.getB());
    }
}
