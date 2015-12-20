/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.flyActions.withparams;

/**
 *
 * @author user
 */
public enum Direction {
    E,
    W,
    S,
    N;

    /**
     *
     * @return la direction opposée
     */
    public Direction opposite() {
        switch (this) {
            case E:
                return W;
            case W:
                return E;
            case S:
                return N;
            default:
                return S;
        }
    }

    /**
     * Renvoie la "gauche" d'une direction donnée
     * @return 
     */
    public Direction left() {
        switch (this) {
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

    /**
     * Renvoie la "droite" d'une direction donnée
     * @return 
     */
    public Direction right() {
        switch (this) {
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

    /**
     *
     * @param d une direction
     * @return si la direction est alignée ou opposé.
     */
    public boolean is_aligned(Direction d) {
        return this == d || d.opposite() == this;
    }
    
    public boolean is_minus() {
        return this == S || this == W;
    }
}
