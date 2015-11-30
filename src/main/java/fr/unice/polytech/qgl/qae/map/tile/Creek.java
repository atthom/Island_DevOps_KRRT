/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map.tile;

import fr.unice.polytech.qgl.qae.map.tile.GroundTile;
import java.util.Objects;

/**
 * Classe criques provient de GroundTile 
 * @author user
 */
public class Creek {
    String id;
 
    public Creek(String id) {
       
        this.id = id;
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
        final Creek other = (Creek) obj;
        return Objects.equals(this.id, other.id);
    }
}
