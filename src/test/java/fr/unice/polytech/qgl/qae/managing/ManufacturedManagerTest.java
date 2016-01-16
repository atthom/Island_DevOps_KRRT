package fr.unice.polytech.qgl.qae.managing;

import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;
import fr.unice.polytech.qgl.qae.resources.ManufacturedResourceType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Loïc on 16/01/2016.
 */
public class ManufacturedManagerTest {

    ManufactureManager theManufacturedManagerWeAreTesting;

    @Before
    public void setUp(){
        theManufacturedManagerWeAreTesting = new ManufactureManager();
    }

    @Test
    public void getIngredientTest() throws InvalidResourceAmountException{
        // If we want to create 2 GLASS we need to collect 10 QUARTZ (which is the first element in the list... cf. ManufacturedManager.java)
        assertEquals(10, theManufacturedManagerWeAreTesting.getIngredients(ManufacturedResourceType.GLASS, 2).get(0));
        // If we want to create 2 GLASS we need to collect 20 WOODS (wich is the second element in the list... cf. ManufacturedManager.java)
        assertEquals(20, theManufacturedManagerWeAreTesting.getIngredients(ManufacturedResourceType.GLASS, 2).get(1));
    }

    @Test
    public void getIngredientTestByThrowingException(){
        try{
            // For the PLANK, the unitary amount is 4, so we cannot craft exactly 13 PLANK (not a multiple of 4)
            theManufacturedManagerWeAreTesting.getIngredients(ManufacturedResourceType.PLANK, 13);
            fail("Error: wrong amount given");
        } catch (InvalidResourceAmountException e){
        }
    }
}
