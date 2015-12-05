/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PathTest {

    Path p;
    Coordinates current;
    Coordinates togo1, togo2, togo3, togo4, togo5;
    Direction dE, dW, dS, dN;
    ArrayList<AbstractAction> path1, path2, path3, path4, path5;

    public PathTest() {
    }

    @Before
    public void setUp() {
        current = new Coordinates(0, 0);

        togo1 = new Coordinates(0, 0);
        path1 = new ArrayList<>();
        
        togo2 = new Coordinates(5, 0);
        path2 = new ArrayList<>();
        path2.add(new Fly());
        path2.add(new Fly());
        path2.add(new Fly());
        path2.add(new Fly());
        path2.add(new Fly());

        togo3 = new Coordinates(0, 5);
        path3 = new ArrayList<>();

        togo4 = new Coordinates(0, 5);
        path4 = new ArrayList<>();

        togo5 = new Coordinates(-5, -5);
        path5 = new ArrayList<>();

    }

    @Test
    public void testpath1() {
        p = new Path(current, Direction.E, togo1);
        assertEquals(p.getAll(), path1);
    }

    @Test
    public void testpath2() {
        p = new Path(current, Direction.E, togo2);
        assertEquals(p.getAll(), path2);
    }

    @Test
    public void testpath3() {

    }

    /**
     * Test of maj_turnaround method, of class Path.
     */
    @Test
    public void testMaj_turnaround() {

    }

}
