/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Explorer;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class Phase1Test {
    Explorer ex;
    AbstractPhase ph1;
    
    public Phase1Test() {
    }
    
    @Before
    public void setUp() {
        ex = new Explorer();
        ph1 = new Phase1(ex, new Coordinates(0, 0), Direction.E);
        ex.setPhase(ph1);
    }

    /**
     * Test of execute method, of class Phase1.
     */
    @Test
    public void testExecute() {
        
        assertEquals(ph1.act(), new Echo(Direction.E.left()));
    }
    
}
