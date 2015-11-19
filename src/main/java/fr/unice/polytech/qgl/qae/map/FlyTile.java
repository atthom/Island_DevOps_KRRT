/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import static fr.unice.polytech.qgl.qae.map.Type.UNKNOWN_TYPE;
import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class FlyTile extends Tile {

    private Type t;
    private ArrayList<Biome> res;

    public FlyTile() {
        t = UNKNOWN_TYPE;
        res = new ArrayList<>();
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    void addBiome(Biome b) {
        res.add(b);
    }

}
