/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.resources;

import java.util.Objects;

/**
 * Classe de ressouce non exploitée sur une case
 * @author user
 */
public class UnextractedResource {
    private Amount a;
    private Condition cond;
    private String name;
    
    /**
     * quantitée et condition d'exploitation non connue
     */
    public UnextractedResource(String s) {
        this.a = Amount.UNKNOWN_AMOUNT;
        this.cond = Condition.COND_UNKNOWN;
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
     *
     * @param a quantitée
     * @param cond condition d'exploitation
     */
    public UnextractedResource(Amount a, Condition cond) {
        this.a = a;
        this.cond = cond;
    }

    /**
     *
     * @return la quantitée de ressource
     */
    public Amount getA() {
        return a;
    }

    /**
     *
     * @return la condition de ressource
     */
    public Condition getCond() {
        return cond;
    }

    /**
     *
     * @param a met à jour la quantitée
     */
    public void setA(Amount a) {
        this.a = a;
    }

    /**
     *
     * @param cond met à jour la condition d'extraction
     */
    public void setCond(Condition cond) {
        this.cond = cond;
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
        final UnextractedResource other = (UnextractedResource) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.a != other.a) {
            return false;
        }
        return this.cond == other.cond;
    }
     
     
     
}
