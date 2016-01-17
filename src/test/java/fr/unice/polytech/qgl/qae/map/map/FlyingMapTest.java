package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

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
    public void testMaj() throws Exception {

        // je redéclare le coordinates pour bien vérifier que le test fonctionne
        // pour n'importe quel object égal et non le premier utilisé comme clé
        map.put(new Coordinates(5,5), new FlyTile(Type.GROUND));

        FlyTile t = new FlyTile(Type.OUT_OF_RANGE);
        map.maj(new Coordinates(5,5),t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
    }

    /**
     * Test of size method, of class FlyingMap.
     */
    @Test
    public void testSize() {
        assertEquals(1, map.size());
        map.put(new Coordinates(1, 1), new FlyTile());
        assertEquals(2, map.size());
        
        map.put(new Coordinates(1, 1), new FlyTile());
        assertEquals(2, map.size());
    }

    /**
     * Test of getTile method, of class FlyingMap.
     */
    @Test
    public void testGetTile() {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
        assertNull(map.getTile(new Coordinates(4,400)));
    }

    /**
     * Test of getFirstTile method, of class FlyingMap.
     */
    @Test
    public void testGetFirstTile() {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(new FlyTile(), map.getFirstTile().getValue());
        assertEquals(new Coordinates(0,0), map.getFirstTile().getKey());
    }

    /**
     * Test of getLastTile method, of class FlyingMap.
     */
    @Test
    public void testGetLastTile() {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        FlyTile tt = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(tt, map.getLastTile().getValue());
        assertEquals(new Coordinates(5,5), map.getLastTile().getKey());
       
    }

    /**
     * Test of preced method, of class FlyingMap.
     */
    @Test
    public void testPreced_FlyTile() {
    }

    /**
     * Test of preced method, of class FlyingMap.
     */
    @Test
    public void testPreced_Coordinates() {
    }

    /**
     * Test of get method, of class FlyingMap.
     */
    @Test
    public void testGet() {
    }


}