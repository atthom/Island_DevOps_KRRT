/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp;

import eu.ace_design.island.mvp.map.resources.ExtractedResource;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ObjectifTest {

    Objectif o;

    public ObjectifTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
        ArrayList<ExtractedResource> a = new ArrayList<>();
        a.add(new ExtractedResource(600, "WOOD"));
        a.add(new ExtractedResource(200, "GLASS"));
        o = new Objectif(12, 10000, a);

    }

    /**
     * Test of getNb_mens method, of class Objectif.
     */
    @Test
    public void testGetNb_mens() {
        assertEquals(o.getNb_mens(), 12);
    }

    /**
     * Test of getBudget method, of class Objectif.
     */
    @Test
    public void testGetBudget() {
        assertEquals(o.getBudget(), 10000);
    }

    /**
     * Test of enleve_PA method, of class Objectif.
     */
    @Test
    public void testEnleve_PA() {
        o.enleve_PA(1000);
        assertEquals(9000, o.getBudget());
    }

    /**
     * Test of getRessource method, of class Objectif.
     */
    @Test
    public void testGetRessource() {
        assertEquals(o.getRessource("WOOD").getName(), new ExtractedResource(600, "WOOD").getName());
        assertEquals(o.getRessource("WOOD").getNb(), new ExtractedResource(600, "WOOD").getNb());
        
        
        assertEquals(o.getRessource("NOPE").getName(), new ExtractedResource(0, "").getName());
        assertEquals(o.getRessource("NOPE").getNb(), new ExtractedResource(0, "").getNb());
    }

    /**
     * Test of enleve_ressource method, of class Objectif.
     */
    @Test
    public void testEnleve_ressource() {
        o.enleve_ressource(new ExtractedResource(100, "WOOD"));
        assertEquals(o.getRessource("WOOD").getName(), new ExtractedResource(500, "WOOD").getName());
        assertEquals(o.getRessource("WOOD").getNb(), new ExtractedResource(500, "WOOD").getNb());

        o.enleve_ressource(new ExtractedResource(1000, "WOOD"));
        assertEquals(o.getRessource("WOOD").getName(), new ExtractedResource(0, "").getName());
        assertEquals(o.getRessource("WOOD").getNb(), new ExtractedResource(0, "").getNb());
    }

}
