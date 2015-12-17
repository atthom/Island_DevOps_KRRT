package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.Explorer;
import fr.unice.polytech.qgl.qae.actions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;

/**
 * Created by user on 05/12/15.
 */
public class Phase2 extends AbstractPhase {

    public Phase2(Explorer parent, Coordinates currents_coords, Direction d) {
        super(parent, currents_coords, d);
    }

    @Override
    void execute() {
        int dist = currents_coords.distance(map.getfirstground());
        manageComposedAction(new FlyUntil(dist, currents_coords, d));
        actions.add(new Stop());
    }

    @Override
    public AbstractAction act() {
        return actions.get(0);
    }

    
}

