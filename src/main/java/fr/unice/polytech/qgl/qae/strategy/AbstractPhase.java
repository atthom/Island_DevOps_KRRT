/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class AbstractPhase {
    Map map;
    Coordinates currents_coords;
    Direction d;
    ArrayList<AbstractAction> actions;
    ManageReply manager;

    public AbstractPhase(Map map, Coordinates currents_coords, Direction d) {
        this.map = map;
        this.currents_coords = currents_coords;
        this.d = d;
        
        manager = new ManageReply();
        actions = new ArrayList<>();
        
    }
    
    abstract ArrayList<AbstractAction> act();
    
    
    
    
    
    
}