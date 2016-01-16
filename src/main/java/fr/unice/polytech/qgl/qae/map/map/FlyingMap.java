package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by user on 21/12/2015.
 */
public class FlyingMap extends AbstractMap {
    HashMap<Coordinates, FlyTile> map;
    
    public FlyingMap() {
        super();
        this.map = new LinkedHashMap<>();
        put(new Coordinates(0, 0), new FlyTile());
    }

    public int size() {
        return map.size();
    }

    /**
     * Renvoie la case si elle existe
     *
     * @param c2
     * @return
     */
    public FlyTile getTile(Coordinates c2) {
        //TODO : Générer une exception à la place de ça
        return  map.get(c2);
    }

    /**
     * Met à jour une case déja explorée
     *
     * @param c
     * @param t
     */
    public void maj(Coordinates c, FlyTile t) {
        if(map.replace(c,t)==null) {
            map.put(c, t);
        }
    }

    /**
     * Ajoute une case dans la map si elle est absente
     *
     * @param c
     * @param t
     */
    public final void put(Coordinates c, FlyTile t) {
        map.putIfAbsent(c, t);
    }
    
    public FlyTile getFirstTile() {
        return  map.entrySet().iterator().next().getValue();
    }

    public FlyTile getLastTile() {
        Set<Coordinates> c = map.keySet();
        Coordinates last = new Coordinates(0, 0);
        while(c.iterator().hasNext()) {
            last = c.iterator().next();
        }

        return map.get(last);
    }

    @Override
    public String toString() {
        return "FlyingMap{" + "map=" + map + '}';
    }
    
    public void flush() {
        map.clear();
    }
}
