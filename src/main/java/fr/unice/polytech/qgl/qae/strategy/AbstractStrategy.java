/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Objectif;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class AbstractStrategy {
    ArrayList<AbstractPhase> phases;
    Objectif o;
    

    public AbstractStrategy(Objectif o) {
        this.o = o;
        phases = new ArrayList<>();
    }
  
    public abstract String execute();
    
}
