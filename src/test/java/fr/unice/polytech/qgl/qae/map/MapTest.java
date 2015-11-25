/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.actions.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MapTest {

    Map map;

    public MapTest() {
    }

    @Before
    public void setUp() {
        map = new Map(new FlyTile());
    }

    /**
     * Test of add method, of class Map.
     */
    @Test
    public void testAdd_3args() {
        map.add(new Vect(5, Direction.E), new Vect(2, Direction.S), new FlyTile(Type.GROUND));
    }

    /**
     * Test of add method, of class Map.
     */
    @Test
    public void testAdd_Vect_Tile() {
        map.add(new Vect(5, Direction.E), new FlyTile(Type.GROUND));
    }

    /**
     * Test of convert method, of class Map.
     */
    @Test
    public void testConvert_Vect() {
        
        Coordinates d = map.convert(new Vect(4, Direction.E));
        assertEquals(0, d.distance(new Coordinates(4, 0)));
    }

    /**
     * Test of convert method, of class Map.
     */
    @Test
    public void testConvert_Vect_Vect() {
        Coordinates d = map.convert(new Vect(4, Direction.E), new Vect(2, Direction.S));
        assertEquals(0, d.distance(new Coordinates(4, -2)));
        
        d = map.convert(new Vect(4, Direction.E), new Vect(2, Direction.W));
        assertEquals(0, d.distance(new Coordinates(0, 0)));
    }

    /**
     * Test of getTile method, of class Map.
     */
    @Test
    public void testGetTile() {
        assertEquals(map.getTile(new Vect(0, Direction.E), new Vect(0, Direction.S)).getClass().toString(), new FlyTile().getClass().toString());
        
        
    }


}
