package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;

import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 05/12/15.
 */
public final class GoGround extends AbstractPhase {

    public GoGround(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);
        
        int dist = currents_coords.distance(getfirstground());
        manageComposedAction(new FlyUntil(dist, currents_coords, d));
    }

    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

    @Override
    public AbstractPhase getNext() {
        if (actions.isEmpty()) {
            return new CreeksFinder(parent, currents_coords, d, map);
        } else {
            return this;
        }
    }

    // TODO : retourner la case avec la distance minimal !
    public Coordinates getfirstground() {
//        for (Coordinates coordinate : map.getFlyingmap().getCoordinates()) {
//            FlyTile f = map.getFlyTile(coordinate);
//
//            if(f.equals(new FlyTile())) {
//                throw new Exception();
//            }
//            Type t = f.getT();
//            if (f.getT() == Type.GROUND) {
//                return coordinate;
//            }
//        }
//        return new Coordinates(0, 0);

        FlyTile f = map.getFlyingmap().getlastFlyTile();
        return map.getFlyingmap().getlastCoord();
    }

}
