/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp.map;

import eu.ace_design.island.mvp.map.resources.ExtractedResource;
import eu.ace_design.island.mvp.map.resources.UnextractedResource;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Tile {
    private Biome b;
    private Boolean creeks;
    private int altitude;
    private ArrayList<UnextractedResource> res;
    private Type t;
    
    public Tile() {
        b = new Biome();
        creeks = false;
        altitude = -1;
        res = new ArrayList<>();
        t.UNKNOWN_TYPE
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

    public Boolean getCreeks() {
        return creeks;
    }

    public void setCreeks(Boolean creeks) {
        this.creeks = creeks;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
    
    
}
