/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import java.util.ArrayList;

/**
 *
 * @author user
 *
 *
 */
public abstract class ComposedAction {
    ArrayList<AbstractAction> actions;
    Coordinates coords;
    Direction dir;

    /**
     * Action composé d'autres actions
     * @param c une coordonnée actuelle
     * @param d une direction
     */
    public ComposedAction(Coordinates c, Direction d) {
        actions = new ArrayList<>();
       this.coords = c;
       this.dir = d;
    }

    /**
     * 
     * @return les coordonées à la fin de l'action
     */
    public Coordinates getCoords() {
        return coords;
    }

    /**
     *
     * @return la direction à la fin de l'action
     */
    public Direction getDir() {
        return dir;
    }
    
    /**
     * Ajoute une action à la liste d'action
     * @param a
     */
    public void add(AbstractAction a) {
        actions.add(a);
    }
    
    /**
     * Ajoute une liste d'action à la liste des actions
     * @param actions
     */
    public void addAll(ArrayList<AbstractAction> actions) {
        this.actions.addAll(actions);
    }
    
    /**
     * Renvoie la liste des actions
     * @return
     */
    public ArrayList<AbstractAction> getAll() {
        return this.actions;
    }

    public void maj_coord(Coordinates c, Direction dir) {
        switch (dir) {
            case N:
                coords = new Coordinates(c.getX(), c.getY() +1 );
                break;
            case S:
                coords = new Coordinates(c.getX(), c.getY() -1 );
                break;
            case E:
                coords = new Coordinates(c.getX() +1, c.getY());
                break;
            default:
                coords = new Coordinates(c.getX() -1, c.getY());
                break;
        }
    }
}