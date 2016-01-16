package fr.unice.polytech.qgl.qae.tools;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.resources.MissionAssignment;
import fr.unice.polytech.qgl.qae.map.HeadingType;
import fr.unice.polytech.qgl.qae.resources.Contract;
import fr.unice.polytech.qgl.qae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Loïc on 01/01/2016.
 */
public class JSONHelper {

    public JSONHelper(){}

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
        missionAssignment.setHeading(fr.unice.polytech.qgl.qae.actions.flyActions.withparams.HeadingType.valueOf(jsMissionAssignment.getString("heading")));
        // contracts (a list)
        JSONArray jsContracts = new JSONArray(jsMissionAssignment.getJSONArray("contracts"));
        for (int i = 0 ; i < jsContracts.length(); i++){
            JSONObject jsContract =jsContracts.getJSONObject(i);
            ResourceType resource = ResourceType.valueOf(jsContract.getString("resource"));
            int amount = jsContract.getInt("amount");
            missionAssignment.getContracts().add(new Contract(resource, amount));
        }

        return missionAssignment;
    }

    /**
     * String => Biome
     * @param s chaine convertible
     * @return un objet Biome
     */
    public Biome build_biome(String s) {
        return new Biome(BiomeType.valueOf(s));
    }
}
