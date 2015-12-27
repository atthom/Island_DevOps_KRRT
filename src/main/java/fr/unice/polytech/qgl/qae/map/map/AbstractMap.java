package fr.unice.polytech.qgl.qae.map.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import java.util.ArrayList;

/**
 * Created by user on 21/12/2015.
 */
public abstract class AbstractMap {
    protected final ArrayList<Coordinates> coordinates;

    public AbstractMap(ArrayList<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public Coordinates preced(Coordinates c) {
        if(coordinates.get(0).equals(c)) {
            return null;
        }
        return coordinates.get(coordinates.indexOf(c)-1);
    }

    public Coordinates succ(Coordinates c) {
        if(c.equals(getlastCoord())) {
            return null;
        }
        return coordinates.get(coordinates.indexOf(c)+1);
    }

    public Coordinates getCoordinates(int i) {
        return coordinates.get(i);
    }

    public Coordinates getlastCoord(int i) {
        if(i >0) {
            return coordinates.get(coordinates.size() - i -1);
        } else {
            return coordinates.get(coordinates.size() + i +1);
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

    /**
     *
     * @return
     */
    public Coordinates getMaxCord() {
        int max_x = -1;
        int max_y = -1;
        for (Coordinates coordinate : coordinates) {
            if (coordinate.getX() > max_x) {
                max_x = coordinate.getX();
            }
            if (coordinate.getY() > max_y) {
                max_y = coordinate.getY();
            }
        }

        return new Coordinates(max_x, max_y);
    }

    /**
     *
     * @return
     */
    public Coordinates getMinCord() {
        int min_x = 1000;
        int min_y = 1000;
        for (Coordinates coordinate : coordinates) {
            if (coordinate.getX() < min_x) {
                min_x = coordinate.getX();
            }
            if (coordinate.getY() < min_y) {
                min_y = coordinate.getY();
            }
        }
        return new Coordinates(min_x, min_y);
    }

}
