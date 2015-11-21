package fr.unice.polytech.qgl.qae.actions;

import org.json.JSONObject;

/**
 * Created by Lo�c on 11/15/2015.
 *
 * Classe abstraite qui sera la classe mere de toutes les classe particulieres aux commandes
 */
public abstract class AbstractAction {

    private int actionCost;
    private final String name;

    public AbstractAction(String name){
        this.name = name;
        actionCost=0;
    }

    public String getName() {
        return name;
    }
    
    public void setActionCost(int cost){
        this.actionCost = cost;
    }
    public int getActionCost() {
        return this.actionCost;
    }
    
    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        o.put("action", name);
        return o;
    }
    
}
