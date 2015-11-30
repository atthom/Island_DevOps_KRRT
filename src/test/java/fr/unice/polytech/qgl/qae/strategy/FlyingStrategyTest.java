/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import com.vividsolutions.jts.geom.Coordinate;
import fr.unice.polytech.qgl.qae.actions.*;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.geometry.Vect2D;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.resources.ExtractedResource;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlyingStrategyTest {

    FlyingStrategy fstrat, fstratString;

    public FlyingStrategyTest() {
    }

    @Before
    public void setUp() {
        ArrayList<ExtractedResource> a = new ArrayList<>();
        a.add(new ExtractedResource(600, "WOOD"));
        a.add(new ExtractedResource(200, "GLASS"));

        fstrat = new FlyingStrategy(new Heading(Direction.E));
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
    @Ignore
    public void testPhase1() {
        fstrat.nbtours = 0;
        assertEquals(new Echo(fstrat.h.getValueParameter().gauche()).toJSON().toString(), fstrat.execute());
        fstrat.nbtours = 5;
        assertEquals(new Fly().toJSON().toString(), fstrat.execute());
    }

    /**
     * Test of acknowledge method, of class FlyingStrategy.
     */
    @Test
    public void testAcknowledge() {
        fstrat.nbtours = 0;
        fstrat.acknowledge(new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }"));

        Vect2D cd = new Vect2D(new Vect(0, Direction.E).toCoord(), new Vect(2, fstrat.h.getValueParameter().gauche()).toCoord());
        assertEquals(new FlyTile(Type.GROUND), fstrat.flyingMap.getTile(cd.toCoord()));

    }

    /**
     * Test of turnaround method, of class FlyingStrategy.
     */
    @Test
    public void testTurnaround() {

    }

    /**
     * Test of phase2 method, of class FlyingStrategy.
     */
    @Test
    public void testPhase2() {
        fstrat.flyingMap.put(new Coordinates(5, 5), new FlyTile(Type.GROUND));

        for (int i = 0; i < 15; i++) {
            try {
                fstrat.phase2();
            } catch (MapExeption ex) {
                assertEquals(new Coordinates(5, 5), fstrat.currents_coords);
            }
            fstrat.maj_coord();
        }

    }

    /**
     * Test of flyandScan method, of class FlyingStrategy.
     */
    @Test
    public void testFlyandScan() {
    }

    /**
     * Test of phase3 method, of class FlyingStrategy.
     */
    @Test
    public void testPhase3() {
    }

}
