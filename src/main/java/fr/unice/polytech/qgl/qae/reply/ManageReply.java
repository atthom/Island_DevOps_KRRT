/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.resources.ResourceTile;
import fr.unice.polytech.qgl.qae.tools.JSONFactory;
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

        JSONObject extras = js.getJSONObject("extras");

        if (extras.length() == 0) {

        } else if (extras.has("range")) {
            map.getFlyingmap().put(currentCoords, new FlyTile(Type.UNKNOWN_TYPE));
            manage_echo(js, map, d);
        } else if (extras.has("biomes") && extras.has("creeks")) {
            map.getFlyingmap().put(currentCoords, new FlyTile(Type.UNKNOWN_TYPE));
            manage_scan(js, map, currentCoords);
        } else if (extras.has("altitude") && extras.has("resources")) {
            manage_scout(js, map, currentCoords.getClose(d));
        } else if (extras.has("asked_range") && extras.has("report")) {
            manage_glimpse(js,map,currentCoords,d);
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
        FlyTile t = new FlyTile(found);

        map.getFlyingmap().put(v.toCoord(), t);

    }

    private void manage_scan(JSONObject js, Map theMap, Coordinates currentCoords) {
        JSONFactory jfk = new JSONFactory();
        //JSONHelper jsh = new JSONHelper();
        JSONObject extras = js.getJSONObject("extras");

        JSONArray arr_biomes = extras.getJSONArray("biomes");
        ArrayList<Biome> biomes = new ArrayList<>();

        for (int i = 0; i < arr_biomes.length(); i++) {
            biomes.add(jfk.build_biome(arr_biomes.get(i).toString()));
        }

        JSONArray arr_creeks = extras.getJSONArray("creeks");
        ArrayList<String> creeks = new ArrayList<>();
        for (int i = 0; i < arr_creeks.length(); i++) {
            creeks.add(arr_creeks.getString(i));
        }

        theMap.getFlyingmap().maj(currentCoords, new FlyTile(biomes, creeks, Type.UNKNOWN_TYPE));
    }

    /*
     Create and initialize ground tile from scoot action
     */
    private void manage_scout(JSONObject js, Map map, Coordinates c) {
        JSONObject extras = js.getJSONObject("extras");

        GroundTile t = new GroundTile();
        int alt = extras.getInt("altitude");
        t.setAltitude(alt);

        JSONArray arr_res = extras.getJSONArray("resources");
        ResourceTile p;
        for (int i = 0; i < arr_res.length(); i++) {
            p = new ResourceTile();
            p.setResourceName(arr_res.getString(i));
          
        }

        map.getGroundmap().put(c, t);
    }

    private void manage_glimpse(JSONObject js, Map map,Coordinates c,Direction d) {

        Coordinates newCord = new Coordinates(c.getX(),c.getY());
        JSONObject extras = js.getJSONObject("extras");

        GroundTile t = new GroundTile();
        int range = extras.getInt("asked_range");

        if(d == Direction.N || d == Direction.S)
            newCord.setY(range);
        else
            newCord.setX(range);

        JSONArray arr_biomes = extras.getJSONArray("report");

        for (int i = 0; i < arr_biomes.getJSONArray(2).length(); i++) {
            if(arr_biomes.getJSONArray(2).get(i).equals("OCEAN"))
                t.getListe_biomes().add(BiomeType.OCEAN);
            if(arr_biomes.getJSONArray(2).get(i).equals("BEACH"))
                t.getListe_biomes().add(BiomeType.BEACH);
        }

        map.getGroundmap().put(c, t);
    }
}
