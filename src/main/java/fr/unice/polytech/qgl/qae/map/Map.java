/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class Map {

    private HashMap<Coordinates, Tile> map;
    private ArrayList<Coordinates> coordinates;

    public Map(Tile origin) {
        map = new HashMap<>();
        coordinates = new ArrayList<>();
        put(new Coordinates(0, 0), origin);
    }

    private void put(Coordinates c, Tile t) {
        map.putIfAbsent(c, t);
        coordinates.add(c);
    }

    public void add(Vect v1, Vect v2, Tile t) {
        map.put(convert(v1, v2), t);
    }

    public void add(Vect v1, Tile t) {
        put(convert(v1), t);
    }

    public Coordinates convert(Vect v1) {
        if (v1.is_xaxis()) {
            return new Coordinates(v1.getValeur(), 0);
        } else {
            return new Coordinates(0, v1.getValeur());
        }
    }

    public Coordinates convert(Vect v1, Vect v2) {
        if (v1.issimilare(v2)) {
            return new Coordinates(0, 0);
        } else if (v1.is_xaxis()) {
            return new Coordinates(v1.getValeur(), v2.getValeur());
        } else {
            return new Coordinates(v2.getValeur(), v1.getValeur());
        }
    }

    public Tile getTile(Vect v1, Vect v2) {
        Coordinates coord = convert(v1, v2);
        
        for (Coordinates c : coordinates) {
            if (c.getX() == coord.getX() & c.getY() == coord.getY()) {
                return map.get(c);
            }
        }

        return map.get(new Coordinates(0, 0));
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
