/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.reply;

import fr.unice.polytech.qgl.qae.actions.Parameter;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class AbstractReply {

    private final int cost;
    private final Boolean status;
    private ArrayList<Parameter> extras;

    public AbstractReply(String s) {
        JSONObject o = new JSONObject(s);
        if (o.has("cost")) {
            this.cost = o.getInt("cost");
        } else {
            cost = 0;
        }

        if (o.has("status")) {
            this.status = o.get("status").equals("OK");
        } else {
            this.status = false;
        }
        extras = new ArrayList<>();
              
    }
    
    
    public void getextras() {
        
    }

    public int getCost() {
        return cost;
    }

    public Boolean getStatus() {
        return status;
    }

}
