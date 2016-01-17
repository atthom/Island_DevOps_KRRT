package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Glimpse;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.GroundMap;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/16.
 */
public class InitTerrestreTest {

    InitTerrestre it;
    GroundMap m;
    AbstractStrategy ex;
    Objectif ob;
    Coordinates c;
    GroundTile gt;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.S, ob);
        m = new GroundMap();
        c = new Coordinates(0,0);
        m.put(new Coordinates(5, 10), new GroundTile());
        it = new InitTerrestre(ex, new Coordinates(5, 5), new FlyingMap(), m);
    }

    @Test
    public void testExecute() {

        assertEquals(new Glimpse(Direction.N,3), it.execute());
        assertEquals(it, it.getNext());
        it.actions.remove(0);

        assertEquals(new Glimpse(Direction.E,3), it.execute());
        assertEquals(it, it.getNext());
        it.actions.remove(0);

        assertEquals(new Glimpse(Direction.S,3), it.execute());
        assertEquals(it, it.getNext());
        it.actions.remove(0);

        assertEquals(new Glimpse(Direction.W,3), it.execute());
        assertEquals(it, it.getNext());
        it.actions.remove(0);

    }
}
