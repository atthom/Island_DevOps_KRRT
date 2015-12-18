/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class InitTest {
    AbstractStrategy ex;
    AbstractPhase ph1;
    
    public InitTest() {
    }
    
    @Before
    public void setUp() {
        ex = new FStrategy(Direction.E);
        ph1 = new Init(ex, new Coordinates(0, 0), Direction.E, new Map(new FlyTile()));
        ex.setPhase(ph1);
    }

    /**
     * Test of execute method, of class Init.
     */
    @Test
    public void testExecute() {
        
     
    }
    
}
