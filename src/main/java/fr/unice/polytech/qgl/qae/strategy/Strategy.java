/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.Direction;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class Strategy {

    public Strategy() {

    }

    Direction gauche(Direction d) {
        switch (d) {
            case N:
                return Direction.W;
            case E:
                return Direction.N;
            case W:
                return Direction.S;
            default:
                return Direction.E; //pour Direction.S   
        }
    }

    Direction droite(Direction d) {
        switch (d) {
            case N:
                return Direction.E;
            case E:
                return Direction.S;
            case W:
                return Direction.N;
            default:
                return Direction.W; //pour Direction.S   
        }
    }

    public abstract String execute();

    public abstract void acknowledge(JSONObject s);

}
