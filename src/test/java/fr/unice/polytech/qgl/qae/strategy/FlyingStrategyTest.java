/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Echo;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.map.FlyTile;
import fr.unice.polytech.qgl.qae.map.Tile;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.Vect;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyingStrategyTest {

    FlyingStrategy fstrat;

    public FlyingStrategyTest() {
    }

    @Before
    public void setUp() {
        fstrat = new FlyingStrategy(new Heading(Direction.E));

    }

    @Test
    public void setUpString() {
        fstrat = new FlyingStrategy("{ \n"
                + "  \"men\": 12,\n"
                + "  \"budget\": 10000,\n"
                + "  \"contracts\": [\n"
                + "    { \"amount\": 600, \"resource\": \"WOOD\" },\n"
                + "    { \"amount\": 200, \"resource\": \"GLASS\" }\n"
                + "  ],\n"
                + "  \"heading\": \"W\"\n"
                + "}");
    }

    /**
     * Test of execute method, of class FlyingStrategy.
     */
    @Test
    public void testExecute() {
    }

    /**
     * Test of phase1 method, of class FlyingStrategy.
     */
    @Test
    public void testPhase1() {
        fstrat.nbtours =0;
        assertEquals(new Echo(fstrat.gauche(Direction.E)).toJSON().toString(), fstrat.execute());
        fstrat.nbtours = 5;
        assertEquals(new Stop().toJSON().toString(), fstrat.execute());
    }

    /**
     * Test of acknowledge method, of class FlyingStrategy.
     */
    @Test
    public void testAcknowledge() {
        fstrat.nbtours = 0;
        fstrat.acknowledge(new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }"));
        assertEquals(new FlyTile(Type.GROUND).getClass(), 
                fstrat.flyingMap.getTile(
                new Vect(2,fstrat.gauche(Direction.W)),
                new Vect(0, Direction.S)).getClass());
                
    }

}
