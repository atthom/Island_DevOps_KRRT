package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/12/2015.
 */
public class GroundMap extends AbstractMap {

    HashMap<Coordinates, GroundTile> map;

    public GroundMap() {
        super(new ArrayList<>());
        this.map = new HashMap<>();
    }
}
