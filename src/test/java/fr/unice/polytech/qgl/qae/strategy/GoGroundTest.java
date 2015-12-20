package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 19/12/2015.
 */
public class GoGroundTest {

    GoGround gg;
    Map m;
    AbstractStrategy ex;
    @Before
    public void setUp() throws Exception {
        ex = new FStrategy(Direction.S);
        m = new Map(new FlyTile());
        m.put(new Coordinates(5,10),new FlyTile(Type.GROUND));
        gg = new GoGround(ex, new Coordinates(5, 5), Direction.S, m);
    }

    @Test
    public void testExecute() throws Exception {
        for (int i=0; i<5; i++) {
            assertEquals(new Fly(), gg.execute());
            assertEquals(gg, gg.getNext());
            gg.actions.remove(0);
        }
        assertTrue(gg.actions.isEmpty());

        assertEquals(new CreeksFinder(ex, gg.currents_coords, gg.d, gg.map), gg.getNext());

    }
}