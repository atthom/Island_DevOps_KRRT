/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GroundTile extends Tile {

    private Biome b;
    private int altitude;
    private ArrayList<UnextractedResource> res;

    public GroundTile() {
        b = new Biome();
        altitude = -1;
        res = new ArrayList<>();

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
