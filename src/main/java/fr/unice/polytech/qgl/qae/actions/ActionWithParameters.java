/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONObject;

/**
 * Permet de créer facilement des réponse JSON
 * pour des  actions avec parametres
 * @author user
 */
abstract public class ActionWithParameters extends AbstractAction {

    /**
     * 
     */
    protected ArrayList<Parameter> parameters;

    /**
     *
     * @param p : liste de paramètres (nom du parametre, valeur)
     * @param name : nom de l'action
     */
    public ActionWithParameters(ArrayList<Parameter> p, String name) {
        super(name);
        parameters = new ArrayList<>();
        parameters.addAll(p);
    }

    /**
     *
     * @param p parametre(nom, valeur)
     * @param name nom de l'action
     */
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

    /**
     *
     * @return la valeur du parametre
     */
    abstract public Object getValueParameter(); 

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActionWithParameters other = (ActionWithParameters) obj;
        return Objects.equals(this.parameters, other.parameters);
    }


    
    
    
    
    
}


