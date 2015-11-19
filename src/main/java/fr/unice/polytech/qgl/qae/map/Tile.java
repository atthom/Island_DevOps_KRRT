/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;
import static fr.unice.polytech.qgl.qae.map.Type.*;
import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Tile {
    private Biome b;
    private int altitude;
    private ArrayList<UnextractedResource> res;
    private Type t;
    
    public Tile() {
        b = new Biome();
        altitude = -1;
        res = new ArrayList<>();
        t = UNKNOWN_TYPE;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    void addResource(UnextractedResource r) {
        res.add(r);
    }

    public Biome getB() {
        return b;
    }

    public void setB(Biome b) {
        this.b = b;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
    
    
}
