/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.Type;
import static fr.unice.polytech.qgl.qae.map.Type.UNKNOWN_TYPE;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Case Aérienne utilisée lors de la phase aérienne
 *
 * @author user
 */
public class FlyTile extends Tile {

    private Type t;
    private ArrayList<Creek> creeks;

    /**
     * Case par défaut (type non connu et sans biomes)
     */
    public FlyTile() {
        super();
        creeks = new ArrayList<>();
        this.t = UNKNOWN_TYPE;
    }
    
    public FlyTile(ArrayList<Biome> bs, ArrayList<Creek> cs, Type t) {
        super(bs);
        this.t = t;
        creeks = new ArrayList<>(cs);
    }

    @Override
    public String toString() {
        return "FlyTile{" +
                "t=" + t +
                ", creeks=" + creeks +
                '}';
    }

    public boolean havecreeks() {
        return !creeks.isEmpty();
    }

    public ArrayList<Creek> getCreeks() {
        return creeks;
    }
    
    
    
    

    /**
     * Case avec un type connu
     *
     * @param t
     */
    public FlyTile(Type t) {
        super();
        this.t = t;
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
     * @return la liste de creek
     */
    public ArrayList<Creek> getC() {
        return creeks;
    }


    /**
     *
     * @param t type à metre à jour
     */
    public void setT(Type t) {
        this.t = t;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlyTile other = (FlyTile) obj;
        if (this.t != other.t) {
            return false;
        }
        return Objects.equals(this.creeks, other.creeks);
    }

    
}
