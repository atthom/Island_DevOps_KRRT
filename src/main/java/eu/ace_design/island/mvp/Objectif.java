/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Objectif {
    private final int nb_mens;
    private int budget;
    private ArrayList<Ressource> contract;

    public Objectif(int nb_mens, int budget, ArrayList<Ressource> contract) {
        this.nb_mens = nb_mens;
        this.budget = budget;
        this.contract = contract;
    }

    public int getNb_mens() {
        return nb_mens;
    }

    public int getBudget() {
        return budget;
    }
    
    public Ressource getRessource(String name) {
         for(Ressource res : this.contract) {
             if(res.getName().equals(name)) {
                return res;
             }
         }
        return new Ressource(0, "");
    }
    
    public void enleve_ressource(Ressource r) {
        for(Ressource res : this.contract) {
            if(res.getName().equals(r.getName())) {
                if(res.getNb() > r.getNb()) {
                      res.enleve(r.getNb());
                } else {
                    this.contract.remove(res);
                }
            }
        }
     }
    
    public void enleve_PA(int budget) {
        if(budget  < this.budget) {
             this.budget = this.budget - budget;
        }
       
    }
    
    
    
}
