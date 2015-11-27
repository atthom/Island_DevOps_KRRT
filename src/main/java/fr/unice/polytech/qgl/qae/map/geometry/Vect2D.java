/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.Direction;

/**
 * Classe de vecteur en deux dimention pour representer les mouvements sur la
 * carte
 *
 * @author user
 */
public class Vect2D {

    private Vect v_x;
    private Vect v_y;

    /**
     * Construit un vecteur 2D avec deux vecteurs
     *
     * @param v1
     * @param v2
     *
     */
    public Vect2D(Vect v1, Vect v2) {
        if (v1.colinear(v2)) {
            v1.add(v2);
            if (v1.is_xaxis()) {
                this.v_x = v1;
                this.v_y = new Vect(0, Direction.S);
            } else {
                this.v_x = new Vect(0, Direction.E);
                this.v_y = v1;
            }
        } else if (v1.is_xaxis()) {
            this.v_x = v1;
            this.v_y = v2;
        } else {
            this.v_x = v2;
            this.v_y = v1;
        }

    }

    /**
     * Construit un vecteur2D avec un vecteur1D
     *
     * @param v1
     */
    public Vect2D(Vect v1) {
        if (v1.is_xaxis()) {
            v_x = v1;
            v_y = new Vect(0, Direction.S);
        } else {
            v_x = new Vect(0, Direction.E);
            v_y = v1;
        }
    }

    /**
     * Ajoute la valeur d'un vecteur 1 dimention dans le vecteur
     *
     * @param v1
     */
    public void add(Vect v1) {
        if(v_x.is_xaxis()) {
            v_x.add(v1);
        } else {
            v_y.add(v1);
        }
       
    }

    /**
     * Calcule la distance du vecteur au point d'origine
     *
     * @return
     */
    public int getDistance() {
        return Math.abs(v_x.getValeur()) + Math.abs(v_y.getValeur());
    }

    /**
     * Permet de savoir si un vecteur 2D est colinéaire avec un autre vecteur 2D
     *
     * @param v
     * @return
     */
    public boolean is_colinear(Vect2D v) {
        return (this.v_x.colinear(v.v_x) && this.v_y.equals(v.v_y))
                | (this.v_y.colinear(v.v_y) && this.v_x.equals(v.v_x));
    }

    /**
     * Ajoute un vecteur 2D
     *
     * @param v
     */
    public void add(Vect2D v) {
        add(v.v_x);
        add(v.v_y);
    }

    /**
     *
     * @return la valeur en coordonnée du vecteur 2D
     */
    public Coordinates toCoord() {
        return new Coordinates(v_x.getValeur(), v_y.getValeur());
    }

}
