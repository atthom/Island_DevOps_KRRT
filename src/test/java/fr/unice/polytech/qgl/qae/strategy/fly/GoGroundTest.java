package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
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
    Map m;
    AbstractStrategy ex;
    Objectif ob;

    FlyTile ocean;
    FlyTile ground;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.S, ob);
        m = new Map();
        ocean = new FlyTile(Type.OCEAN);
        ground = new FlyTile(Type.GROUND);
        m.getFlyingmap().put(new Coordinates(5, 10), ground);
        gg = new GoGround(ex, new Coordinates(5, 5), Direction.S, m);

    }

    /**
     * Test of getfirstground method, of class GoGround.
     */
  @Test
    public void testGetfirstground() {
        assertEquals(new Coordinates(5, 10), gg.getfirstground());
    }
    
//    @Test
//    public void testGetfirstground2() {
//
//        Coordinates c = new Coordinates(0, 0);
//        gg.map.getFlyingmap().maj(new Coordinates(5, 10), ocean);
//        gg.map.getFlyingmap().put(new Coordinates(3, 0), ocean);
//        gg.map.getFlyingmap().put(new Coordinates(2, 0), ocean);
//        assertEquals(c, gg.getfirstground());
//    }

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
        gg.map.getFlyingmap().put(new Coordinates(5, 5), ocean);
//        assertEquals(new Echo(gg.d), gg.execute());
        
    }

}
