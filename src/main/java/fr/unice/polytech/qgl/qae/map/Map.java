/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.Direction;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.geometry.Vect2D;

import java.util.ArrayList;
import java.util.HashMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Classe Map permettant de stocker les informations sur les cases et les
 * organiser selon un repère en 2D
 *
 * @author user
 */
public class Map {

    private HashMap<Coordinates, Tile> map;
    private HashMap<Coordinates, FlyTile> flymap;
    private ArrayList<Coordinates> coordinates;
    private Coordinates [][] generateMap;
    /**
     *
     * @param origin case origine de l'explorer
     */
    public Map(Tile origin) {
        map = new HashMap<>();
        coordinates = new ArrayList<>();
        put(new Coordinates(0, 0), origin);
    }

    public void put(Coordinates c, Tile t) {
        map.putIfAbsent(c, t);
        coordinates.add(c);
    }

    /**
     * Converti un vecteur et le rentre dans le repère.
     *
     * @param v1 premier vecteur (int dist, direction d )
     * @param v2 second vecteur
     * @param t la case à ajouter à la map
     */
    public void add(Vect v1, Vect v2, Tile t) {
        map.put(convert(v1, v2), t);
    }

    /**
     * Idem avec un seul vecteur
     *
     * @param v1
     * @param t
     */
    public void add(Vect v1, Tile t) {
        put(convert(v1), t);
    }

    public Direction goaway(Coordinates current) {
        for (Coordinates coordinate : coordinates) {
            if (((FlyTile) map.get(coordinate)).getT() == Type.GROUND) {
                if (current.equals(coordinate)) {
                    throw new MapExeption("Coordonnées égales !");
                }

                Vect2D v = new Vect2D(current, coordinate);

                
                Vect v1 = v.getV_x();
                Vect v2 = v.getV_y();
                
                
                if (v1.getValeur() != 1) {
                    return v1.getD();
                } else {
                    return v2.getD();
                }

            }
        }

        throw new MapExeption("Coordonnées GROUND non trouvé !");

    }

    /**
     * Convertis un vecteur en Coordonnée
     *
     * @param v1 vecteur à convertir
     * @return
     */
    public Coordinates convert(Vect v1) {
        if (v1.is_xaxis()) {
            return new Coordinates(v1.getValeur(), 0);
        } else {
            return new Coordinates(0, v1.getValeur());
        }
    }

    /**
     * Obtenir la i eme coordonnée
     *
     * @return
     */
    public Coordinates get_coordinate(int i) {
        return coordinates.get(i);
    }

    public Coordinates get_lastcoordinate() {
        return coordinates.get(coordinates.size()-1);
    }

    public Tile getTile(Coordinates c) {
        return map.get(c);
    }

    /**
     * Convertit deux vecteur (non colinéaire) en coordonnée
     *
     * @param v1
     * @param v2
     * @return
     */
    public Coordinates convert(Vect v1, Vect v2) {
        if (v1.colinear(v2)) {
            return new Coordinates(0, 0);
        } else if (v1.is_xaxis()) {
            return new Coordinates(v1.getValeur(), v2.getValeur());
        } else {
            return new Coordinates(v2.getValeur(), v1.getValeur());
        }
    }

    /**
     * Renvoie la case si elle existe
     *
     * @param v1
     * @param v2
     * @return
     */
    public Tile getTile(Vect v1, Vect v2) {
        Coordinates coord = convert(v1, v2);

        for (Coordinates c : coordinates) {
            if (c.getX() == coord.getX() && c.getY() == coord.getY()) {
                return map.get(c);
            }
        }

        return map.get(new Coordinates(0, 0));
    }

    public void generate() {
        for(int i = 0; i<getMaxXCord(); i++) {
            for(int j = 0; j<getMaxYCord(); j++) {
                generateMap[i][j] = new Coordinates(i,j);
            }
        }
    }

    public boolean groundpath() {
        Coordinates last = coordinates.get(coordinates.size() - 1);
        Coordinates soon = coordinates.get(coordinates.size() - 2);

        return ((FlyTile) map.get(last)).getT()
                == Type.GROUND
                && Type.GROUND
                == ((FlyTile) map.get(soon)).getT();
    }

    public HashMap<Coordinates, Tile> getMap() {
        return map;
    }

    public int getMaxXCord() {
        int max = -1;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getX() > max) {
                max = coordinates.get(i).getX();
            }
        }
        return max;
    }

    public int getMinXCord() {
        int min = 1000;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getX() < min) {
                min = coordinates.get(i).getX();
            }
        }
        return min;
    }

    public int getMaxYCord() {
        int max = -1;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getY() > max) {
                max = coordinates.get(i).getY();
            }
        }
        return max;
    }

    public int getMinYCord() {
        int min = 1000;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getY() < min) {
                min = coordinates.get(i).getY();
            }
        }
        return min;
    }

    public Coordinates[][] getGenerateMap() {
        return generateMap;
    }

    // Combien de case disponible jusqu'a out of range a partir de notre coordonnée
    public int getMaxXCord(Coordinates c, Heading h) {
        return 0;
    }

//    public Tile getTile(int longeur, Direction d) {
//        for(Coordinates c : coordinates) {
//            if(c.getX()==longeur &c.getY() == largeur) {
//                return map.get(c);
//            }
//        }
//        
//        return map.get(new Coordinates(longeur, largeur));
//    }
    // public int getDistance(Tile t1, Tile t2) 
    // public ArrayList<Tile>> getPath(Tile t1, Tile t2) 
//    private ArrayList<ArrayList<Tile>> map;
//    
//    public Map(int longeur, int largeur, Tile origin) {
//        map = new ArrayList<>(largeur);
//        for(int i=0; i < largeur;i++){
//            ArrayList<Tile> t = new ArrayList<>(longeur);
//            for(int j=0; j < longeur;j++) {
//                t.add(new Tile());   
//            }
//            map.add(t);
//        }
//    }
}
