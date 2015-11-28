/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import java.util.ArrayList;

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
        biomes = new ArrayList<>(biomes);
    }

    /**
     *
     * @param b ajouter un biome dans la liste
     */
    public void addBiome(Biome b) {
        biomes.add(b);
    }

    public Biome getB(BiomeType bb) {
        for (int i = 0; i < biomes.size(); i++) {
            if (biomes.get(i).getBiomeType() == bb) {
                return biomes.get(i);
            }
        }
        throw new MapExeption("Biome non trouvée");
    }

}
