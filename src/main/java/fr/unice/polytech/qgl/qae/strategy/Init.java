package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 03/12/15.
 */
public class Init extends AbstractPhase {

    Direction dir_to_echo = null;

    public Init(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d,m);
        actions.add(new Echo(d.left()));
        actions.add(new Echo(d.right()));
        actions.add(new Echo(d));
    }

    public AbstractPhase getNext() {
        if(actions.isEmpty() && next) {
            return new GoGround(parent, currents_coords, d, map);
        } else if(actions.isEmpty()) {
            try {
                execute();
                return this;
            } catch (Exception ex) {
                return new GoGround(parent, currents_coords, d, map);
            }
        } else {
            return this;
        }
    }


    @Override
    public AbstractAction execute() {
        if(actions.isEmpty()) {
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

        }


        return actions.get(0);
    }

}
