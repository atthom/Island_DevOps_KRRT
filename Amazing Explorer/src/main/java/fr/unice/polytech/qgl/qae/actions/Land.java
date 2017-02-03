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
public class Land  extends ActionWithParameters {
    
    public Land(String c, int nbPeople) {
        super(new ArrayList<>(), "land");
        parameters.add(new Parameter("creek",c));
        parameters.add(new Parameter("people",nbPeople));     
    }

    @Override
    public Object getValueParameter() {
       return parameters.get(0).getValeur();
    }

}
