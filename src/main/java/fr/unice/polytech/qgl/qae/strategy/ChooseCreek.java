package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Land;

import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Created by user on 20/12/2015.
 */
public class ChooseCreek  extends AbstractPhase{

    public ChooseCreek(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
        super(parent, currents_coords, d, m);
    }

    @Override
    public AbstractPhase getNext() {
        return this;
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty()) {
            if(last_have_creek()) {
                actions.add(new Land(getlast_creek(), 1));
                actions.add(new Stop());
            } else {
                actions.add(new Stop());
            }
        }
        return actions.get(0);
    }

    public Creek getlast_creek() {
        if(last_have_creek()) {
            FlyTile t =map.getLastFlyTile();
            return t.getCreeks().get(0);
        } else {
            throw new MapExeption("add");
        }
    }

    public boolean last_have_creek() {
        FlyTile f =  map.getLastFlyTile();
        return f.havecreeks();
    }


}
