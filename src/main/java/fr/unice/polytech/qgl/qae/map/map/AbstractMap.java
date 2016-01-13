package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import java.util.ArrayList;

/**
 * Created by user on 21/12/2015.
 */
public abstract class AbstractMap {

    protected final ArrayList<Coordinates> coordinates;
    Coordinates max;
    Coordinates min;

    public AbstractMap(ArrayList<Coordinates> coordinates) {
        max = new Coordinates(0, 0);
        min = new Coordinates(0, 0);
        this.coordinates = coordinates;
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

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public Coordinates preced(Coordinates c) {
        if (coordinates.get(0).equals(c)) {
            return null;
        }
        return coordinates.get(coordinates.indexOf(c) - 1);

    }

    public Coordinates succ(Coordinates c) {
        if (c.equals(getlastCoord())) {
            return null;
        }
        return coordinates.get(coordinates.indexOf(c) + 1);
    }

    public Coordinates getCoordinates(int i) {
        return coordinates.get(i);
    }

    public Coordinates getlastCoord(int i) {
        if (i == 0) {
            return getlastCoord();
        }
        if (i > 0) {
            return coordinates.get(coordinates.size() - i - 1);
        } else {
            return coordinates.get(coordinates.size() + i + 1);
        }
    }

    /**
     * Obtenir la dernière Coordonnée ajouté
     *
     * @return
     */
    public Coordinates getlastCoord() {
        return coordinates.get(coordinates.size() - 1);
    }

    public void printCoordinates() {
        coordinates.stream().forEach((coordinate) -> System.out.println("X : " + coordinate.getX() + " Y = " + coordinate.getY()));
    }

}
