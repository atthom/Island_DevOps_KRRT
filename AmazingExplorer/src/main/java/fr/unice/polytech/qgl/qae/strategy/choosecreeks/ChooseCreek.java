package fr.unice.polytech.qgl.qae.strategy.choosecreeks;

import fr.unice.polytech.qgl.qae.strategy.ground.InitTerrestre;
import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.Land;

import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.GroundMap;

import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.FlyingPhase;

/**
 * Created by user on 20/12/2015.
 */
public class ChooseCreek  extends FlyingPhase {
 public GroundMap gm;
    
    public ChooseCreek(AbstractStrategy parent, Coordinates currents_coords, Direction d, FlyingMap m) {
        super(parent, currents_coords, d, m);
        gm = new GroundMap();
    }

    @Override
    public AbstractPhase getNext() {
        if(!last_have_creek()) {
            return this;
        } else {
            return new InitTerrestre(parent,currents_coords,map, gm);
        }
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty()) {
            if(last_have_creek()) {
                actions.add(new Land(getlast_creek(), 1));
            } else {
                actions.add(new Stop());
            }
        }
        return actions.get(0);
    }

    public String getlast_creek() {
        if(last_have_creek()) {
            FlyTile t =map.getLastTile().getValue();
            return t.getCreeks().get(0);
        } else {
            throw new MapExeption("add");
        }
    }

    public boolean last_have_creek() {
        FlyTile f =  map.getLastTile().getValue();
        return f.havecreeks();
    }


}
