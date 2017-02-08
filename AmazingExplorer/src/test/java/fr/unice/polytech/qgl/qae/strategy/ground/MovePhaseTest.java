package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.resources.MissionAssignment;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;

import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.GroundMap;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author user
 */
public class MovePhaseTest {

    /*AbstractStrategy ex;
    MovePhase mp;
    MissionAssignment mission;
    GroundMap m;
    Coordinates c;
    GroundTile g1,g2,g3,g4;
    ArrayList<PrimaryResource> contract;

    @Before
    public void setUp() {
        contract = new ArrayList<>();
        ex = new FlyingStrategy(Direction.E, mission);
        contract.add(new PrimaryResource(15,"WOOD"));

        ob = new Objectif(10,150,contract);

        ex = new FlyingStrategy(Direction.S, ob);
        m = new GroundMap();
        c = new Coordinates(0,0);
        mp = new MovePhase(ex,c,new FlyingMap(), m);

        g1 = new GroundTile();
        g1.addRes(new PrimaryResource(5,"FISH"));
        g2 = new GroundTile();
        g2.addRes(new PrimaryResource(5,"FISH"));
        g3 = new GroundTile();
        g3.addRes(new PrimaryResource(5,"FISH"));
        g4 = new GroundTile();
        g4.addRes(new PrimaryResource(5,"WOOD"));

        m.put(new Coordinates(0,1),g1);
        m.put(new Coordinates(1,0),g2);
        m.put(new Coordinates(0,-1),g3);
        m.put(new Coordinates(-1,0),g4);

    }

    @Test
    public void testExecute() {
        //assertEquals(new MoveTo(Direction.W),mp.execute());
        //mp.getNext();
        //assertEquals(new MoveTo(Direction.N),mp.execute());

        ex.getObjectif().enleve_PA(120);
        assertEquals(30,ob.getBudget());
//        assertEquals(new Stop(),mp.execute());

    }*/
}
