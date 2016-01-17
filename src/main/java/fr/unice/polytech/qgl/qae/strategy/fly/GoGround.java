package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyUntil;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.biomes.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.FlyingPhase;

/**
 * Created by user on 05/12/15.
 */
public class GoGround extends FlyingPhase {

    public GoGround(AbstractStrategy parent, Coordinates currents_coords, Direction d, FlyingMap m) {
        super(parent, currents_coords, d, m);

        // TODO : retourner la case avec la distance minimal !
        int dist = currents_coords.distance(map.getLastTile().getKey());
        manageComposedAction(new FlyUntil(dist, currents_coords, d));
    }

    @Override
    public AbstractAction execute() {

        if (actions.isEmpty() && map.Max_is_Not_set()) {
            FlyTile ft = map.getLastTile().getValue();
            if (ft.have_biome(BiomeType.OCEAN)) {
                actions.add(new Echo(d));
            } else if (ft.getT() == Type.OUT_OF_RANGE) {
                map.setMaxY(map.getLastTile().getKey().getY());
                actions.add(new Fly());
            } else {
                manageComposedAction(new FlyAndScan(currents_coords, d));
            }
        }
        return actions.get(0);
    }

    @Override
    public AbstractPhase getNext() {
        if (actions.isEmpty() && !map.Max_is_Not_set()) {
            return new CreeksFinder(parent, currents_coords, d, map);
        } else {
            return this;
        }
    }

    
    

}
