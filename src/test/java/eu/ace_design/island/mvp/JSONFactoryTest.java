/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.JSONFactory;
import eu.ace_design.island.mvp.map.resources.ExtractedResource;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
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
    @Test
    public void testBuild_res() {
        String res = "{ \"amount\": 600, \"resource\": \"WOOD\" }";       
        assertEquals(jfk.build_res(res).toString(), new ExtractedResource(600, "WOOD").toString());
        
    }
   

    /**
     * Test of build_obj method, of class JSONFactory.
     */
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
        ArrayList<ExtractedResource> res = new ArrayList<>();
        for(int i=0; i< arr.length();i++) {
            JSONObject o = arr.getJSONObject(i);
            res.add(new ExtractedResource(o.getInt("amount"), o.getString("resource")));
        }
        
        assertEquals(jfk.build_obj(contract).toString(), new Objectif(men, budget, res).toString());
         
    }
    
}
