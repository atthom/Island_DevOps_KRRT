/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;

/**
 *
 * @author user
 */
public class TurnAround extends ComposedAction {
//String turnaround() {
//        
//                lastaction = change_heading(gauche(h.getValueParameter()));
//            
//                
//                return new Fly();
//            
//                
//                lastaction = change_heading(gauche(h.getValueParameter()));
//             
//                
//                lastaction = new Fly();
//                
//                
//        }
//    }
    public TurnAround(Direction d) {
        super();
        add(new Heading(d.gauche()));
        add(new Fly());
        add(new Heading(d.gauche().gauche()));
        add(new Fly());
    }
    
}
