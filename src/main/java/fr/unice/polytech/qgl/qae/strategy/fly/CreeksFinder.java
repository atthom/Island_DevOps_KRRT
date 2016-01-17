package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.*;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Scan;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.FlyingPhase;
import fr.unice.polytech.qgl.qae.strategy.choosecreeks.ChooseCreek;

/**
 * Created by user on 05/12/15.
 */
public class CreeksFinder extends FlyingPhase {

    public boolean turnleft = false;

    public CreeksFinder(AbstractStrategy parent, Coordinates currents_coords, Direction d, FlyingMap m) {
        super(parent, currents_coords, d, m);
        Direction first = ((FlyingStrategy) parent).getFirst();
        if (first.right() == d) {
            turnleft = true;
        }
    }

    @Override
    public AbstractPhase getNext() {
        if (next) {
            actions.add(new Stop());
        } else if (last_have_creek()) {
            return new ChooseCreek(parent, currents_coords, d, map);
        }
        return this;
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty()) {
            if (last_is_only_ocean()) {
                phaseA();
            } else {
                manageComposedAction(new FlyAndScan(currents_coords, d));
            }
        }
        return actions.get(0);
    }

    public void phaseA() {
        manageBC();
        actions.add(new Scan());
        if (last_is_only_ocean()) {
            manageComposedAction(new FlyAndScan(currents_coords, d));
            manageComposedAction(new FlyAndScan(currents_coords, d));
            manageComposedAction(new FlyAndScan(currents_coords, d));
            manageComposedAction(new FlyAndScan(currents_coords, d));
        }
        if (two_last_is_only_ocean()) {
            next = true;
            actions.add(new Fly());
        }
    }

    public void manageBC() {
        Coordinates min = map.getMin();
        Coordinates max = map.getMax();
        int c_X = currents_coords.getX();
        int c_Y = currents_coords.getY();

        if (c_X + 3 < max.getX()
                && c_Y + 3 < max.getY()
                && c_X - 3 > min.getX()
                && c_Y - 3 > min.getY()) {
            phaseB();
        } else {
            phaseC();
        }
    }

    public void phaseB() {
        if (turnleft) {
            manageComposedAction(new PrettyTTOL(currents_coords, d));
            turnleft = false;
        } else {
            manageComposedAction(new PrettyTTOR(currents_coords, d));
            turnleft = true;
        }
    }
    

    public void phaseC() {
        if (turnleft) {
            manageComposedAction(new TurnToOppositeLeft(currents_coords, d));
            turnleft = false;
        } else {
            manageComposedAction(new TurnToOppositeRight(currents_coords, d));
            turnleft = true;
        }
    }

    public boolean last_is_only_ocean() {
        FlyTile t = map.getLastTile().getValue();
        return t.have_biome(BiomeType.OCEAN) && t.nb_biomes() == 1;
    }

    public boolean two_last_is_only_ocean() {
        if(map.size()<2) {
            return false;
        }
        FlyTile t =map.getLastTile().getValue();
        FlyTile tt = map.preced(map.getLastTile()).getValue();
        return t.have_biome(BiomeType.OCEAN) && t.nb_biomes() == 1
                && tt.have_biome(BiomeType.OCEAN) && tt.nb_biomes() == 1;
    }

    public boolean last_have_creek() {
        FlyTile f = map.getLastTile().getValue();
        return f.havecreeks();
    }

}
