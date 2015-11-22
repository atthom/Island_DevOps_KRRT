/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.map.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ManageReply {

    public ManageReply() {
    }

    public void manage_echo(JSONObject js, Map map, Direction d, Objectif o) {
        JSONObject extras = js.getJSONObject("extras");
        int range = extras.getInt("range");

        int cost = js.getInt("cost");
        o.enleve_PA(cost);

        Type found = Type.valueOf(extras.get("found").toString());

        Vect v = new Vect(range, d);
        Tile t = new FlyTile(found);

        map.add(v,t );

    }
    public void manage_scan(JSONObject js, Map map) {

        JSONObject extras = js.getJSONObject("extras");
        JSONArray biomes = extras.getJSONArray("biomes");

        String id = String.valueOf(extras.get("creek").toString());

        for (int i = 0; i < biomes.length(); i++) {
            //map.getTile();
        }

        Creek c = new Creek(id);

        
    }
}
