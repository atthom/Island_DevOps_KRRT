/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.composed.TurnToOppositeLeft;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.geometry.Vect2D;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
//mport fr.unice.polytech.qgl.qae.resources.ExtractedResource;
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

    Coordinates c1;
    Coordinates c2;
    Tile ocean;
    ArrayList<Biome> bocean;
    FlyingStrategy fstrat, fstratString;
    //ArrayList<ExtractedResource> a;

    public FlyingStrategyTest() {
    }

    @Before
    public void setUp() {
//        a = new ArrayList<>();
//        a.add(new ExtractedResource(600, "WOOD"));
//        a.add(new ExtractedResource(200, "GLASS"));
        c1 = new Coordinates(10, 10);
        c2 = new Coordinates(5, 5);
        bocean = new ArrayList<>();
        bocean.add(new Biome(BiomeType.OCEAN));
        
        ocean = new FlyTile(bocean, new ArrayList<>(), Type.UNKNOWN_TYPE);

        fstrat = new FlyingStrategy(new Heading(Direction.E));
    }

    /**
     * Test of execute method, of class FlyingStrategy.
     */
    @Ignore
    public void testExecute() {
    }

    /**
     * Test of phase1 method, of class FlyingStrategy.
     */
    @Test
    public void testPhase1() {
        fstrat.nbtours = 0;
        fstrat.actions.clear();
        String echo1 = "{\n"
                + "    \"cost\": 3,\n"
                + "    \"extras\": {\n"
                + "      \"found\": \"OUT_OF_RANGE\",\n"
                + "      \"range\": 4\n"
                + "    },\n"
                + "    \"status\": \"OK\"\n"
                + "  }";
        String echo2 = "{\n"
                + "    \"cost\": 4,\n"
                + "    \"extras\": {\n"
                + "      \"found\": \"OUT_OF_RANGE\",\n"
                + "      \"range\": 28\n"
                + "    },\n"
                + "    \"status\": \"OK\"\n"
                + "  }";
        String echo3 = "{\n"
                + "    \"cost\": 4,\n"
                + "    \"extras\": {\n"
                + "      \"found\": \"GROUND\",\n"
                + "      \"range\": 10\n"
                + "    },\n"
                + "    \"status\": \"OK\"\n"
                + "  }";
        JSONObject o1 = new JSONObject(echo1);
        JSONObject o2 = new JSONObject(echo2);
        JSONObject o3 = new JSONObject(echo3);

        fstrat.manager.manage(o1, fstrat.flyingMap, Direction.N, c1);
        fstrat.manager.manage(o2, fstrat.flyingMap, Direction.S, c1);
        fstrat.manager.manage(o3, fstrat.flyingMap, Direction.E, c1);

        fstrat.phase1();

        assertTrue(!fstrat.actions.isEmpty());

    }

    /**
     * Test of acknowledge method, of class FlyingStrategy.
     */
    @Ignore
    public void testAcknowledge() {
        fstrat.nbtours = 0;
        fstrat.acknowledge(new JSONObject("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }"));

        Vect2D cd = new Vect2D(new Vect(0, Direction.E).toCoord(), new Vect(2, fstrat.d.left()).toCoord());
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

    }

    /**
     * Test of phase3 method, of class FlyingStrategy.
     */
    @Ignore
    public void testPhase3() {
     
        fstrat.flyingMap.put(new Coordinates(5, 0), new FlyTile());
        fstrat.flyingMap.put(new Coordinates(2, 0), new FlyTile());
        fstrat.flyingMap.put(new Coordinates(3, 0), new FlyTile());
        fstrat.flyingMap.put(new Coordinates(4, 0), new FlyTile());
        fstrat.flyingMap.put(new Coordinates(5, 0), new FlyTile());
        
        
        fstrat.flyingMap.put(c1, ocean);
        fstrat.currents_coords = c1;
        fstrat.phase3();
        
        

        
//        ArrayList<Biome> ab = new ArrayList<>();
//        ArrayList<Creek> cr = new ArrayList<>();
//        ab.add(new Biome(BiomeType.BEACH));
//        fstrat.currents_coords = c1;
//        fstrat.flyingMap.put(c1, new FlyTile(ab, cr, Type.UNKNOWN_TYPE));
//        fstrat.phase3();
//        
//        fstrat.actions.clear();
//
//        ab.add(new Biome(BiomeType.BEACH));
//        ab.add(new Biome(BiomeType.OCEAN));
//
//        fstrat.currents_coords = c2;
//        fstrat.flyingMap.put(c2, new FlyTile(ab, cr, Type.UNKNOWN_TYPE));
//
//        
//        TurnToOppositeLeft ta = new TurnToOppositeLeft(c2, fstrat.d);
//        // ta.addAll(new FlyUntil(fstrat.flyingMap.getfirstground(), ta.getCoords(), ta.getDir()));
//        fstrat.phase3();
////        for(AbstractAction ac : ta.getAll()) {
////            System.out.println(ac.toJSON());
////        }
////        System.out.println("*********");
////        for(AbstractAction ac : fstrat.actions) {
////            System.out.println(ac.toJSON());
////        }
//        assertEquals(ta.getAll(), fstrat.actions);

    }

    /**
     * Test of manageComposedAction method, of class FlyingStrategy.
     */
    @Test
    public void testManageComposedAction() {
    }

}
