/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author user
 */
public class InitTest {
    AbstractStrategy ex;
    AbstractPhase ph1;
    
    public InitTest() {
    }
    
    @Before
    public void setUp() {
        ex = new FlyingStrategy(Direction.E);
        ph1 = new Init(ex, new Coordinates(0, 0), Direction.E, new Map());

    }

    private void addGround() {
        ph1.map.getFlyingmap().put(new Coordinates(0,5), new FlyTile(Type.OUT_OF_RANGE));
        ph1.map.getFlyingmap().put(new Coordinates(0,-25), new FlyTile(Type.OUT_OF_RANGE));
        ph1.map.getFlyingmap().put(new Coordinates(10,0), new FlyTile(Type.GROUND));
    }

    private void addNotGround() {
        ph1.map.getFlyingmap().put(new Coordinates(0,5), new FlyTile(Type.OUT_OF_RANGE));
        ph1.map.getFlyingmap().put(new Coordinates(0,-25), new FlyTile(Type.OUT_OF_RANGE));
        ph1.map.getFlyingmap().put(new Coordinates(10,0), new FlyTile(Type.OUT_OF_RANGE));
    }

    /**
     * Test of execute method, of class Init.
     */
    @Test
    public void testExecute() {
        assertEquals(new Echo(Direction.E.left()), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);
        assertEquals(new Echo(Direction.E.right()), ph1.execute());
        ph1.actions.remove(0);
        assertEquals(ph1, ph1.getNext());
        assertEquals(new Echo(Direction.E), ph1.execute());
        ph1.actions.remove(0);
        addGround();
        assertEquals(new GoGround(ex, ph1.currents_coords, ph1.d, ph1.map), ph1.getNext());
    }

    @Test
    public void testExecuteBis() {
        assertEquals(new Echo(Direction.E.left()), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);
        assertEquals(new Echo(Direction.E.right()), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);
        assertEquals(new Echo(Direction.E), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);
        addNotGround();


        assertEquals(new Fly(), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);
        assertEquals(new Echo(Direction.E.right()), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);

        assertEquals(new Fly(), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);

        assertEquals(new Echo(Direction.E.right()), ph1.execute());
        assertEquals(ph1, ph1.getNext());
        ph1.actions.remove(0);

        ph1.map.getFlyingmap().put(new Coordinates(5,-10), new FlyTile(Type.GROUND));
        assertEquals(new Heading(Direction.E.right()), ph1.execute());
        ph1.actions.remove(0);
        assertEquals(new GoGround(ex, ph1.currents_coords, ph1.d, ph1.map), ph1.getNext());
    }


    
}
