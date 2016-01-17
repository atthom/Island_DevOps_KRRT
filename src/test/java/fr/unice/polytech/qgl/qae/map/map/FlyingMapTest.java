package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/12/2015.
 */
public class FlyingMapTest {

    FlyingMap map;

    @Before
    public void setUp() throws Exception {
        map = new FlyingMap();
    }


    @Test
    public void testPut() throws Exception {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
    }

    @Test
    public void getFlyTile() throws Exception {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
        assertNull(map.getTile(new Coordinates(4,400)));
    }

    @Test
    public void testMaj() throws Exception {

        // je redéclare le coordinates pour bien vérifier que le test fonctionne
        // pour n'importe quel object égal et non le premier utilisé comme clé
        map.put(new Coordinates(5,5), new FlyTile(Type.GROUND));

        FlyTile t = new FlyTile(Type.OUT_OF_RANGE);
        map.maj(new Coordinates(5,5),t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
    }


    @Test
    public void testGetlastFlyTile() throws Exception {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        FlyTile tt = new FlyTile(Type.GROUND);
        map.put( new Coordinates(2,5), t);
        FlyTile ttt = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(ttt, map.getLastTile().getValue());
        assertEquals(new Coordinates(5,5), map.getLastTile().getKey());
        assertNotSame(tt, map.getLastTile().getValue());
    }

}