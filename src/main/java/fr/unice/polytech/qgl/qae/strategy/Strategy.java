/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.Direction;
import org.json.JSONObject;

/**
 * Classe de base des différentes stratégies de l'explorateur
 * aux différentes étapes du processus d'exploitation
 * @author user
 */
public abstract class Strategy {

    /**
     *
     */
    public Strategy() {

    }

    /**
     * Renvoie la "gauche" d'une direction donnée
     */
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

    /**
     * Renvoie la "droite" d'une direction donnée
     */
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

    /**
     *
     * @return execution d'une action de l'explorateur
     */
    public abstract String execute();

    /**
     *
     * @param s récupération de la réponse du moteur de jeu
     */
    public abstract void acknowledge(JSONObject s);

}
