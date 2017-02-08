/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thom
 */
public class GlimpseTest {
  Glimpse gE;
  public GlimpseTest() {
  }
  
  @Before
  public void setUp() {
    gE = new Glimpse(Direction.E, 3);
  }

  /**
   * Test of getValueParameter method, of class Glimpse.
   */
  @Test
  public void testGetValueParameter() {
    assertEquals(Direction.E, gE.getValueParameter());
  
  }
  
  /**
   * Test of getRange method, of class Glimpse.
   */
  @Test
  public void testGetRange() {
    assertEquals(3, gE.getRange());
  }
  
  /**
   * Test of JSON method, of class Glimpse.
   */
  @Test
  public void testJSON() {
   JSONObject o = new JSONObject("{ \"action\": \"glimpse\", \"parameters\": { \"direction\": \"E\", \"range\": 3 } }");
        assertEquals(o.get("action"), gE.toJSON().get("action"));
        assertEquals(o.getJSONObject("parameters").getEnum(Direction.class, "direction"),
                gE.toJSON().getJSONObject("parameters").getEnum(Direction.class, "direction"));
         assertEquals(o.getJSONObject("parameters").getInt("range"),
                gE.toJSON().getJSONObject("parameters").getInt("range"));
  }
  
}
