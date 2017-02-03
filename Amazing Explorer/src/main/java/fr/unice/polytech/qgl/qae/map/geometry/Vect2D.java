/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;

import java.util.Objects;

/**
 * Classe de vecteur en deux dimention pour representer les mouvements sur la
 * carte
 *
 * @author user
 */
public class Vect2D {

    private Vect v_x;
    private Vect v_y;

        
    public Vect2D(Coordinates c) {
        int x = c.getX();
        int y = c.getY();
        
        if(x < 0) {
            v_x = new Vect(x*-1, Direction.W);
        } else {
            v_x = new Vect(x, Direction.E);
        }
        
        if(y < 0) {
            v_y = new Vect(y*-1, Direction.S);
        } else {
            v_y = new Vect(y, Direction.N);
        }
    }

    public Vect2D(Coordinates c, Coordinates c2) {
        int x1 = c2.getX() - c.getX();
        Direction d;
        if (x1 < 0) {
            x1 *= -1;
            d = Direction.W;
        } else {
            d = Direction.E;
        }

        Vect v1 = new Vect(x1, d);
        this.v_x = v1;
        
        int y1 = c2.getY() - c.getY();
        Direction d2;
        if (y1 < 0) {
            y1 *= -1;
            d2 = Direction.S;
        } else {
            d2 = Direction.N;
        }

        Vect v2 = new Vect(y1, d2);
        this.v_y = v2;
    }

    public Vect getV_x() {
        return v_x;
    }

    public Vect getV_y() {
        return v_y;
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
        if(this.equals(v)) {
            return true;
        } 
        if(this.toCoord().equals(new Coordinates(0, 0)) || v.toCoord().equals(new Coordinates(0, 0))) {
            return true;
        }
               
        if(this.v_y.getValeur() == 0 && 0 == v.v_y.getValeur() ) {
            return true;
        }
        
        float coeff1 = this.v_x.getValeur() / this.v_y.getValeur();
        float coeff2 = v.v_x.getValeur() / v.v_y.getValeur();
        return Float.compare(coeff1, coeff2)== 0;    
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
        final Vect2D other = (Vect2D) obj;
        if (!Objects.equals(this.v_x, other.v_x)) {
            return false;
        }
        return Objects.equals(this.v_y, other.v_y);
    }  

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 41 * hash + Objects.hashCode(this.v_x);
    hash = 41 * hash + Objects.hashCode(this.v_y);
    return hash;
  }
}
