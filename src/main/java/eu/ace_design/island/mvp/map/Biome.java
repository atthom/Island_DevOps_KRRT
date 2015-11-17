/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ace_design.island.mvp.map;

/**
 *
 * @author user
 */
public class Biome {
    private BiomeType b;
    
    public Biome() {
        b = BiomeType.UNKNOWN_BIOME;
    }

    public Biome(BiomeType b) {
        this.b = b;
    }

    public BiomeType getB() {
        return b;
    }

    public void setB(BiomeType b) {
        this.b = b;
    }
    
}
