/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.resources.Resource;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


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
        ArrayList<Resource> a = new ArrayList<>();
        a.add(new Resource(600, "WOOD"));
        a.add(new Resource(200, "GLASS"));
       
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


    
