/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import static fr.unice.polytech.qgl.qae.map.Type.UNKNOWN_TYPE;
import java.util.ArrayList;

/**
 * Case Aérienne utilisée lors de la phase aérienne
 * @author user
 */
public class FlyTile extends Tile {

    private Type t;
    private ArrayList<Biome> res;

    /**
     * Case par défaut (type non connu et sans biomes)
     */
    public FlyTile() {
        super();
        this.t = UNKNOWN_TYPE;
        this.res = new ArrayList<>();
    }
    
    /**
     * Case avec un type connu
     * @param t
     */
    public FlyTile(Type t) {
        super();
        this.t = t;
        this.res = new ArrayList<>();
    }
    
    /**
     *
     * @return le type de la case
     */
    public Type getT() {
        return t;
    }

    /**
     *
     * @param t type à metre à jour
     */
    public void setT(Type t) {
        this.t = t;
    }

   
     /**
     *
     * @param b ajouter un biome dans la liste
     */
    void addBiome(Biome b) {
        res.add(b);
    }

}
