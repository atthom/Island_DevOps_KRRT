/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MoveAndScoutTest {

    MoveAndScout moveandscoutE, moveandscoutS, moveandscoutN, moveandscoutW;
    Coordinates c;
    Direction E, S, N, W;

    public MoveAndScoutTest() {
    }

    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        moveandscoutE = new MoveAndScout(c, E);
        moveandscoutS = new MoveAndScout(c, S);
        moveandscoutW = new MoveAndScout(c, W);
        moveandscoutN = new MoveAndScout(c, N);
    }

    @Test
    public void testSomeMethod() {
        assertEquals(new Coordinates(1, 0), moveandscoutE.getCoords());
        assertEquals(E, moveandscoutE.getDir());

        assertEquals(new Coordinates(-1, 0), moveandscoutW.getCoords());
        assertEquals(W, moveandscoutW.getDir());

        assertEquals(new Coordinates(0, -1), moveandscoutS.getCoords());
        assertEquals(S, moveandscoutS.getDir());

        assertEquals(new Coordinates(0, 1), moveandscoutN.getCoords());
        assertEquals(N, moveandscoutN.getDir());

    }

}
