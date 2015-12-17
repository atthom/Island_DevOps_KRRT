package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Explorer;
import fr.unice.polytech.qgl.qae.actions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 03/12/15.
 */
public class Phase1 extends AbstractPhase {

    Direction dir_to_echo = null;

    public Phase1(FStrategy parent, Coordinates currents_coords, Direction d) {
        super(parent, currents_coords, d);
        map = new Map(new FlyTile());
        actions.add(new Echo(d.left()));
        actions.add(new Echo(d.right()));
        actions.add(new Echo(d));
    }
    
    @Override
    public void next() {
        if(actions.isEmpty()) {
            setnext(new Phase2(parent, currents_coords, d));
        }
    }

    @Override
    public AbstractAction execute() {
//        if (next) {
//            if (actions.isEmpty()) {
//                setnext(new Phase2(parent, currents_coords, d));
//            }
//            return actions.get(0);
//
//        } else {
//            if (actions.isEmpty()) {
//                if (map.have_ground()) {
//                    // si pas dans la bonne direction
//                    if (dir_to_echo != null) {
//                        change_dir(dir_to_echo);
//                        next = true;
//                    } else {
//                        setnext(new Phase2(parent, currents_coords, d));
//                    }
//
//                    
//                } else {
//                    dir_to_echo = map.best_dir(d);
//                    manageComposedAction(new FlyAndEcho(currents_coords, d, dir_to_echo));
//                }
//
//            }
            return actions.get(0);

    }

}
