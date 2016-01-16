/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy.choosecreeks;

import fr.unice.polytech.qgl.qae.Objectif;
import fr.unice.polytech.qgl.qae.actions.Land;
import fr.unice.polytech.qgl.qae.actions.Stop;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.Biome;
import fr.unice.polytech.qgl.qae.map.BiomeType;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.fly.FlyingStrategy;
import fr.unice.polytech.qgl.qae.strategy.ground.InitTerrestre;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ChooseCreekTest {

    ChooseCreek cc;
    AbstractStrategy ex;
    Objectif ob;
    Map m;
    FlyTile ocean;

    public ChooseCreekTest() {
    }

    @Before
    public void setUp() {
        ex = new FlyingStrategy(Direction.E, ob);

        ArrayList<Biome> bs = new ArrayList<>();
        bs.add(new Biome(BiomeType.OCEAN));
        ocean = new FlyTile(bs, new ArrayList<>(), Type.OCEAN);

        m = new Map();
        m.getFlyingmap().put(new Coordinates(5, 5), new FlyTile(Type.GROUND));

        cc = new ChooseCreek(ex, new Coordinates(5, 5), Direction.S, m);
    }

    
    private void putcreek() {
        ArrayList<String> cs = new ArrayList<>();
        cs.add("addad");
        cc.map.getFlyingmap().put(new Coordinates(7, 6), new FlyTile(new ArrayList<>(), cs, Type.GROUND));
    }
    /**
     * Test of getNext method, of class ChooseCreek.
     */
    @Test
    public void testGetNext() {
        assertEquals(cc, cc.getNext());
        putcreek();
        assertEquals(new InitTerrestre( ex, cc.currents_coords, cc.d, m), cc.getNext());
    }

    /**
     * Test of execute method, of class ChooseCreek.
     */
    @Test
    public void testExecute() {
        cc.execute();
        assertEquals(new Stop(), cc.actions.get(0));
    }
    
    /**
     * Test of execute method, of class ChooseCreek.
     */
    @Test
    public void testExecute2() {
        putcreek();
        cc.execute();
        assertEquals(new Land("addad", 1), cc.actions.get(0));
    }
  
   

   
}
