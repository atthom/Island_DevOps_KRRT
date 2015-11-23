/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

/**
 * Classe coordonée 2D
 * @author user
 */
public class Coordinates {
    private int x,y;

    /**
     *
     * @param x
     * @param y
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }
    
    /**
     * Permet de calculer la distance manhatan entre deux coordonnées
     * @param a la seconde coordonnée
     * @return
     */
    public int distance(Coordinates a) {
        return Math.abs(a.x - this.x) + Math.abs(a.y - this.y);
    }
    
}
