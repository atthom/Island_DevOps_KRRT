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
 */
public abstract class ComposedAction {
    ArrayList<AbstractAction> actions;
    Coordinates coords;
    Direction dir;

    public ComposedAction(Coordinates c, Direction d) {
        actions = new ArrayList<>();
       this.coords = c;
       this.dir = d;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public Direction getDir() {
        return dir;
    }
    
    public void add(AbstractAction a) {
        actions.add(a);
    }
    
    public void addAll(ArrayList<AbstractAction> actions) {
        this.actions.addAll(actions);
    }
    
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