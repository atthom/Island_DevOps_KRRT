/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class GroundReplyManager {

    public GroundReplyManager() {
    }
    
    
     public void manage(JSONObject js, GroundMap map, Direction d, Coordinates cc) {
        JSONObject extras = js.getJSONObject("extras");

        if (extras.has("altitude") && extras.has("resources")) {
            manage_scout(js, map, cc.getClose(d));
        } else if (extras.has("asked_range") && extras.has("report")) {
            //glimpse
        } else if (extras.has("resources") && extras.has("pois")) {
            // explore
        }
        // EXPLOIT AND TRANSFORM NOT IMPLEMENTEDs
    }
     

     /*
     Create and initialize ground tile from scoot action
     */
    private void manage_scout(JSONObject js, GroundMap map, Coordinates c) {
        JSONObject extras = js.getJSONObject("extras");
        GroundTile t = new GroundTile();
        int alt = extras.getInt("altitude");
        t.setAltitude(alt);

        JSONArray arr_res = extras.getJSONArray("resources");
        PrimaryResource p;
        for (int i = 0; i < arr_res.length(); i++) {
            p = new PrimaryResource();
            p.setName(arr_res.getString(i));
            t.getRessource().add(p);
        }

        map.put(c, t);
    }
}
