/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public class ChangeDirection extends ComposedAction {

    public ChangeDirection(Direction current_dir, Coordinates coords, Direction dir) {
        super(coords, current_dir);
        
        if (current_dir.equals(dir)) {

        } else if (current_dir.opposite().equals(dir)) {
            super.add(new Heading(current_dir.left()));
            super.add(new Heading(current_dir.left().left()));
        } else if (current_dir.right().equals(dir)) {
            super.add(new Heading(current_dir.right()));
        } else {
            super.add(new Heading(current_dir.left()));
        }

    }

}
