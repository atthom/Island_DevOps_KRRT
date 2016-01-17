package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

import java.util.Random;

/**
 * Created by user on 26/12/15.
 */
public class MovePhase extends AbstractPhase {

    boolean find;
    boolean fN = false, fS = false, fE = false, fW = false;

    public MovePhase(AbstractStrategy theParentStrategy, Coordinates theCurrentCoordinates, Direction theDirection, Map theMap) {
        super(theParentStrategy, theCurrentCoordinates, theDirection,theMap);
        find = false;
        MoveTo mt = null;

        if(theParentStrategy.getMission().getBudget() < 50) {
            actions.add(new Stop());
        }

        for (int i = 0; i < theParentStrategy.getMission().getContracts().size(); i++) {

            for (Direction dir : Direction.values()) {
                GroundTile t = map.getGroundmap().getTile(theCurrentCoordinates.getClose(dir));

                // Si la case n'est pas scouter, on passe a la suivante
                if(t == null)
                    continue;

                for (int k = 0; k < t.getRessource().size(); k++) {
                        if(t.getRessource().get(k).getName().equals("FISH") && dir == Direction.N)
                            fN =true;
                        if(t.getRessource().get(k).getName().equals("FISH") && dir == Direction.S)
                            fS =true;
                        if(t.getRessource().get(k).getName().equals("FISH") && dir == Direction.E)
                            fE =true;
                        if(t.getRessource().get(k).getName().equals("FISH") && dir == Direction.W)
                            fW =true;
                    if (parent.getMission().getContracts().get(i).getResourceName().equals(t.getRessource().get(k).getName())) {
                        mt = new MoveTo(dir);
                        find = true;
                        break;
                    }
                }
                if (find)
                    break;
            }
            if (find)
                break;
        }



        if(!find) {
            if(!fN && !fE && !fS && !fW) {
                int r = new Random().nextInt(Direction.values().length);
                mt = new MoveTo(Direction.values()[r]);
            }
            else if(!fN)
                mt = new MoveTo(Direction.N);
            else if(!fS)
                mt = new MoveTo(Direction.S);
            else if(!fE)
                mt = new MoveTo(Direction.E);
            else if(!fW)
                mt = new MoveTo(Direction.W);
        }
        // Ajouter l'action et update les coordonnée
        mt.maj_coord(theCurrentCoordinates);
        actions.add(mt);
    }

    @Override
    public AbstractPhase getNext() {
        if(find)
            return new ExploitPhase(parent,currents_coords,d,map);
        else
            return new ScoutPhase(parent,currents_coords,d,map);
    }


    @Override
    public AbstractAction execute() {
        return actions.get(0);
    }

}
