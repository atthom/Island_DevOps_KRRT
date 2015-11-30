/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import java.util.Objects;

/**
 * Classe de vecteur en deux dimention pour representer les mouvements sur la
 * carte
 *
 * @author user
 */
public class Vect2D1 {

    private Vect1 v_x;
    private Vect1 v_y;

    /**
     * Construit un vecteur 2D avec deux vecteurs
     *
     * @param v1
     * @param v2
     *
     */
    public Vect2D1(Vect1 v1, Vect1 v2) {
        if (v1.colinear(v2)) {
            v1.add(v2);
            if (v1.is_xaxis()) {
                this.v_x = v1;
                this.v_y = new Vect1(0, Direction.S);
            } else {
                this.v_x = new Vect1(0, Direction.E);
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
    public Vect2D1(Vect1 v1) {
        if (v1.is_xaxis()) {
            v_x = v1;
            v_y = new Vect1(0, Direction.S);
        } else {
            v_x = new Vect1(0, Direction.E);
            v_y = v1;
        }
    }

    public Vect1 getV_x() {
        return v_x;
    }

    public Vect1 getV_y() {
        return v_y;
    }

    
    public Vect2D1(Coordinates c) {
        int x = c.getX();
        int y = c.getY();
        if(x < 0) {
            v_x = new Vect1(x*-1, Direction.W);
        }else {
            v_x = new Vect1(x, Direction.E);
        }
        
        if(y < 0) {
            v_y = new Vect1(y*-1, Direction.S);
        } else {
            v_y = new Vect1(y, Direction.N);
        }
        
    }
    
    
    
    public Vect2D1(Coordinates c, Coordinates c2) {
        int x1 = c2.getX() + c.getX();
        Direction d;
        if (x1 < 0) {
            x1 = x1 * -1;
            d = Direction.W;
        } else {
            d = Direction.E;
        }

        Vect1 v1 = new Vect1(x1, d);
        
        int y1 = c2.getY() + c.getY();
        Direction d2;
        if (y1 < 0) {
            y1 = y1 * -1;
            d2 = Direction.S;
        } else {
            d2 = Direction.N;
        }

        Vect1 v2 = new Vect1(y1, d2);

        this.v_x = v1;
        this.v_y = v2;
    }

    /**
     * Ajoute la valeur d'un vecteur 1 dimention dans le vecteur
     *
     * @param v1
     */
    public void add(Vect1 v1) {
        if (v1.is_xaxis()) {
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
    public boolean is_colinear(Vect2D1 v) {
        return (this.v_x.colinear(v.v_x) && this.v_y.equals(v.v_y))
                | (this.v_y.colinear(v.v_y) && this.v_x.equals(v.v_x));
    }

    /**
     * Ajoute un vecteur 2D
     *
     * @param v
     */
    public void add(Vect2D1 v) {
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
        final Vect2D1 other = (Vect2D1) obj;
        if (!Objects.equals(this.v_x, other.v_x)) {
            return false;
        }
        return Objects.equals(this.v_y, other.v_y);
    }




    
    
}
