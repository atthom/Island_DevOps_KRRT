package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

/**
 * Created by user on 05/12/15.
 */
public class GoGround extends AbstractPhase {

    public GoGround(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);

        int dist = currents_coords.distance(getfirstground());
        manageComposedAction(new FlyUntil(dist, currents_coords, d));
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty() && map.getFlyingmap().getMax().equals(new Coordinates(0, 0))) {
            if (map.getLastFlyTile().have_biome(BiomeType.OCEAN)) {
                actions.add(new Echo(d));
            } else if (map.getLastFlyTile().getT() == Type.OUT_OF_RANGE) {
                map.getFlyingmap().setMax(map.getFlyingmap().getlastCoord());
            } else {
                manageComposedAction(new FlyAndScan(currents_coords, d));
            }
        }
        return actions.get(0);
    }

    @Override
    public AbstractPhase getNext() {
        if (actions.isEmpty() && !map.getFlyingmap().getMax().equals(new Coordinates(0, 0))) {
            return new CreeksFinder(parent, currents_coords, d, map);
        } else {
            return this;
        }
    }

    // TODO : retourner la case avec la distance minimal !
    public Coordinates getfirstground() {
        return map.getFlyingmap().getlastCoord();
    }

}
