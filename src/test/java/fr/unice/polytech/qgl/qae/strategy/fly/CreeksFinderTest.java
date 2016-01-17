package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.choosecreeks.ChooseCreek;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by user on 19/12/2015.
 */
public class CreeksFinderTest {

    AbstractStrategy ex, ex2;
    CreeksFinder cf, cf2;
    FlyingMap m;
    FlyTile ocean;
    Objectif ob;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.E, ob);
        ex2 = new FlyingStrategy(Direction.E, ob);
        ArrayList<Biome> bs = new ArrayList<>();
        bs.add(new Biome(BiomeType.OCEAN));
        ocean = new FlyTile(bs, new ArrayList<>(), Type.OCEAN);
        
        m = new FlyingMap();
        m.put(new Coordinates(5,5), new FlyTile(Type.GROUND));
        cf = new CreeksFinder(ex, new Coordinates(5,5),Direction.S, m);
        cf2 = new CreeksFinder(ex2, new Coordinates(5,5),Direction.N, m);
        
        assertEquals(true, cf.turnleft );
        assertEquals(false, cf2.turnleft );
    }

    private void put(boolean beach_only) {
        JSONObject no = new JSONObject("{\n" +
                "    \"cost\": 5,\n" +
                "    \"extras\": {\n" +
                "      \"creeks\": [],\n" +
                "      \"biomes\": [\n" +
                "        \"BEACH\",\n" +
                "        \"OCEAN\"\n" +
                "      ]\n" +
                "    },\n" +
                "    \"status\": \"OK\"\n" +
                "  }");
        JSONObject yes = new JSONObject("{\n" +
                "    \"cost\": 7,\n" +
                "    \"extras\": {\n" +
                "      \"creeks\": [],\n" +
                "      \"biomes\": [\"OCEAN\"]\n" +
                "    },\n" +
                "    \"status\": \"OK\"\n" +
                "  }");
        if(beach_only) {
            cf.acknowledge(yes);
        } else {
            cf.acknowledge(no);
        }

    }
    
    private void putOcean2() {
        cf.map.put(new Coordinates(6, 6),ocean);
        cf.map.put(new Coordinates(7, 6),ocean);
    }
    private void putOcean() {
        cf.map.put(new Coordinates(6, 6),ocean);
    }
    private void putNotOcean2() {
        cf.map.put(new Coordinates(6, 6),new FlyTile());
        cf.map.put(new Coordinates(7, 6),new FlyTile());
    }
    private void putNotOcean() {
        cf.map.put(new Coordinates(6, 6),new FlyTile());
    }


    @Ignore
    public void testExecute() {
        assertEquals(new Fly(),cf.execute());
        cf.actions.remove(0);
        assertEquals(new Scan(),cf.execute());
        cf.actions.remove(0);
        assertTrue(cf.actions.isEmpty());
     
        put(false);

        assertEquals(new Fly(),cf.execute());
        cf.actions.remove(0);
        assertEquals(new Scan(),cf.execute());
        cf.actions.remove(0);
    }

    /**
     * Test of getNext method, of class CreeksFinder.
     */
    @Ignore
    public void testGetNext() {
        putOcean(); 
        assertEquals(cf, cf.getNext());

        putcreek();
        cf.actions.clear();
        assertEquals(new ChooseCreek(ex, cf.currents_coords, cf.d, m), cf.getNext());    
    }
    
    /**
     *
     */
    @Ignore
    public void testGetNext2() {
        putOcean2();
        cf.phaseA();
        cf.actions.clear();
        assertEquals(cf, cf.getNext());
        assertEquals(new Stop(),cf.actions.get(0)); 
    }

    /**
     * Test of last_is_only_ocean method, of class CreeksFinder.
     */
    @Test
    public void testLast_is_only_ocean() {
        cf.map.flush();
        putOcean();
        assertTrue(cf.last_is_only_ocean());
        cf.map.flush();
        putNotOcean();
        assertFalse(cf.last_is_only_ocean());
    }

    /**
     * Test of two_last_is_only_ocean method, of class CreeksFinder.
     */
    @Test
    public void testTwo_last_is_only_ocean() {
        cf.map.flush();
        putOcean2();
        assertTrue(cf.two_last_is_only_ocean());
        cf.map.flush();
        putNotOcean2();
        assertFalse(cf.two_last_is_only_ocean());
    }

    /**
     * Test of last_have_creek method, of class CreeksFinder.
     */
    private void putcreek() {
        ArrayList<String> cs = new ArrayList<>();
        cs.add("addad");
        cf.map.put(new Coordinates(7, 6), new FlyTile(new ArrayList<>(), cs, Type.GROUND));
    }
    
    @Test
    public void testLast_have_creek() {
        cf.map.put(new Coordinates(6, 6), new FlyTile());
        assertFalse(cf.last_have_creek());
        putcreek();
        assertTrue(cf.last_have_creek());
    }

    /**
     * Test of phaseA method, of class CreeksFinder.
     */
    @Test
    public void testPhaseA() {
        cf.turnleft = true;
        
        cf.map.flush();
        putOcean();
        cf.map.setMin(new Coordinates(0, 0));
        cf.map.setMax(new Coordinates(100, 100));
        cf.currents_coords = new Coordinates(4, 4);
        cf.phaseA();
        assertEquals(cf.actions.get(7), new Scan());
        assertEquals(cf.actions.get(8), new Fly());
        assertEquals(cf.actions.get(9), new Scan());
      
        
        cf.actions.clear();
        cf.map.flush();
        putOcean2();
        cf.map.setMin(new Coordinates(0, 0));
        cf.map.setMax(new Coordinates(100, 100));
        cf.currents_coords = new Coordinates(4, 4);
        cf.phaseA();
        assertEquals(cf.actions.get(7), new Scan());
        assertEquals(cf.actions.get(8), new Fly()); 
    }

    /**
     * Test of manageBC method, of class CreeksFinder.
     */
    @Test
    public void testManageBC() {
        cf.turnleft = true;
        cf.map.setMin(new Coordinates(0, 0));
        cf.map.setMax(new Coordinates(100, 100));
        cf.currents_coords = new Coordinates(4, 4);
        
        cf.manageBC();
        assertEquals(Direction.S.opposite(), cf.d);
        assertEquals(new Coordinates(4+1, 4), cf.currents_coords);
        
        
        cf.d = Direction.N;
        cf.currents_coords = new Coordinates(0, 50);
        cf.manageBC();
        assertEquals(Direction.N.opposite(), cf.d);
        assertEquals(new Coordinates(2, 50), cf.currents_coords);
        
        cf.d = Direction.N;
        cf.currents_coords = new Coordinates(50, 0);
        cf.manageBC();
        assertEquals(Direction.N.opposite(), cf.d);
        assertEquals(new Coordinates(48, 0), cf.currents_coords);
        
        cf.d = Direction.N;
        cf.currents_coords = new Coordinates(100, 50);
        cf.manageBC();
        assertEquals(Direction.N.opposite(), cf.d);
        assertEquals(new Coordinates(102,50), cf.currents_coords);
        
        cf.d = Direction.N;
        cf.currents_coords = new Coordinates(50, 100);
        cf.manageBC();
        assertEquals(Direction.N.opposite(), cf.d);
        assertEquals(new Coordinates(48, 100), cf.currents_coords);
    }

    /**
     * Test of phaseB method, of class CreeksFinder.
     */
    @Test
    public void testPhaseB() {
        cf.turnleft = true;
        cf.actions.clear();
        Coordinates c = cf.currents_coords;
        cf.phaseB();
        assertEquals(Direction.S.opposite(), cf.d);
        assertEquals(new Coordinates(c.getX()+1, c.getY()), cf.currents_coords);

        c = cf.currents_coords;
        cf.turnleft = false;
        cf.actions.clear();
        cf.phaseB();
        assertEquals(Direction.S.opposite().opposite(), cf.d);
        assertEquals(new Coordinates(c.getX()+1, c.getY()), cf.currents_coords);
    }

    /**
     * Test of phaseC method, of class CreeksFinder.
     */
    @Test
    public void testPhaseC() {
        cf.turnleft = true;
        cf.actions.clear();
        Coordinates c = cf.currents_coords;
        cf.phaseC();
        assertEquals(Direction.S.opposite(), cf.d);
        assertEquals(new Coordinates(c.getX()+2, c.getY()), cf.currents_coords);

        c = cf.currents_coords;
        cf.turnleft = false;
        cf.actions.clear();
        cf.phaseC();
        assertEquals(Direction.S.opposite().opposite(), cf.d);
        assertEquals(new Coordinates(c.getX()+2, c.getY()), cf.currents_coords);
      
    }
}