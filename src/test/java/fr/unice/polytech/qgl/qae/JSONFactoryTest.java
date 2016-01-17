/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package fr.unice.polytech.qgl.qae;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
/*
public class JSONFactoryTest {

    JSONFactory jfk;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        jfk = new JSONFactory();
    }

    /**
     * Test of build_res method, of class JSONFactory.
     */
/*
    @Test
    public void testBuild_res() {
        String res = "{ \"amount\": 600, \"resource\": \"WOOD\" }";
        assertEquals(600, jfk.build_res(res).getNbResourcesNeeded());
        assertEquals("WOOD", jfk.build_res(res).getName());
    }

    /**
     * Test of build_obj method, of class JSONFactory.
     */
/*
 
    @Test
    public void testBuild_obj() {
        String contract = "{ \n"
                + "  \"men\": 12,\n"
                + "  \"budget\": 10000,\n"
                + "  \"contracts\": [\n"
                + "    { \"amount\": 600, \"resource\": \"WOOD\" },\n"
                + "    { \"amount\": 200, \"resource\": \"GLASS\" }\n"
                + "  ],\n"
                + "  \"heading\": \"W\"\n"
                + "}";
        JSONObject obj = new JSONObject(contract);
        int men = obj.getInt("men");
        int budget = obj.getInt("budget");

        JSONArray arr = obj.getJSONArray("contracts");
        ArrayList<PrimaryResource> res = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            res.add(new PrimaryResource(o.getInt("amount"), o.getString("resource")));
        }
        assertEquals(12, jfk.build_obj(contract).getNb_mens());
        assertEquals(10000, jfk.build_obj(contract).getBudget());
        assertEquals(600, jfk.build_obj(contract).getRessource("WOOD").getNbResourcesNeeded());
        assertEquals(200, jfk.build_obj(contract).getRessource("GLASS").getNbResourcesNeeded());
        assertEquals(true, jfk.build_obj(contract).getRessource("WOOD").isNeeded());
        //assertEquals(jfk.build_obj(contract), new Objectif(men, budget, res));
 
    }

    /**
     * Test of build_biome method, of class JSONFactory.
     */
/*
    @Test
    public void testBuild_biome() {
        
        assertEquals(new Biome(BiomeType.GLACIER).getBiomeType(),jfk.build_biome("GLACIER").getBiomeType() );
        
    }

    /**
     * Test of build_heading method, of class JSONFactory.
     */
/*
    @Test
    public void testBuild_heading() {
        assertEquals(new Heading(Direction.N), jfk.build_heading("{ \"action\": \"heading\", \"parameters\": { \"direction\": \"N\" } }"));
        
    }

    /**
     * Test of build_unextracted_ressource method, of class JSONFactory.
     */
/*
    @Test
    public void testBuild_unextracted_ressource() {
        PrimaryResource a = new PrimaryResource();
        a.setName("WOOD");
        assertEquals(a, jfk.build_unextracted_ressource("WOOD"));
    }
    
    

}
*/