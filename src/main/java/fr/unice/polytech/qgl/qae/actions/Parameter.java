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
public class Parameter {
    private String argument;
    private String valeur;

    public Parameter(String argument, String valeur) {
        this.argument = argument;
        this.valeur = valeur;
    }

    public String getArgument() {
        return argument;
    }

    public String getValeur() {
        return valeur;
    }
    
}
