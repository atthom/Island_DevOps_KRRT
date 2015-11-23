/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.map.FlyTile;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Tile;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.Vect;
import org.json.JSONObject;

/**
 * Classe qui gère toutes les réponses du moteur de jeu
 * @author user
 */
public class ManageReply {

    /**
     *
     */
    public ManageReply() {
    }

    /**
     * gère la réponse de l'action Echo
     * @param js un objet JSON
     * @param map la carte utilisée
     * @param d la direction de l'appel à echo
     */
    public void manage_echo(JSONObject js, Map map, Direction d) {
        JSONObject extras = js.getJSONObject("extras");
        int range = extras.getInt("range");

        Type found = Type.valueOf(extras.get("found").toString());
        
        Vect v = new Vect(range, d);
        Tile t = new FlyTile(found);

        map.add(v,t );

    }

}
