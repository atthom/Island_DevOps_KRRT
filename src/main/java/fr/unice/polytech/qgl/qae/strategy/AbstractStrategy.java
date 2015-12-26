/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import org.json.JSONObject;

/**
 *
 * @author Thom
 */
public abstract class AbstractStrategy {

    AbstractPhase current_phase;

    public AbstractStrategy() {

    }

    public void setPhase(AbstractPhase current_phase) {
        this.current_phase = current_phase;
    }

    public void acknowledge(JSONObject s) {
        current_phase.acknowledge(s);
    }

    public AbstractAction execute() {
        current_phase = current_phase.getNext();
        return current_phase.execute();
    }

}
