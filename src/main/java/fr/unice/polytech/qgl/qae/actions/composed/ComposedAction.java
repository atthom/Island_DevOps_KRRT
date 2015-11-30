/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ComposedAction {
    ArrayList<AbstractAction> actions;

    public ComposedAction() {
        actions = new ArrayList<>();
    }
    
    public void add(AbstractAction a) {
        actions.add(a);
    }
}