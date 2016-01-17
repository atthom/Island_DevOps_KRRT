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
    
    public Map.Entry<Coordinates, FlyTile> preced(FlyTile f) {
        Set<Map.Entry<Coordinates, FlyTile>> c = map.entrySet();
        Map.Entry<Coordinates, FlyTile> last = null;
        while(c.iterator().hasNext() && !f.equals(c.iterator().next().getValue())){
            last = c.iterator().next();
        }
        return last;
    }
    
    public Coordinates preced(Coordinates c) {
        Set<Coordinates> set = map.keySet();
        Coordinates last = null;
        while(set.iterator().hasNext() && !c.equals(set.iterator().next())){
            last = set.iterator().next();
        }
        return last;
    }
    
    public Coordinates get(int i) {
        Set<Coordinates> set = map.keySet();
        Coordinates last = null;
        while(set.iterator().hasNext() && i>0){
            last = set.iterator().next();
        }
        return last;
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
