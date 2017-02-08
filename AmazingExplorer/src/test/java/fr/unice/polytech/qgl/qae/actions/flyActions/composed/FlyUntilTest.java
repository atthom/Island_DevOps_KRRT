/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.composed;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyUntilTest {
    FlyUntil fu;
    Coordinates c;
    
    public FlyUntilTest() {
    }
    
    @Before
    public void setUp() {
        c = new Coordinates(0, 0);
        fu = new FlyUntil(10, c, Direction.E);
        fu.getAll().stream().forEach((a) -> {
            assertEquals(new Fly(), a);
        });
        assertEquals(10, fu.getAll().size());
    }

    @Test
    public void testSomeMethod() {
        assertEquals(fu.getCoords(),new Coordinates(10, 0) );
        assertEquals(fu.getDir(), Direction.E);
    }
    
}
