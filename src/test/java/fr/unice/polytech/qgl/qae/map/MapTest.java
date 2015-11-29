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
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

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
     * Test of put method, of class Map.
     */
    @Test
    public void put() {
        map.put(new Coordinates(10,5), new FlyTile(Type.GROUND));
        //assertEquals(10, map.get_lastcoordinate().getX());
        assertEquals(10, map.get_coordinate(1).getX());
        assertEquals(5, map.get_coordinate(1).getY());
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
        assertEquals(map.getTile(new Vect(0, Direction.E), new Vect(0, Direction.S)), new FlyTile());
    }

    /**
     * Test of getMaxXCord method, of class Map.
     */
    @Test
    public void getMaxXCord() {
        map.put(new Coordinates(10,5), new FlyTile(Type.GROUND));
        map.put(new Coordinates(20,5), new FlyTile(Type.GROUND));

        //map.add(new Vect(10,Direction.E), new Vect(15,Direction.N),new FlyTile(Type.GROUND));
        //map.add(new Vect(20,Direction.E), new Vect(0,Direction.N),new FlyTile(Type.GROUND));
        assertEquals(20, map.getMaxXCord());
    }

    /**
     * Test of getMaxYCord method, of class Map.
     */
    @Ignore
    public void getMaxYCord() {
        map.add(new Vect(10,Direction.E), new Vect(15,Direction.N),new FlyTile(Type.GROUND));
        map.add(new Vect(20,Direction.E), new Vect(0,Direction.N),new FlyTile(Type.GROUND));
        assertEquals(15, map.getMaxYCord());
    }

    /**
     * Test of generate method, of class Map.
     */
    @Test
    public void generate() {
        map.add(new Vect(10,Direction.E), new Vect(0,Direction.N),new FlyTile(Type.GROUND));
        map.add(new Vect(0,Direction.E), new Vect(10,Direction.N),new FlyTile(Type.GROUND));

        map.generate();
        /*
        int tab[][]  = new int[100][10];
        assertEquals(100, tab.length);
        */
    }

}
