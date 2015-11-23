/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

/**
 *
 * @author user
 */
public class Biome {
    private BiomeType bt;
    
    public Biome() {
        bt = BiomeType.UNKNOWN_BIOME;
    }

    public Biome(BiomeType bt) {
        this.bt = bt;
    }

    public BiomeType getType() {
        return bt;
    }

    public void setType(BiomeType bt) {
        this.bt = bt;
    }
    
}
