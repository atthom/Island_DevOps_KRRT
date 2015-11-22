/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.resources.ExtractedResource;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<ExtractedResource> a = new ArrayList<>();
        a.add(new ExtractedResource(600, "WOOD"));
        a.add(new ExtractedResource(200, "GLASS"));
        Objectif o = new Objectif(12, 10000, a);
        strat= new FlyingStrategy(new Heading(Direction.E),o);
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
