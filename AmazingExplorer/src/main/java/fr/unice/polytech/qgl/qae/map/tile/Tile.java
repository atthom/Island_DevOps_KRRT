/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.biomes.Biome;
import fr.unice.polytech.qgl.qae.map.biomes.BiomeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe de case de base
 *
 * @author user
 */
abstract public class Tile {

    private List<Biome> biomes;

    public Tile() {
        biomes = new ArrayList<>();
    }
    
    public Tile(ArrayList<Biome> biomes) {
        this.biomes = new ArrayList<>(biomes);
    }

    /**
     *
     * @param b ajouter un biome dans la liste
     */
    public void addBiome(Biome b) {
        biomes.add(b);
    }
    
    public int nb_biomes() {
        return biomes.size();
    }
    public void print_biomes() {
        biomes.stream().forEach((biome) -> {
            System.out.println(biome.getBiomeType());
        });
    }
    
    public boolean have_only(BiomeType bb) {
        return biomes.size()==1 &&  biomes.get(0).getBiomeType()==bb || biomes.isEmpty();
    }
    
    public boolean have_biome(BiomeType bb) {
        return biomes.stream().anyMatch((biome) -> (biome.getBiomeType() == bb));
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

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 41 * hash + Objects.hashCode(this.biomes);
    return hash;
  }

}
