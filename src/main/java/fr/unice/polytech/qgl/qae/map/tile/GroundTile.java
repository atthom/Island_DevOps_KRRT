/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.resources.AmountResource;
import fr.unice.polytech.qgl.qae.resources.ConditionResource;
import fr.unice.polytech.qgl.qae.resources.PrimaryResource;
import sun.security.tools.keytool.Resources_sv;

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
    private ArrayList<PrimaryResource> res;

    /**
     *
     */
    public GroundTile() {
        altitude = -1;
        //this.amount = AmountResource.UNKNOWN;
        //this.condition = ConditionResource.UNKNOWN;
        res = new ArrayList<>();
    }

    void addResource(PrimaryResource r) {
        res.add(r);
    }

    //public AmountResource getAmountCondition(){return this.amount;}

    PrimaryResource getResource(String r) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).getName().equals(r)) {
                return res.get(i);
            }
        }
        throw new MapExeption("Ressource non trouvée");
    }


    /**
     *
     * @return l'altitde de la case
     */
    public int getAltitude() {
        return altitude;
    }

    public ArrayList<PrimaryResource> getRessource() {
        return res;
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
