package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/12/2015.
 */
public abstract class AbstractMap {

    Coordinates max;
    Coordinates min;

    public AbstractMap() {
        max = new Coordinates(0, 0);
        min = new Coordinates(0, 0);
    }

    public Coordinates getMin() {
        return min;
    }

    public void setMin(Coordinates min) {
        this.min = min;
    }

    public Coordinates getMax() {
        return max;
    }

    public void setMax(Coordinates max) {
        this.max = max;
    }
}
