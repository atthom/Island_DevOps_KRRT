package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
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
    Glimpse gN,gS,gE,gW;
    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        gl = new Glimpse360(c,4);
        gN = new Glimpse(Direction.N,4);
        gS = new Glimpse(Direction.S,4);
        gE = new Glimpse(Direction.E,4);
        gW = new Glimpse(Direction.W,4);

    }
    @Test
    public void testSomeMethod() {
        Glimpse test1 = (Glimpse)gl.getAll().get(0);
        Glimpse test2 = (Glimpse)gl.getAll().get(1);
        Glimpse test3 = (Glimpse)gl.getAll().get(2);
        Glimpse test4 = (Glimpse)gl.getAll().get(3);

        assertEquals(gN.getRange(),test1.getRange());
        assertEquals(gN.getValueParameter(),test1.getValueParameter());

        assertEquals(gE.getRange(),test2.getRange());
        assertEquals(gE.getValueParameter(),test2.getValueParameter());

        assertEquals(gS.getRange(),test3.getRange());
        assertEquals(gS.getValueParameter(),test3.getValueParameter());

        assertEquals(gW.getRange(),test4.getRange());
        assertEquals(gW.getValueParameter(),test4.getValueParameter());

    }
}
