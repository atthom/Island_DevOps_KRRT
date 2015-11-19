/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.Creek;
import java.util.ArrayList;
import jdk.nashorn.internal.scripts.JS;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class ScanReply extends AbstractReply {
    ArrayList<Biome> biomes;
    ArrayList<Creek> creeks;
    
    public ScanReply (String s) {
        super(s);
        biomes = new ArrayList<>();
        JSONObject o = new JSONObject(s).getJSONObject("extras");
        JSONArray arr = o.getJSONArray("biomes");
        
        JSONFactory jfk = new JSONFactory();
        for(int i=0; i< arr.length(); i++) {
            biomes.add(jfk.build_biome(arr.get(i).toString()));
        }
        
        creeks= new ArrayList<>();
        JSONArray cre = o.getJSONArray("creeks");
        
        for(int i=0; i<cre.length();i++) {
            creeks.add(new Creek(cre.get(i).toString()));
        }
        
        
        
        
             
    }
    
    
}
