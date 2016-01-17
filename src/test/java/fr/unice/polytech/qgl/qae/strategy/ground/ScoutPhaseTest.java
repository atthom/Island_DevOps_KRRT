package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 03/01/16.
 */
public class ScoutPhaseTest {


    AbstractStrategy ex;
    ScoutPhase sp;
    Objectif ob;
    Map m;
    Coordinates c;
    GroundTile g1,g2,g3,g4;

    @Before
    public void setUp() {
        ex = new FlyingStrategy(Direction.S, ob);
        m = new Map();
        c = new Coordinates(0,0);
        sp = new ScoutPhase(ex,c,Direction.S,m);

    }

    @Test
    public void testExecute() {
       assertEquals(new Scout(Direction.N),sp.execute());
    }

}


