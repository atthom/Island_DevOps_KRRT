/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.resources;

/**
 *
 * @author user
 */
public class UnextractedResource {
    private Amount a;
    private Condition cond;
    
    
    public UnextractedResource() {
        this.a = Amount.UNKNOWN_AMOUNT;
        this.cond = Condition.COND_UNKNOWN;
    }
    
    public UnextractedResource(Amount a, Condition cond) {
        this.a = a;
        this.cond = cond;
    }

    public Amount getA() {
        return a;
    }

    public Condition getCond() {
        return cond;
    }

    public void setA(Amount a) {
        this.a = a;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
    }
     
     
     
}
