/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.withparams;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class HeadingTest {

    Heading h2;

    Heading hE, hS, hN, hW;
    Coordinates c;
    Direction E, S, N, W;

    public HeadingTest() {
    }

    @Before
    public void setUp() {
        hE = new Heading(Direction.E);
        h2 = new Heading("{\"direction\":\"E\"}");
        assertEquals(hE, h2);
        c = new Coordinates(0, 0);
        E = Direction.E;
        S = Direction.S;
        W = Direction.W;
        N = Direction.N;
        hS = new Heading(S);
        hW = new Heading(W);
        hN = new Heading(N);
    }

    @Test
    public void testSomeMethod() {

        JSONObject o = new JSONObject("{\"action\":\"heading\",\"parameters\":{\"direction\":\"E\"}}");
        JSONObject paraO = o.getJSONObject("parameters");
        JSONObject parage = hE.toJSON().getJSONObject("parameters");
        assertEquals(o.get("action"), hE.toJSON().get("action"));
        assertEquals(paraO.getEnum(Direction.class, "direction"), parage.getEnum(Direction.class, "direction"));
    }

    /**
     * Test of getValueParameter method, of class Heading.
     */
    @Test
    public void testGetValueParameter() {
        assertEquals(Direction.E, hE.getValueParameter());
    }

    /**
     * Test of maj_coord method, of class Heading.
     */
    @Test
    public void testMaj_coordE() {
        hE.maj_coord(c, E, S);
        assertEquals(new Coordinates(1, -1), c);

        c = new Coordinates(0, 0);
        hE.maj_coord(c, E, N);
        assertEquals(new Coordinates(1, 1), c);

    }

    @Test
    public void testMaj_coordW() {
        hE.maj_coord(c, W, S);
        assertEquals(new Coordinates(-1, -1), c);

         c = new Coordinates(0, 0);
        hE.maj_coord(c, W, N);
        assertEquals(new Coordinates(-1, 1), c);

    }

    @Test
    public void testMaj_coordS() {
        hE.maj_coord(c, S, W);
        assertEquals(new Coordinates(-1, -1), c);

        c = new Coordinates(0, 0);
        hE.maj_coord(c, S, E);
        assertEquals(new Coordinates(1, -1), c);

    }

    @Test
    public void testMaj_coordN() {
        hE.maj_coord(c, N, W);
        assertEquals(new Coordinates(-1, 1), c);

         c = new Coordinates(0, 0);
        hE.maj_coord(c, N, E);
        assertEquals(new Coordinates(1, 1), c);

    }

}
