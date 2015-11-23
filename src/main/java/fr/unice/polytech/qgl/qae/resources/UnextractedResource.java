/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.resources;

/**
 * Classe de ressouce non exploitée sur une case
 * @author user
 */
public class UnextractedResource {
    private Amount a;
    private Condition cond;
    
    /**
     * quantitée et condition d'exploitation non connue
     */
    public UnextractedResource() {
        this.a = Amount.UNKNOWN_AMOUNT;
        this.cond = Condition.COND_UNKNOWN;
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
     
     
     
}
