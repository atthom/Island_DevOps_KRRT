package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

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

    public boolean Max_is_Not_set() {
        return (max.getX() == 0 || max.getY() == 0);
    }

    public void setMaxY(int max) {
        this.max.setY(max);
    }

    public void setMaxX(int max) {
        this.max.setX(max);
    }

}
