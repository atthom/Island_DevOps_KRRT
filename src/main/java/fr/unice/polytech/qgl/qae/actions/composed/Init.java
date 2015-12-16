/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public class Init extends ComposedAction {

    public Init(Coordinates c, Direction d) {
        super(c, d);
        super.add(new Echo(d.left()));
        super.add(new Echo(d.right()));
        super.add(new Echo(d));
    }

}
