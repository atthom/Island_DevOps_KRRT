package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Glimpse;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/16.
 */
public class Glimpse360Test {

    Glimpse360 gl;
    Coordinates c;
    Direction E, S, N, W;

    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        gl = new Glimpse360(c,Direction.E,4);
    }
    @Test
    public void testSomeMethod() {
        //assertEquals(new Glimpse(Direction.N,4), gl);


    }
}
