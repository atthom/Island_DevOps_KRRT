package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/16.
 */
public class MoveDiagTest {
    MoveDiag moveDiagNE, moveDiagNW, moveDiagSE, moveDiagSW;
    Coordinates c;
    Direction E, S, N, W;

    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        moveDiagNE = new MoveDiag(c, N, E,3);
        moveDiagNW = new MoveDiag(c, N, W,3);
        moveDiagSE = new MoveDiag(c, S, E,3);
        moveDiagSW = new MoveDiag(c, S, W,3);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(new Coordinates(3, 3), moveDiagNE.getCoords());

        assertEquals(new Coordinates(-3, 3), moveDiagNW.getCoords());

        assertEquals(new Coordinates(3, -3), moveDiagSE.getCoords());

        assertEquals(new Coordinates(-3, -3), moveDiagSW.getCoords());

    }
}
