/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MoveToTest {
    MoveTo mE,m2, mS,mN, mW;
    
    public MoveToTest() {
      
    }
    
    @Before
    public void setUp() {
        mE = new MoveTo(Direction.E);
        m2 = new MoveTo("{\"direction\":\"E\"}");
        assertEquals(mE,m2);
    }

    /**
     * Test of getValueParameter method, of class MoveTo.
     */
    @Test
    public void testGetValueParameter() {
         JSONObject o = new JSONObject("{\"action\":\"move_to\",\"parameters\":{\"direction\":\"E\"}}");
        assertEquals(o.get("action"), mE.toJSON().get("action"));
        assertEquals(o.getJSONObject("parameters").getEnum(Direction.class, "direction"),
                mE.toJSON().getJSONObject("parameters").getEnum(Direction.class, "direction"));
    }

    /**
     * Test of maj_coord method, of class MoveTo.
     */
    @Test
    public void testMaj_coord() {
        Coordinates c = new Coordinates(0, 0);
        mE.maj_coord(c);  
        assertEquals(new Coordinates(1, 0),c);
        mS = new MoveTo(Direction.S);
        mS.maj_coord(c);
        assertEquals(new Coordinates(1, -1),c);
        mN = new MoveTo(Direction.N);
        mN.maj_coord(c);
        assertEquals(new Coordinates(1, 0),c);
        mW = new MoveTo(Direction.W);
        mW.maj_coord(c);
        assertEquals(new Coordinates(0, 0),c);
    }
    
}
