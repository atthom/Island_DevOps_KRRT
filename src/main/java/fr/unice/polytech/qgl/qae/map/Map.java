/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
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

    FlyingMap flyingmap;
    GroundMap groundmap;

    public Map() {
        this.flyingmap = new FlyingMap();
        this.groundmap = new GroundMap();
    }
    
    public FlyTile getFlyTile(Coordinates c) {
        return flyingmap.getFlyTile(c);
    }
    
    public FlyTile getLastFlyTile() {
        return flyingmap.getlastFlyTile();
    }

    public FlyingMap getFlyingmap() {
        return flyingmap;
    }

    public GroundMap getGroundmap() {
        return groundmap;
    }
   
    
    

   
}
