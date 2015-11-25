package fr.unice.polytech.qgl.qae.map;


import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by Loïc on 11/21/2015.
 */
public class FlyTileTest {

    FlyTile ft;

    public FlyTileTest(){}

    @Before
    public void setUp(){ft = new FlyTile();}

    @Test
    public void testGetT(){assertEquals(Type.UNKNOWN_TYPE, ft.getT());}

    @Test
    public void testSetT(){
        ft.setT(Type.GROUND);
        assertEquals(Type.GROUND, ft.getT());
    }

}
