package fr.unice.polytech.qgl.qae.map;


import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by Loïc on 11/21/2015.
 */
public class CoordinatesTest {

    Coordinates c;

    public CoordinatesTest(){}

    @Before
    public void setUp(){ c = new Coordinates(0,0);}

    @Test
    public void testGetX(){assertEquals(0, c.getX());}

    @Test
    public void testGetY(){assertEquals(0, c.getY());}

    @Test
    public void setX(){
        c.setX(5);
        assertEquals(5, c.getX());
    }

}
