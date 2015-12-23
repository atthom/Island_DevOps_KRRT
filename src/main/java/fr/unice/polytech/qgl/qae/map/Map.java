/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Classe Map permettant de stocker les informations sur les cases et les
 * organiser selon un repère en 2D
 *
 * @author user
 */
public class Map {

    private final LinkedHashMap<Coordinates, FlyTile> map;

    private final ArrayList<Coordinates> coordinates;

    /**
     * Contient une hashmap pour contenir toutes les cases de la map.
     *
     * @param origin case origine de l'explorer
     */
    public Map(FlyTile origin) {
        map = new LinkedHashMap<>();
        coordinates = new ArrayList<>();
        put(new Coordinates(0, 0), origin);
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

    public void printCoordinates() {
        coordinates.stream().forEach((coordinate) -> System.out.println("X : " + coordinate.getX() + " Y = " + coordinate.getY()));
    }

    public FlyTile getTile(Coordinates c) {
        return map.get(c);
    }

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public Coordinates getCoord(int n) {
        return coordinates.get(n);
    }

    public Coordinates getlastCoordinate(int i) {
        if (i > 0) {
            return coordinates.get(coordinates.size() - i);
        } else {
            return coordinates.get(coordinates.size() + i);
        }
    }

    public Coordinates getlastCoordinate() {
        return coordinates.get(coordinates.size() - 1);
    }

    public FlyTile getlastTile() {

        return map.get(getlastCoordinate());
    }

    /**
     * Obtenir la dernière Coordonnée ajouté
     *
     * @return
     */
    public Coordinates get_lastcoordinate() {
        return coordinates.get(coordinates.size() - 1);
    }

    public Coordinates get_coordinate(int i) {
        return coordinates.get(i);
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
        //TODO : Générer une exception  à la place de ça
        return map.get(new Coordinates(0, 0));
    }


    /**
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
