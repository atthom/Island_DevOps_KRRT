/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import fr.unice.polytech.qgl.qae.resources.ResourceTile;


import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to describe each ground tiles of the map.
 * @author Loïc
 */
public class GroundTile extends Tile {

    private int altitude;
    //private AmountResource amount; // represent the amount of this tile's resources
    //private ConditionResource condition; // represent the extraction condition for the resources
    private final ArrayList<ResourceTile> res;
    private final ArrayList<BiomeType> liste_biomes;
    private final String creek;
    /**
     *
     */
    public GroundTile() {
        altitude = -1;
        //this.amount = AmountResource.UNKNOWN;
        //this.condition = ConditionResource.UNKNOWN;
        res = new ArrayList<>();
        liste_biomes = new ArrayList<>();
        this.creek = "";
    }

    void addResource(ResourceTile r) {
        res.add(r);
    }

    //public AmountResource getAmountCondition(){return this.amount;}

    ResourceTile getResource(String r) {
      for (ResourceTile re : res) {
        if (re.getName().equals(r)) {
          return re;
        }
      }
        throw new MapExeption("Ressource non trouvée");
    }

    /**
     *
     * @return l'altitde de la case
     */
    public ArrayList<BiomeType> getListe_biomes() {
        return liste_biomes;
    }

    /**
     *
     * @param altitude a mettre à jour
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        return Objects.equals(this.res, other.res);
    }

    
    
}
