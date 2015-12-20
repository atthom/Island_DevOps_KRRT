/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

/**
 * Classe coordonée 2D
 *
 * @author user
 */
public class Coordinates {

    private int x, y;

    /**
     *
     * @param x
     * @param y
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Coordinates c) {
        addX(c.x);
        addY(c.y);
    }

    public Coordinates coords_between(Coordinates c) {
        return new Coordinates(c.x - this.x, c.y - this.y);
    }

    public Vect2D vectorize() {
        return new Vect2D(this);
    }

    public void addX(int x) {
        this.x = this.x + x;
    }

    public void addY(int y) {
        this.y = this.y + y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }


    public void setX(int value) {
        this.x = value;
    }

    public void setY(int value) {
        this.y = value;
    }

    public int getY() {
        return y;
    }

    /**
     * Permet de calculer la distance manhatan entre deux coordonnées
     *
     * @param a la seconde coordonnée
     * @return
     */
    public int distance(Coordinates a) {
        return Math.abs(a.x - this.x) + Math.abs(a.y - this.y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int distance() {
        return Math.abs(this.x) + Math.abs(this.y);
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
        final Coordinates other = (Coordinates) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }
    
    

}
