package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 19/12/2015.
 */
public class CreeksFinderTest {

    AbstractStrategy ex;
    CreeksFinder cf;
    Map m;

    @Before
    public void setUp() throws Exception {
        ex = new FlyingStrategy(Direction.E);
        m = new Map();
        m.getFlyingmap().put(new Coordinates(5,5), new FlyTile(Type.GROUND));
        cf = new CreeksFinder(ex, new Coordinates(5,5),Direction.E, m);
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

    @Test
    public void testExecute() throws Exception {
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
}