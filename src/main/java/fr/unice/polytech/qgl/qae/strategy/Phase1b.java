/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author Thom
 */
public class Phase1b extends AbstractPhase {

     Direction dir_to_echo = null;
    
    public Phase1b(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d);
        map =m;
    }
    
 

    @Override
    public void next() {
         if (actions.isEmpty() && !next) {
            execute();
        } else if(actions.isEmpty() && next) {
            setnext(new Phase2(parent, currents_coords, d, map));
        }    
    }

    @Override
    public AbstractAction execute() {
           if (map.have_ground()) {
                // si pas dans la bonne direction
                if (dir_to_echo != null) {
                    change_dir(dir_to_echo);
                }
                next = true;
            } else {
                dir_to_echo = map.best_dir(d);
                manageComposedAction(new FlyAndEcho(currents_coords, d, dir_to_echo));
            }
           
           return actions.get(0);
    }
    
}
