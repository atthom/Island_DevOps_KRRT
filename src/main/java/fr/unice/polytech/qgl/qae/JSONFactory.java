/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.resources.ExtractedResource;
import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author user
 */
public class JSONFactory {

    public JSONFactory() {
    }

    public ExtractedResource build_res(String s) {
        JSONObject o = new JSONObject(s);
        return new ExtractedResource(o.getInt("amount"), o.getString("resource"));

    }

    public Objectif build_obj(String s) {
        JSONObject o = new JSONObject(s);
        JSONArray arr = o.getJSONArray("contracts");
        ArrayList<ExtractedResource> res = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            res.add(build_res(arr.getJSONObject(i).toString()));
        }

        return new Objectif(o.getInt("men"), o.getInt("budget"), res);
    }
    
    public Biome build_biome(String s) {
        return new Biome(BiomeType.valueOf(s));
    }
    
    
    
}
