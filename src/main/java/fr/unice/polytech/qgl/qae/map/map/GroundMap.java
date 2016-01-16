package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by user on 21/12/2015.
 */
public class GroundMap extends AbstractMap {

    HashMap<Coordinates, GroundTile> map;

    public GroundMap() {
        super();
        this.map = new LinkedHashMap<>();
    }

    /**
     * Ajoute une case dans la map si elle est absente
     *
     * @param c
     * @param t
     */
    public void put(Coordinates c, GroundTile t) {
        map.putIfAbsent(c, t);
    }

    public GroundTile getTile(Coordinates c) {
        return map.get(c);
    }

    public int size() {
        return map.size();
    }
    
    public void flush() {
        map.clear();
    }
}
