package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Glimpse;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.strategy.ground.InitTerrestre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/16.
 */
public class InitTerrestreTest {

    InitTerrestre it;
    Map m;
    AbstractStrategy ex;
    Objectif ob;

    GroundTile gt;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.S, ob);
        m = new Map();
        m.getGroundmap().put(new Coordinates(5, 10), new GroundTile());
        it = new InitTerrestre(ex, new Coordinates(5, 5), Direction.S, m);

    }

    @Test
    public void testExecute() {
        assertEquals(new Glimpse(Direction.N,3), it.execute());
        assertEquals(it, it.getNext());
        it.actions.remove(0);

    }
}
