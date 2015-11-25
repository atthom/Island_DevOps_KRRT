/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.resources;

import java.util.Objects;

/**
 * Ressource exploitée ou objectif de ressource à exploiter
 * @author user
 */
public class ExtractedResource {

    private int nb;
    private String name;

    /**
     * 
     * @param nb quantitée de ressource
     * @param name nom de la ressource
     */
    public ExtractedResource(int nb, String name) {
        this.nb = nb;
        this.name = name;
    }

    /**
     *
     * @return la quantiée de ressource
     */
    public int getNb() {
        return nb;
    }

    /**
     *
     * @param nb retire nb quantitée de la ressource
     * TODO : throw exeption si enelve plus que possible
     */
    public void enleve(int nb) {
        if (this.nb >= nb) {
            this.nb = this.nb - nb;
        } else {
            this.nb = 0;
        }
    }

    @Override
    public String toString() {
        return "Ressource{" + "nb=" + nb + ", name=" + name + '}';
    }

    /**
     *
     * @return le nom de la ressource
     */
    public String getName() {
        return name;
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
        final ExtractedResource other = (ExtractedResource) obj;
        if (this.nb != other.nb) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    

}
