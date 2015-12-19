/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.composed.*;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.*;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.*;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TurnAroundTest {

    TurnAround t;
    Coordinates current1;
    Direction dE;
    Direction dS;
    ArrayList<AbstractAction> path1, path2;

    public TurnAroundTest() {
    }

    @Before
    public void setUp() {
        current1 = new Coordinates(0, 0);
        dE = Direction.E;
        path1 = new ArrayList<>();
        path1.add(new Heading(dE.left()));
        path1.add(new Scan());
        path1.add(new Heading(dE.left().left()));
        path1.add(new Scan());
        path1.add(new Heading(dE.left().left().left()));
        path1.add(new Scan());
        path1.add(new Fly());

        path2 = new ArrayList<>();
        dS = Direction.S;
        path2.add(new Heading(dS.left()));
        path2.add(new Scan());
        path2.add(new Heading(dS.left().left()));
        path2.add(new Scan());
        path2.add(new Heading(dS.left().left().left()));
        path2.add(new Scan());
        path2.add(new Fly());

    }

    @Test
    public void testTurnAround1() {
        t = new TurnAround(current1, dE);
        assertEquals(t.getAll(), path1);
        assertEquals(Direction.S, t.getDir());
        assertEquals(new Coordinates(-1, 0), t.getCoords());
    }

    @Test
    public void testTurnAround2() {
        t = new TurnAround(current1, dS);
        assertEquals(t.getAll(), path2);
        assertEquals(Direction.W, t.getDir());
    }

}
