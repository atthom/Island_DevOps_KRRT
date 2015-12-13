/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.withparams;

import fr.unice.polytech.qgl.qae.map.tile.Creek;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Land  extends ActionWithParameters{
    
    public Land(Creek c, int nbPeople) {
        super(new ArrayList<>(), "land");
        parameters.add(new Parameter("creek",c.getId()));
        parameters.add(new Parameter("people",nbPeople));     
    }

    @Override
    public Object getValueParameter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
