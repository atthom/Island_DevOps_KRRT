/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import java.util.ArrayList;

/**
 *
 * @author user
 */
abstract public class ActionWithParameters extends AbstractAction {
    ArrayList<Parameter> parameters;
    
    public ActionWithParameters(ArrayList<Parameter> p) {
        super();
        parameters = new ArrayList<>();
        parameters.addAll(p);
    }
    
    public ActionWithParameters(Parameter p) {
        super();
        parameters = new ArrayList<>();
        parameters.add(p);
    }
    
    @Override
    abstract String actionExecute();
}
