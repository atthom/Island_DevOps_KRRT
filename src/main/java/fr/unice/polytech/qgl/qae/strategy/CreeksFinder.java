package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.PrettyTTOL;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.PrettyTTOR;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 05/12/15.
 */
public class CreeksFinder extends AbstractPhase {

    private boolean turnleft = false;

    public CreeksFinder(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);
    }

    @Override
    public AbstractPhase getNext() {
        if(next) {
            actions.add(new Stop());
        } else if(last_have_creek()) {
            return new ChooseCreek(parent,currents_coords,d,map);
        }
        return this;
    }

    @Override
    public AbstractAction execute() {
        if(actions.isEmpty()) {
            if (last_is_only_ocean()) {
                phase3a();
            }// else if (map.three_last_are_ground()) {            phase3b();        }
            else {
                manageComposedAction(new FlyAndScan(currents_coords, d));
            }
            if (already_here()) {
                next = true;
            }
        }
        return actions.get(0);
    }


    private void phase3a() {
        if (three_last_are_ocean()) {
            if (ten_last_are_ocean()) {
                next = true;
            } else {
                phase3b();
            }
        } else {
            manageComposedAction(new FlyAndScan(currents_coords, d));
        }
    }

    public boolean already_here() {
        return map.getFlyingmap().getCoordinates().stream().anyMatch((cc) -> (cc.equals(currents_coords)));
    }

    public boolean last_is_only_ocean() {
        FlyTile t = map.getLastFlyTile();
        return t.have_biome(BiomeType.OCEAN)  && t.nb_biomes()==1;
    }


    private void phase3b() {
        if (turnleft) {
            manageComposedAction(new PrettyTTOL(currents_coords, d));
            turnleft = false;
        } else {
            manageComposedAction(new PrettyTTOR(currents_coords, d));
            turnleft = true;
        }
    }

    public boolean last_have_creek() {
        FlyTile f =  map.getLastFlyTile();
        return f.havecreeks();
    }

    public boolean ten_last_are_ocean() {
        if (map.getFlyingmap().size() < 10 ) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (!map.getFlyTile(map.getFlyingmap().getlastCoord(i + 1)).have_only(BiomeType.OCEAN)) {
                return false;
            }
        }
        return true;
    }

    public boolean three_last_are_ocean() {

        FlyTile t1 = map.getLastFlyTile();
        FlyTile t2 = map.getFlyTile(map.getFlyingmap().getlastCoord(2));
        FlyTile t3 = map.getFlyTile(map.getFlyingmap().getlastCoord(3));
        return t1.have_biome(BiomeType.OCEAN)
                && t2.have_biome(BiomeType.OCEAN)
                && t3.have_biome(BiomeType.OCEAN);

    }

    public boolean three_last_are_ground() {

        FlyTile t1 = map.getLastFlyTile();
        FlyTile t2 = map.getFlyTile(map.getFlyingmap().getlastCoord(2));
        FlyTile t3 = map.getFlyTile(map.getFlyingmap().getlastCoord(3));

        return (!t1.have_biome(BiomeType.OCEAN)) && (!t2.have_biome(BiomeType.OCEAN)) && (!t3.have_biome(BiomeType.OCEAN));

    }

}

