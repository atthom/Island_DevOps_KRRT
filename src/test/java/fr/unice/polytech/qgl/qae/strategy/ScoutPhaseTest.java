package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.strategy.ground.MovePhase;
import fr.unice.polytech.qgl.qae.strategy.ground.InitTerrestre;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;

/**
 * Created by user on 03/01/16.
 */
public class ScoutPhaseTest {

    AbstractStrategy ex;
    AbstractPhase ph0,ph1;
    Objectif ob;

    public ScoutPhaseTest() {
    }

    @Before
    public void setUp() {
        Map m = new Map();
        ex = new FlyingStrategy(Direction.E, ob);
        ph0 = new InitTerrestre(ex,new Coordinates(0, 0),Direction.E, m);
        ph1 = new MovePhase(ex,new Coordinates(0, 0), Direction.E, m);

    }

}


