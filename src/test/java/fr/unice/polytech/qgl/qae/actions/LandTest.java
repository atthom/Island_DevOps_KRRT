/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions;

import fr.unice.polytech.qgl.qae.map.tile.Creek;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class LandTest {
    Land l;
    
    public LandTest() {
    }
    
    @Before
    public void setUp() {
        Creek c = new Creek("la");
        l = new Land(c, 8);
       
    }

    /**
     * Test of getValueParameter method, of class Land.
     */
    @Test
    public void testGetValueParameter() {
        assertEquals(8, l.getValueParameter());
    }
    
}
