/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

/**
 *
 * @author user
 */
public class Parameter<T> {
    private String argument;
    private T valeur;

    public Parameter(String argument, T valeur) {
        this.argument = argument;
        this.valeur = valeur;
    }

    public String getArgument() {
        return argument;
    }

    public T getValeur() {
        return valeur;
    }
    
    
    
}
