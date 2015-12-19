/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import org.json.*;
import java.util.ArrayList;

/**
 * Classe qui gère toutes les réponses du moteur de jeu
 *
 * @author user
 */
public class ManageReply {

    /**
     *
     */
    public ManageReply() {
    }

    public void manage(JSONObject js, Map map, Direction d, Coordinates currentCoords) {

         map.put(currentCoords, new FlyTile(Type.UNKNOWN_TYPE));
         
         
        JSONObject extras = js.getJSONObject("extras");

        if (extras.length() == 0) {

        } else if (extras.has("range")) {
            manage_echo(js, map, d);
        } else if (extras.has("biomes") && extras.has("creeks")) {
            manage_scan(js, map, currentCoords);
        } else if (extras.has("altitude") && extras.has("resources")) {
            //scout
        } else if (extras.has("asked_range") && extras.has("report")) {
            //glimpse
        } else if (extras.has("resources") && extras.has("pois")) {
            // explore
        }
        // EXPLOIT AND TRANSFORM NOT IMPLEMENTED
        
       
    }

    /**
     * gère la réponse de l'action Echo
     *
     * @param js un objet JSON
     * @param map la carte utilisée
     * @param d la direction de l'appel à echo
     */
    private void manage_echo(JSONObject js, Map map, Direction d) {
        JSONObject extras = js.getJSONObject("extras");
        int range = extras.getInt("range");
        Type found = extras.getEnum(Type.class, "found");

        Vect v = new Vect(range, d);
        Tile t = new FlyTile(found);

        map.put(v.toCoord(), t);

    }

    private void manage_scan(JSONObject js, Map map, Coordinates currentCoords) {
        JSONFactory jfk = new JSONFactory();
        JSONObject extras = js.getJSONObject("extras");

        JSONArray arr_biomes = extras.getJSONArray("biomes");
        ArrayList<Biome> biomes = new ArrayList<>();

        for (int i = 0; i < arr_biomes.length(); i++) {
            biomes.add(jfk.build_biome(arr_biomes.get(i).toString()));
        }

        JSONArray arr_creeks = extras.getJSONArray("creeks");
        ArrayList<Creek> creeks = new ArrayList<>();
        for (int i = 0; i < arr_creeks.length(); i++) {
            creeks.add(new Creek(arr_creeks.getString(i)));
        }

        map.maj(currentCoords, new FlyTile(biomes, creeks, Type.UNKNOWN_TYPE));
    }
}
