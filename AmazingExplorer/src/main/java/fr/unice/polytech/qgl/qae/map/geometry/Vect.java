/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Heading;
import java.util.Objects;

/**
 * Classe de vecteur qui facilite le passage entre les coordonnée de la map et
 * la position relative de l'explorateur
 *
 * @author user
 */
public class Vect {

    private int valeur;
    private Direction d;

    /**
     * Un vecteur avec une norme et une direction
     *
     * @param valeur
     * @param d
     */
    public Vect(int valeur, Direction d) {
        this.valeur = Math.abs(valeur);
        this.d = d;
    }

    /**
     *
     * @param valeur
     * @param h
     */
    public Vect(int valeur, Heading h) {
        this.valeur = valeur;
        this.d = h.getValueParameter();
    }

    /**
     *
     * @return la norme du vecteur en fonction de sa direction
     */
    public int getValeur() {
        if (d.equals(Direction.W) || d.equals(Direction.S)) {
            return -valeur;
        } else {
            return valeur;
        }
    }

    /**
     *
     * @return true si le vecteur represente l'axe des ordonnées
     */
    public boolean is_xaxis() {
        return d.equals(Direction.W) || d.equals(Direction.E);
    }

    /**
     *
     * @return la direction du vecteur
     */
    public Direction getD() {
        return d;
    }

    /**
     *
     * @param v un autre vecteur
     * @return true si les deux vecteurs sont colinéaire
     */
    public boolean colinear(Vect v) {
        return d.is_aligned(v.d);
    }
    
    public Coordinates toCoord() {
        if(this.is_xaxis()) {
            return new Coordinates(this.getValeur(), 0);
        } else {
            return new Coordinates(0, this.getValeur());
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
        final Vect other = (Vect) obj;
        if (this.valeur != other.valeur) {
            return false;
        }
        return this.d == other.d;
    }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 71 * hash + this.valeur;
    hash = 71 * hash + Objects.hashCode(this.d);
    return hash;
  }
    
    
}
