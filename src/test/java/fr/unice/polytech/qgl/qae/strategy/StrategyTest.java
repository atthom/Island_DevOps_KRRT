/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class StrategyTest {
    Strategy strat;
    public StrategyTest() {
    }
    
    @Before
    public void setUp() {
        strat= new FlyingStrategy(new Heading(Direction.E));
    }

    /**
     * Test of gauche method, of class Strategy.
     */
    @Test
    public void testGauche() {
    }

    /**
     * Test of droite method, of class Strategy.
     */
    @Test
    public void testDroite() {
    }

    
}
