package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 19/12/2015.
 */
public class GoGroundTest {

    GoGround gg;
    FlyingMap m;
    AbstractStrategy ex;
    Objectif ob;

    FlyTile ocean;
    FlyTile ground;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.S, ob);
        m = new FlyingMap();
        ocean = new FlyTile(Type.OCEAN);
        ground = new FlyTile(Type.GROUND);
        m.put(new Coordinates(5, 10), ground);
        gg = new GoGround(ex, new Coordinates(5, 5), Direction.S, m);

    }

    @Test
    public void testExecute() throws Exception {
        for (int i = 0; i < 5; i++) {
            assertEquals(new Fly(), gg.execute());
            assertEquals(gg, gg.getNext());
            gg.actions.remove(0);
        }
        
        assertTrue(gg.actions.isEmpty());
     //   assertEquals(new CreeksFinder(ex, gg.currents_coords, gg.d, gg.map), gg.getNext());
    }

    
    /**
     * Test of getNext method, of class GoGround.
     */
    @Test
    public void testGetNext() {
        assertEquals(gg.getNext(), gg);
        gg.execute();
        assertEquals(gg.getNext(), gg);
        gg.actions.clear();
        gg.execute();
        assertEquals(gg.getNext(), gg);
        gg.map.put(new Coordinates(5, 5), ocean);
//        assertEquals(new Echo(gg.d), gg.execute());
        
    }

}
