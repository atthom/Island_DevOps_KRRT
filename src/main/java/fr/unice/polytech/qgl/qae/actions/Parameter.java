/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

/**
 * Classe parametre permet de gérer facilement les actions avec parametres
 * @author user
 * @param <T>
 */
public class Parameter<T> {
    private String argument;
    private T valeur;

    /**
     *
     * @param argument : type de parametre
     * @param valeur : valeur du parametre
     */
    public Parameter(String argument, T valeur) {
        this.argument = argument;
        this.valeur = valeur;
    }

    /**
     *
     * @return argument
     */
    public String getArgument() {
        return argument;
    }

    /**
     *
     * @return valeur du parametre
     */
    public T getValeur() {
        return valeur;
    }
    
    
    
}
