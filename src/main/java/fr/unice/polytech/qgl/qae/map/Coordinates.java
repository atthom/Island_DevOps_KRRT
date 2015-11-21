/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.Direction;

/**
 *
 * @author user
 */
public class Coordinates {
    private int x,y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    public int distance(Coordinates a) {
        // distance de manhatan
        return Math.abs(a.x - this.x) + Math.abs(a.y - this.y);
    }
    
}
