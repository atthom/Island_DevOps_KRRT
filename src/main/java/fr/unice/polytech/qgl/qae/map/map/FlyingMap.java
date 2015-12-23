package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by user on 21/12/2015.
 */
public class FlyingMap extends  AbstractMap {

    HashMap<Coordinates, FlyTile> map;

    public FlyingMap() {
        super(new ArrayList<>());
        this.map = new HashMap<>();
        put(new Coordinates(0,0), new FlyTile());
    }

    /**
     * Renvoie la case si elle existe
     *
     * @param c2
     * @return
     */

    public FlyTile getFlyTile(Coordinates c2) {

        for (Coordinates c : coordinates) {
            if (c.equals(c2)) {
                return map.get(c);
            }
        }

        //TODO : Générer une exception à la place de ça
        return null;
    }

    /**
     * Met à jour une case déja explorée
     *
     * @param c
     * @param t
     */
    public void maj(Coordinates c, FlyTile t) {
        coordinates.stream().filter((cc) -> (cc.equals(c))).forEach((cc) -> map.replace(cc, t));
        put(c, t);
    }

    /**
     * Ajoute une case dans la map si elle est absente
     *
     * @param c
     * @param t
     */
    public final void put(Coordinates c, FlyTile t) {
        map.putIfAbsent(c, t);
        coordinates.add(c);
    }

    public FlyTile getlastFlyTile() {
        return map.get(coordinates.get(coordinates.size()-1));

    }



}
