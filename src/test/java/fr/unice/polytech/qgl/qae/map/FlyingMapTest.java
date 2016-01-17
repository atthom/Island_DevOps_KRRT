package fr.unice.polytech.qgl.qae.map;

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
    
    private void putTile() {
        map.put(new Coordinates(6, 6),new FlyTile(Type.GROUND));
        map.put(new Coordinates(7, 6),new FlyTile(Type.OCEAN));
    }

    /**
     * Test of put method, of class FlyingMap.
     */
    @Test
    public void testPut() {
        assertEquals(new FlyTile(), map.getLastTile().getValue());
        assertEquals(new Coordinates(0,0), map.getLastTile().getKey());
    }

    @Test
    public void testMaj() {
        // je redéclare le coordinates pour bien vérifier que le test fonctionne
        // pour n'importe quel object égal et non le premier utilisé comme clé
        map.put(new Coordinates(5,5), new FlyTile(Type.GROUND));

        FlyTile t = new FlyTile(Type.OUT_OF_RANGE);
        map.maj(new Coordinates(5,5),t);
        assertEquals(t, map.getTile(new Coordinates(5,5)));
    }
    
    /**
     * Test of get method, of class FlyingMap.
     */
    @Test
    public void testGet() {
        assertEquals(new Coordinates(0, 0), map.get(0));
        assertEquals(null, map.get(-1));
        assertEquals(null, map.get(50));
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
        map.flush();
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(new FlyTile(Type.GROUND), map.getFirstTile().getValue());
        assertEquals(new Coordinates(5,5), map.getFirstTile().getKey());
    }
    
     /**
     * Test of getLastTile method, of class FlyingMap.
     */
    @Test
    public void testGetLastTile() {
        FlyTile t = new FlyTile(Type.GROUND);
        map.put( new Coordinates(4,4), t);
        FlyTile tt = new FlyTile(Type.GROUND);
        map.put( new Coordinates(5,5), t);
        assertEquals(tt, map.getLastTile().getValue());
        assertEquals(new Coordinates(5,5), map.getLastTile().getKey());
    }
    
    /**
     * Test of preced method, of class FlyingMap.
     */
    @Test
    public void testPreced_MapEntry() {
        putTile();
        assertEquals(new FlyTile(Type.GROUND), map.preced(map.getLastTile()).getValue());
        assertEquals(new Coordinates(6, 6), map.preced(map.getLastTile()).getKey());
    }

    /**
     * Test of preced method, of class FlyingMap.
     */
    @Test
    public void testPreced_Coordinates() {
        putTile();
        assertEquals(new Coordinates(6, 6), map.preced(map.getLastTile().getKey()));
    }

    

    




}