package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import org.junit.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by Loïc on 11/21/2015.
 */
public class GroundTileTest {

    GroundTile gt;

    GroundTileTest(){

    }

    @Before
    public void setUp(){gt = new GroundTile();}

    @Test
    public void testAddRessource(){

    }

    @Test
    public void testGetB(){
        assertEquals(new Biome(), gt.getB());
    }

    @Test
    public void testSetB(){
        //TODO
    }

    @Test
    public void testGetAltitude(){assertEquals(-1, gt.getAltitude());}

    @Test
    public void testSetAltitude(){
        gt.setAltitude(2);
        assertEquals(2, gt.getAltitude());
    }
}
