/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae;
 
import fr.unice.polytech.qgl.qae.map.HeadingType;
import fr.unice.polytech.qgl.qae.resources.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author user
 */
public class MissionAssignmentTest {

    MissionAssignment theMission;

    public MissionAssignmentTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
        theMission = new MissionAssignment();
    }

    /**
     * This method just test the method getNb_men (MissionAssignment.java)
     */
    @Test
    public void testGetNbMen() {
        theMission.setNb_men(100);
        assertEquals(theMission.getNb_men(), 100);
    }

    /**
     * This method just test the method getBudget (MissionAssignment.java)
     */
    @Test
    public void testGetBudget() {
        theMission.setBudget(2500);
        assertEquals(theMission.getBudget(), 2500);
    }

    /**
     * This method just test the method retrieveActionPoint (MissionAssignment.java)
     */
    @Test
    public void testRetrieveActionPoint() {
        theMission.setBudget(2500);
        theMission.retrieveActionPoint(500);
        assertEquals(theMission.getBudget(), 2000);
    }

    /**
     * This method just test the method getHeading (MissionAssignment.java)
     */
    @Test
    public void testGetHeading(){
        theMission.setHeading(fr.unice.polytech.qgl.qae.actions.flyActions.withparams.HeadingType.E);
        assertEquals(theMission.getHeading(), HeadingType.E);
    }

    @Test
    public void testGetContract(){
        theMission.addContract(new Contract(ResourceType.FISH, 100));
        theMission.addContract(new Contract(ResourceType.FLOWER, 50));
        assertEquals(theMission.getContracts().size(), 2);
    }

}
