/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.tools;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;


import fr.unice.polytech.qgl.qae.resources.Contract;
import fr.unice.polytech.qgl.qae.resources.MissionAssignment;
import fr.unice.polytech.qgl.qae.resources.OldResource;
import fr.unice.polytech.qgl.qae.resources.ResourceType;
import org.json.*;

import java.util.ArrayList;

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
    public MissionAssignment build_obj(String s) {
        JSONObject o = new JSONObject(s);
        JSONArray arr = o.getJSONArray("contracts");
        ArrayList<Contract> res = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            res.add(build_res(arr.getJSONObject(i).toString()));
        }
         //We pass all boolean for needed resources to true
        for(int i = 0; i < res.size(); i++){
            res.get(i).setNeeded(true);
        }

     //   return new Objectif(o.getInt("men"), o.getInt("budget"), res);
  //  }
  */

    
    /**
     * String => Biome
     * @param s chaine convertible
     * @return un objet Biome
     */
   /* public Biome build_biome(String s) {
        return new Biome(BiomeType.valueOf(s));
    }*/
    
    /**
     * String => Heading
     * @param s chaine convertible
     * @return un objet Heading
     */
    //public Heading build_heading(String s) {
       // JSONObject o = new JSONObject(s);
       // String head;
      //  if(o.has("heading")) {
      //      head = new JSONObject(s).getString("heading");
        //} else{
      //      JSONObject para = new JSONObject(s).getJSONObject("parameters");
       //     head = para.getString("direction");
       // }

      //  return new Heading(Direction.valueOf(head));
   // }

    /**
     * String => UnextractedRessource
     * @param s chaine convertible
     *          @return un objet UnextractedRessource
     */
    //public OldResource build_unextracted_ressource(String s){
       // OldResource r = new OldResource();
     //   r.setName(s);
     //   return r;
    //}

    /**
     * This method is used to create a mission assignment with a JSON string
     * @param message will be the JSON string
     * @return a MissionAssignment object
     */
    public MissionAssignment getMissionAssignmentFromJSONString(String message){
        JSONObject jsMissionAssignment = new JSONObject(message);
        MissionAssignment missionAssignment = new MissionAssignment();
        // number of men
        missionAssignment.setNb_men(jsMissionAssignment.getInt("men"));
        // budget
        missionAssignment.setBudget(jsMissionAssignment.getInt("budget"));
        // heading at the beginning
        missionAssignment.setHeading(Direction.valueOf(jsMissionAssignment.getString("heading")));
        // contracts (a list)
        JSONArray jsContracts = jsMissionAssignment.getJSONArray("contracts");
        for (int i = 0 ; i < jsContracts.length(); i++){
            JSONObject jsContract =jsContracts.getJSONObject(i);
            ResourceType resource = ResourceType.valueOf(jsContract.getString("resource"));
            int amount = jsContract.getInt("amount");
            missionAssignment.getContracts().add(new Contract(resource, amount));
        }

        return missionAssignment;
    }


    /**
     * String => Contract
     * @param theJSON the string from JSON
     * @return a ResourceTile object
     */
    public Contract createContractFromJSONString(String theJSON){
        JSONObject json = new JSONObject(theJSON);
        int amount = json.getInt("amount");
        String resourceName = json.getString("resource");
        return new Contract(resourceName, amount);

    }


}
