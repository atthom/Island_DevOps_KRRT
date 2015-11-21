/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author user
 */
abstract public class ActionWithParameters extends AbstractAction {

    protected ArrayList<Parameter> parameters;

    public ActionWithParameters(ArrayList<Parameter> p, String name) {
        super(name);
        parameters = new ArrayList<>();
        parameters.addAll(p);

    }

    public ActionWithParameters(Parameter p, String name) {
        super(name);
        parameters = new ArrayList<>();
        parameters.add(p);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        o.put("action", getName());
        JSONObject a = new JSONObject();
        for (Parameter p : this.parameters) {
            a.put(p.getArgument(), p.getValeur());
        }

        o.put("parameters", a);
        return o;
    }

    abstract public Object getValueParameter(); 
    
    
}


