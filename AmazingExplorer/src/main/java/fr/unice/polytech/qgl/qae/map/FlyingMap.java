package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 21/12/2015.
 */
public class FlyingMap extends AbstractMap {
    LinkedHashMap<Coordinates, FlyTile> map;
    
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
     * @param c2
     * @return
     */
    public FlyTile getTile(Coordinates c2) {
        //TODO : Générer une exception à la place de ça
        return  map.get(c2);
    }

    /**
     * Met à jour une case déja explorée
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
     * @param c
     * @param t
     */
    public final void put(Coordinates c, FlyTile t) {
        map.putIfAbsent(c, t);
    }
    
    public Map.Entry<Coordinates, FlyTile> getFirstTile() {
        return  map.entrySet().iterator().next();
    }

    public Map.Entry<Coordinates, FlyTile> getLastTile() {
        return (Map.Entry<Coordinates, FlyTile>) map.entrySet().toArray()[map.size()-1];
    }

    public Coordinates get(int i) {
        return (i<0 || i> map.size()) ? null : (Coordinates) map.keySet().toArray()[i];
    }

    public Map.Entry<Coordinates, FlyTile> preced(Map.Entry<Coordinates, FlyTile> f) {
        Iterator<Map.Entry<Coordinates, FlyTile>> it = map.entrySet().iterator();
        Map.Entry<Coordinates, FlyTile> pre = null;
        while (it.hasNext() && !it.next().equals(f)) {
             pre = it.next(); 
        }
        return pre;
    }
    
    public Coordinates preced(Coordinates c) {
        Iterator<Coordinates> it = map.keySet().iterator();
        Coordinates pre = null;
        while (it.hasNext() && !it.next().equals(c)) {
             pre = it.next(); 
        }
        return pre;
    }
    
    @Override
    public String toString() {
        return "FlyingMap{" + "map=" + map + '}';
    }

    public HashMap<Coordinates, FlyTile> getMap() {
        return map;
    }

    public void flush() {
        map.clear();
    }
}
