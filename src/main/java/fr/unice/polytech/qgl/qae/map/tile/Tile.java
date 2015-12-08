/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe de case de base
 *
 * @author user
 */
abstract public class Tile {

    private ArrayList<Biome> biomes;

    public Tile() {
        biomes = new ArrayList<>();
    }
    
    public Tile(ArrayList<Biome> biomes) {
        this.biomes = new ArrayList<>(biomes);
        this.biomes.addAll(biomes);
    }

    /**
     *
     * @param b ajouter un biome dans la liste
     */
    public void addBiome(Biome b) {
        biomes.add(b);
    }

    public boolean have_biome(BiomeType bb) {
        for (int i = 0; i < biomes.size(); i++) {
            if (biomes.get(i).getBiomeType() == bb) {
                return true;
            }
        }
        return false;
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
        final Tile other = (Tile) obj;
        return Objects.equals(this.biomes, other.biomes);
    }

}
