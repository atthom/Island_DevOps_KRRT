/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
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

    private ArrayList<Coordinates> coordinates;

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

    public void printCoordinates() {
        coordinates.stream().forEach((coordinate) -> {
            System.out.println("X : " + coordinate.getX() + " Y = " + coordinate.getY());
        });

    }

    public Direction go_ground(Coordinates current) {
        for (Coordinates coordinate : coordinates) {
            if (((FlyTile) map.get(coordinate)).getT() == Type.GROUND) {
                if (current.equals(coordinate)) {
                    throw new MapExeption("Coordonnées égales !");
                }

//                if(current.vectorize().is_colinear(coordinate.vectorize()) && current.vectorize())  {
//                    // si les deux vecteurs sont sur la même ligne 
//                }
                
                
                Vect2D v = new Vect2D(current, coordinate);
                
                
                Vect v1 = v.getV_x();
                Vect v2 = v.getV_y();
                System.out.println("X : "+ v1.getValeur() + " Y : " +  v2.getValeur());
                System.out.println("Dx : "+ v1.getD() + " Y : " +  v2.getD());
                
                if (v1.getValeur() > 1) {
                    return v1.getD();
                } else {
                    return v2.getD();     
                }
            }
        }

        throw new MapExeption("Coordonnées GROUND non trouvé !");
    }

    /**
     * Obtenir la dernière Coordonnée ajouté
     *
     * @return
     */
    public Coordinates get_lastcoordinate() {
        return coordinates.get(coordinates.size() - 1);
    }

    /**
     * Renvoie la case si elle existe
     *
     * @param c2
     * @return
     */
    
    public Tile getTile(Coordinates c2) {

        for (Coordinates c : coordinates) {
            if (c.equals(c2)) {
                return map.get(c);
            }
        }
        return map.get(new Coordinates(0, 0));
    }

    public boolean groundpath() {
        Coordinates last = coordinates.get(coordinates.size() - 1);
        Coordinates soon = coordinates.get(coordinates.size() - 2);

        return ((FlyTile) map.get(last)).getT()
                == Type.GROUND
                && Type.GROUND
                == ((FlyTile) map.get(soon)).getT();
    }

    public Coordinates getMaxCord() {
        int max_x = -1;
        int max_y = -1;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getX() > max_x) {
                max_x = coordinates.get(i).getX();
            }
            if (coordinates.get(i).getY() > max_y) {
                max_y = coordinates.get(i).getY();
            }
        }

        return new Coordinates(max_x, max_y);
    }

    public Coordinates getMinCord() {
        int min_x = 1000;
        int min_y = 1000;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getX() < min_x) {
                min_x = coordinates.get(i).getX();
            }
            if (coordinates.get(i).getY() < min_y) {
                min_y = coordinates.get(i).getY();
            }
        }
        return new Coordinates(min_x, min_y);
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
