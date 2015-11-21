/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;

/**
 *
 * @author user
 */
public class Vect {

    private int valeur;
    private Direction d;

    public Vect(int valeur, Direction d) {
        this.valeur = valeur;
        this.d = d;
    }

    public Vect(int valeur, Heading h) {
        this.valeur = valeur;
        this.d = h.getValueParameter();
    }

    public int getValeur() {
        if (d.equals(Direction.W) | d.equals(Direction.S)) {
            return -valeur;
        } else {
            return valeur;
        }
    }
    
    public boolean is_xaxis() {
        return d.equals(Direction.W)|d.equals(Direction.E);
    }

    public Direction getD() {
        return d;
    }
    
   

    public boolean issimilare(Vect v) {
        return d.is_sameoropposite(v.d);
    }
}
