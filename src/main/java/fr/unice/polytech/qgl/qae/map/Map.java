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
    
    
    public Map(Tile origin) {
        map.put(new Coordinates(0, 0), origin);
    }
    
    public void add(int longeur, int largeur, Tile t) {
        map.putIfAbsent(new Coordinates(longeur, largeur), t);
    }
    
  //  public Tile getTilde(int longeur, int largeur) 
   
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
