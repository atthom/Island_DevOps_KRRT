/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae;
 
import fr.unice.polytech.qgl.qae.resources.Resource;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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

    @Test
    public void setUp() {
        ArrayList<Resource> a = new ArrayList<>();
        a.add(new Resource(600, "WOOD"));
        a.add(new Resource(200, "GLASS"));
        o = new Objectif(12, 10000, a);

    }

    /**
     * Test of getNb_mens method, of class Objectif.
     */
    @Ignore
    public void testGetNb_mens() {
        assertEquals(o.getNb_mens(), 12);
    }

    /**
     * Test of getBudget method, of class Objectif.
     */
    @Ignore
    public void testGetBudget() {
        assertEquals(o.getBudget(), 10000);
    }

    /**
     * Test of enleve_PA method, of class Objectif.
     */
    @Ignore
    public void testEnleve_PA() {
        o.enleve_PA(1000);
        assertEquals(9000, o.getBudget());
    }

    /**
     * Test of getRessource method, of class Objectif.
     */
    @Ignore
    public void testGetRessource() {
        assertEquals(o.getRessource("WOOD").getName(), new Resource(600, "WOOD").getName());
        assertEquals(o.getRessource("WOOD").getNbExploitedRessource(), new Resource(600, "WOOD").getNbExploitedRessource());
        assertEquals(o.getRessource("NOPE").getName(), new Resource(0, "").getName());
        assertEquals(o.getRessource("NOPE").getNbExploitedRessource(), new Resource(0, "").getNbExploitedRessource());
    }

    /**
     * Test of enleve_ressource method, of class Objectif.
     */
    @Ignore
    public void testEnleve_ressource() {
        o.enleve_ressource(new Resource(100, "WOOD"));
        assertEquals(o.getRessource("WOOD").getName(), new Resource(500, "WOOD").getName());
        assertEquals(o.getRessource("WOOD").getNbExploitedRessource(), new Resource(500, "WOOD").getNbExploitedRessource());

        o.enleve_ressource(new Resource(1000, "WOOD"));
        assertEquals(o.getRessource("WOOD").getName(), new Resource(0, "").getName());
        assertEquals(o.getRessource("WOOD").getNbExploitedRessource(), new Resource(0, "").getNbExploitedRessource());
        
    }

}
