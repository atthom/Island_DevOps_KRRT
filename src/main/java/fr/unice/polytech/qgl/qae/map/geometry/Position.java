/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.geometry;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;

/**
 *
 * @author user
 */
public class Position {
    Coordinates c;
    Direction d;

    public Position(Coordinates c, Direction d) {
        this.c = c;
        this.d = d;
    }

    public Coordinates getC() {
        return c;
    }

    public Direction getD() {
        return d;
    }
    
}
