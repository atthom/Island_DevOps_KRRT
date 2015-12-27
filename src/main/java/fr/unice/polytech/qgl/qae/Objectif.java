/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae;

import fr.unice.polytech.qgl.qae.resources.PrimaryResource;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Objectif {

    private final int nb_mens;
    private int budget;
    private ArrayList<PrimaryResource> contract;

    /**
     * Créer un objectif pour l'expedition
     * @param nb_mens nombre d'homme d'équipage
     * @param budget cout total maximal de l'expedition
     * @param contract liste de ressource extraire à valider.
     * A chaque ressources extraite on enleve une partie dans l'objectif
     */
    public Objectif(int nb_mens, int budget, ArrayList<PrimaryResource> contract) {
        this.nb_mens = nb_mens;
        this.budget = budget;
        this.contract = contract;
    }

    /**
     *
     * @return le nombre d'homme d'équipage
     */
    public int getNb_mens() {
        return nb_mens;
    }

    /**
     *
     * @return le buget restant pour l'expédition
     */
    public int getBudget() {
        return budget;
    }

    /**
     *
     * @return the contract
     */
    public ArrayList<PrimaryResource> getContract(){ return contract;}

    @Override
    public String toString() {
        return "Objectif{" + "nb_mens=" + nb_mens + ", budget=" + budget + ", contract=" + contract + '}';
    }

    /**
     * Permet de chercher une ressource à extraire dans la liste de l'objectif
     * @param name : nom de la ressource cherchée
     * @return la ressource cherchée si trouvée sinon la ressource (0, "")
     */
    public PrimaryResource getRessource(String name) {
        for (PrimaryResource res : this.contract) {
            if (res.getName().equals(name)) {
                return res;
            }
        }
        return new PrimaryResource();
    }

    /**
     * Permet de mettre à jour l'objectif
     * lorsque l'on a extrait une ressource à exploiter
     * Si le nombre de ressource est inférieur à l'objectif
     * On met à jour le nombre restant de ressource à extraire
     * Si il est plus grand on supprime la ressource de la liste de l'objectif
     * @param r ressource à extraire.
     */
    public void enleve_ressource(PrimaryResource r) {
        for(PrimaryResource res : contract) {
            if (res.getNbExploitedRessource() > r.getNbExploitedRessource()) {
                res.retrieve(r.getNbExploitedRessource());
            } else {
                this.contract.remove(res);
            }
        }
    }

    /**
     * Permet d'actualiser le budget après chaque action
     * @param budget cout d'une opération effectuée
     */
    public void enleve_PA(int budget) {
        if (budget < this.budget) {
            this.budget = this.budget - budget;
        }
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
        final Objectif other = (Objectif) obj;
        if (this.nb_mens != other.nb_mens) {
            return false;
        }
        if (this.budget != other.budget) {
            return false;
        }
        if (!Objects.equals(this.contract, other.contract)) {
            return false;
        }
        return true;
    }
    
    

}
