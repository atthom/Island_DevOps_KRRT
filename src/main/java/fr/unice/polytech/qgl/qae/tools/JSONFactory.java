/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.tools;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;

import fr.unice.polytech.qgl.qae.resources.OldResource;
import org.json.*;

/**
 *
 * @author user
 */
public class JSONFactory {

    /** 
     * Classe de transfere entre une chaine de caractères
     * formaté JSON et un objet utilisé par l'explorer.
     */
    public JSONFactory() {
    }

    /**
     * String => OldResource
     * @param s chaine convertible
     * @return un objet de ressource extraite
     *
     */
    public OldResource build_res(String s) {
        JSONObject o = new JSONObject(s);
        return new OldResource(o.getInt("amount"), o.getString("resource"));

    }

    /**
     * String => Objectif
     * @param s chaine convertible
     * @return un objet objectif
     */
    /*
    public Objectif build_obj(String s) {
        JSONObject o = new JSONObject(s);
        JSONArray arr = o.getJSONArray("contracts");
        ArrayList<Contract> res = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            res.add(build_res(arr.getJSONObject(i).toString()));
        }
        // We pass all boolean for needed resources to true
        for(int i = 0; i < res.size(); i++){
            res.get(i).setNeeded(true);
        }

        return new Objectif(o.getInt("men"), o.getInt("budget"), res);
    }
    */
    
    /**
     * String => Biome
     * @param s chaine convertible
     * @return un objet Biome
     */
    public Biome build_biome(String s) {
        return new Biome(BiomeType.valueOf(s));
    }
    
    /**
     * String => Heading
     * @param s chaine convertible
     * @return un objet Heading
     */
    public Heading build_heading(String s) {
        JSONObject o = new JSONObject(s);
        String head;
        if(o.has("heading")) {
            head = new JSONObject(s).getString("heading");
        } else{
            JSONObject para = new JSONObject(s).getJSONObject("parameters");
            head = para.getString("direction");
        }  

        return new Heading(Direction.valueOf(head));
    }

    /**
     * String => UnextractedRessource
     * @param s chaine convertible
     *          @return un objet UnextractedRessource
     */
    public OldResource build_unextracted_ressource(String s){
        OldResource r = new OldResource();
        r.setName(s);
        return r;
    }


}
