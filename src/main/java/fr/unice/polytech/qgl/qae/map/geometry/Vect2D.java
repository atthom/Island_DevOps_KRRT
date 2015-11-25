/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.exceptions.VectorExeption;

/**
 * Classe de vecteur en deux dimention pour representer les mouvements sur la carte
 * @author user
 */
public class Vect2D {
    private Vect v_x;
    private Vect v_y;

    /**
     *deux vecteurs non colinéaires
     * @param v1 
     * @param v2
     * @throws VectorExeption
     */
    public Vect2D(Vect v1, Vect v2) throws VectorExeption {
        if(v1.colinear(v2)) {
           throw new VectorExeption("Les deux vecteurs sont colinéaire, construction impossible");
        }
        if(v1.is_xaxis()) {
            this.v_x = v1;
            this.v_y = v2;
        } else {
             this.v_x = v2;
             this.v_y = v1;
        }
       
    }
    
    /**
     * Ajoute la valeur d'un vecteur 1 dimention dans le vecteur
     * @param v1
     */
    public void add(Vect v1)  {
        if(v1.is_xaxis()) {
            v_x.add(v1);
        } else {
            v_y.add(v1);
        }
    }
    
    /**
     * Calcule la distance du vecteur au point d'origine
     * @return
     */
    public int getDistance() {
        return Math.abs(v_x.getValeur()) + Math.abs(v_y.getValeur());
    }
    
    /**
     * Permet de savoir si un vecteur 2D est colinéaire avec un autre vecteur 2D
     * @param v
     * @return
     */
    public boolean is_colinear(Vect2D v) {
        return (this.v_x.colinear(v.v_x) && this.v_y.equals(v.v_y)) 
                | (this.v_y.colinear(v.v_y) && this.v_x.equals(v.v_x));
    }
    
    /**
     * Ajoute un vecteur 2D
     * @param v
     */
    public void add(Vect2D v) {
       this.v_x.add(v.v_x);
       this.v_y.add(v.v_y);
    }
    
}
