/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.tile.Tile;
import fr.unice.polytech.qgl.qae.resources.UnextractedResource;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe GroundTile utilisée lors de la phrase d'extraction
 * @author user
 */
public class GroundTile extends Tile {

    private Biome b;
    private int altitude;
    private ArrayList<UnextractedResource> res;

    /**
     *
     */
    public GroundTile() {
        b = new Biome();
        altitude = -1;
        res = new ArrayList<>();

    }

    void addResource(UnextractedResource r) {
        res.add(r);
    }

    /**
     *
     * @return le biome de la case
     */
    public Biome getB() {
        return b;
    }

    /**
     *
     * @param b Biome à mettre à jour
     */
    public void setB(Biome b) {
        this.b = b;
    }

    /**
     *
     * @return l'altitde de la case
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     *
     * @param altitude a mettre à jour
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
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
        final GroundTile other = (GroundTile) obj;
        if (this.altitude != other.altitude) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        return Objects.equals(this.res, other.res);
    }
    
    

}
