/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.Heading;

/**
 *
 * @author user
 */
public class FlyingStrategy  extends Strategy{
    Heading h;
    
    public FlyingStrategy(String heading) {
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
    }

    public FlyingStrategy(Heading heading) {
        h = heading;
    }
    
    @Override
    void execute() {
        
    }
    
    
    
    
    
    
    
    
    
}
