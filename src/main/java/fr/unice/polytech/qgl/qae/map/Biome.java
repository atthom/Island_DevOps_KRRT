/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

/**
 * Classe de Biome
 * @author user
 */
public class Biome {
    private BiomeType b;
    
    /**
     * Biome par défaut (non connu)
     */
    public Biome() {
        b = BiomeType.UNKNOWN_BIOME;
    }

    /**
     * Biome connu
     * @param b le type de biome
     */
    public Biome(BiomeType b) {
        this.b = b;
    }

    /**
     *
     * @return le type de biome
     */
    public BiomeType getBiomeType() {
        return b;
    }

    /**
     *
     * @param b le nouveau type de biome
     */
    public void setBiomeType(BiomeType b) {
        this.b = b;
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
        final Biome other = (Biome) obj;
        if (this.b != other.b) {
            return false;
        }
        return true;
    }
    
    
    
}
