/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;

/**
 * Classe de base des différentes stratégies de l'explorateur aux différentes
 * étapes du processus d'exploitation
 *
 * @author user
 */
public abstract class Strategy {

    /**
     *
     */
    public Strategy() {

    }

   

    protected void maj_pos(Coordinates c, Direction d) {
        switch (d) {
            case E:
                c.addX(1);
                break;
            case N:
                c.addY(1);
                break;
            case S:
                c.addY(-1);
                break;
            case W:
                c.addX(-1);
                break;
            default:
                break;
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
