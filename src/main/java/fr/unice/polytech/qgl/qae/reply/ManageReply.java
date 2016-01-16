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
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.map.AbstractMap;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
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

    public void manage(JSONObject js, AbstractMap map, Direction d, Coordinates cc) {

        JSONObject extras = js.getJSONObject("extras");

        if (extras.length() == 0) {

        } else if (extras.has("range")) {           
            manage_echo(js, (FlyingMap) map,cc,d);
        } else if (extras.has("biomes") && extras.has("creeks")) {
            manage_scan(js,(FlyingMap) map, cc);
        } else if (extras.has("altitude") && extras.has("resources")) {
            manage_scout(js, (GroundMap)map, cc.getClose(d));
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
    private void manage_echo(JSONObject js,FlyingMap map, Coordinates cc, Direction d) {
        
        map.put(cc, new FlyTile(Type.UNKNOWN_TYPE));
        
        JSONObject extras = js.getJSONObject("extras");
        int range = extras.getInt("range");
        Type found = extras.getEnum(Type.class, "found");

        Vect v = new Vect(range, d);
        FlyTile t = new FlyTile(found);

        map.put(v.toCoord(), t);

    }

    private void manage_scan(JSONObject js, FlyingMap map, Coordinates cc) {
        
        JSONFactory jfk = new JSONFactory();
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

        map.maj(cc, new FlyTile(biomes, creeks, Type.UNKNOWN_TYPE));
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
