/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.JSONFactory;
import fr.unice.polytech.qgl.qae.actions.Heading;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Tile;

/**
 *
 * @author user
 */
public class FlyingStrategy  extends Strategy{
    Heading h;
    int nbtours;
    Map flyingMap;
    
    public FlyingStrategy(String heading) {
        JSONFactory j = new JSONFactory();
        h = j.build_heading(heading);
        nbtours =0;
        flyingMap = new Map(new Tile());
    }

    public FlyingStrategy(Heading heading) {
        h = heading;
    }
    
    @Override
    String execute() {
      
      
      return "";
    }

    @Override
    void acknowledge() {
        
    }
    
    
    
    
    
    
    
    
    
    
}
