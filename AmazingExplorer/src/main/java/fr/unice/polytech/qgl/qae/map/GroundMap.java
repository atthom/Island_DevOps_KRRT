package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
     * @param c
     * @param t
     */
    public void put(Coordinates c, GroundTile t) {
        map.putIfAbsent(c, t);
    }

    public GroundTile getTile(Coordinates c) {
        return map.get(c);
    }
    
    public Map.Entry<Coordinates, GroundTile> getFirstTile() {
        return  map.entrySet().iterator().next();
    }

    public Map.Entry<Coordinates, GroundTile> getLastTile() {
        return (Map.Entry<Coordinates, GroundTile>) map.entrySet().toArray()[map.size()-1];
    }

    public int size() {
        return map.size();
    }
    
    public void flush() {
        map.clear();
    }
}
