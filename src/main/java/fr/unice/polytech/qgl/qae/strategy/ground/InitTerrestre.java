package fr.unice.polytech.qgl.qae.strategy.ground;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndScan;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.groundActions.composed.Glimpse360;
import fr.unice.polytech.qgl.qae.actions.groundActions.composed.MoveDiag;
import fr.unice.polytech.qgl.qae.actions.groundActions.composed.MoveUntil;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

import java.util.ArrayList;

/**
 * Created by user on 26/12/15.
 */
public class InitTerrestre extends AbstractPhase {

    //ArrayList<BiomeType> list;
    //Coordinates initialCord;

    public InitTerrestre(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {

        super(parent, currents_coords, d,m);
        //initialCord = new Coordinates(currents_coords.getX(),currents_coords.getY());
        //list = new ArrayList<>();
        manageComposedAction(new Glimpse360(currents_coords,3));

        //if(map.getLastGroundTile().getListe_biomes().get(0) == BiomeType.BEACH)
           // if(map.getGroundmap().getlastCoord().getX() == currents_coords.getX())
        //    manageComposedAction(new MoveDiag(currents_coords,Direction.N, Direction.E,3));

        /*
           for(int i =0; i<parent.getContracts().getContract().size(); i++) {

        }
        */
    }

    @Override
    public AbstractPhase getNext() {
        if(actions.isEmpty()) //  dans le if && (currents_coords.getX() != initialCord.getX() || currents_coords.getY() != initialCord.getY())
            return new ScoutPhase(parent,currents_coords,d,map);
        else
            return  this;
    }


    @Override
    public AbstractAction execute() {
        /*if(actions.isEmpty()) {
            list.add(map.getGroundmap().getTile(new Coordinates(currents_coords.getX(),currents_coords.getY()+3)).getListe_biomes().get(0));
            list.add(map.getGroundmap().getTile(new Coordinates(currents_coords.getX()+3,currents_coords.getY())).getListe_biomes().get(0));
            list.add(map.getGroundmap().getTile(new Coordinates(currents_coords.getX(),currents_coords.getY()-3)).getListe_biomes().get(0));
            list.add(map.getGroundmap().getTile(new Coordinates(currents_coords.getX()-3,currents_coords.getY())).getListe_biomes().get(0));

            if(list.size() == 4) {
                if (list.get(0) == BiomeType.BEACH && list.get(1) == BiomeType.BEACH)
                    manageComposedAction(new MoveDiag(currents_coords, Direction.N, Direction.E, 3));
                else if (list.get(0) == BiomeType.BEACH && list.get(3) == BiomeType.BEACH)
                    manageComposedAction(new MoveDiag(currents_coords, Direction.N, Direction.W, 3));
                else if (list.get(1) == BiomeType.BEACH && list.get(2) == BiomeType.BEACH)
                    manageComposedAction(new MoveDiag(currents_coords, Direction.S, Direction.E, 3));
                else if (list.get(2) == BiomeType.BEACH && list.get(3) == BiomeType.BEACH)
                    manageComposedAction(new MoveDiag(currents_coords, Direction.S, Direction.W, 3));
                else {
                    for(int i = 0; i<list.size(); i++) {
                        if (list.get(i) != BiomeType.OCEAN) {
                            switch (i) {
                                case 0:
                                    manageComposedAction(new MoveUntil(currents_coords, Direction.N, 3));
                                    break;
                                case 1:
                                    manageComposedAction(new MoveUntil(currents_coords, Direction.E, 3));
                                    break;
                                case 2:
                                    manageComposedAction(new MoveUntil(currents_coords, Direction.S, 3));
                                    break;
                                case 3:
                                    manageComposedAction(new MoveUntil(currents_coords, Direction.W, 3));
                                    break;
                            }
                        }
                    }
                }
            }

        }
       */
        return actions.get(0);
    }

}
