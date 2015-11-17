/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae;

import fr.unice.polytech.qgl.qae.resources.ExtractedResource;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author user
 */
public class Objectif {

    private final int nb_mens;
    private int budget;
    private ArrayList<ExtractedResource> contract;

    public Objectif(int nb_mens, int budget, ArrayList<ExtractedResource> contract) {
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

    @Override
    public String toString() {
        return "Objectif{" + "nb_mens=" + nb_mens + ", budget=" + budget + ", contract=" + contract + '}';
    }

    public ExtractedResource getRessource(String name) {
        for (ExtractedResource res : this.contract) {
            if (res.getName().equals(name)) {
                return res;
            }
        }
      
        return new ExtractedResource(0, "");
    }

    public void enleve_ressource(ExtractedResource r) {
       for(ExtractedResource res : this.contract) {
            if (res.getNb() > r.getNb()) {
                res.enleve(r.getNb());
            } else {
                this.contract.remove(res);
            }
        }
    }

    public void enleve_PA(int budget) {
        if (budget < this.budget) {
            this.budget = this.budget - budget;
        }

    }

}
