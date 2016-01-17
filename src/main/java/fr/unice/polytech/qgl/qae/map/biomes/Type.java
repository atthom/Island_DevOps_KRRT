/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.biomes;

import java.util.ArrayList;

/**
 *
 * @author user
 * Represents the information returned by the Radar
 */
public enum Type {
    GROUND,
    OCEAN,
    OUT_OF_RANGE,
    UNKNOWN_TYPE;

     public Type Biomes2Type(ArrayList<Biome> b) {
        if(b.size()==1) {
            if(null != b.get(0).getBiomeType()) switch (b.get(0).getBiomeType()) {
                case OCEAN:
                    return OCEAN;
                case UNKNOWN_BIOME:
                    return UNKNOWN_TYPE;
                default:
                    return GROUND;
            }
        } 
        return GROUND;
    }
}
