package fr.unice.polytech.qgl.qae.managing;

import fr.unice.polytech.qgl.qae.exceptions.NotEnoughResourceException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Loïc
 */
public class StockManagerTest {

    StockManager theStockManagerWeAreTesting;

    @Before
    public void setUp(){
        theStockManagerWeAreTesting = new StockManager();
    }

    @Test
    public void addToStockTest(){
        // We add 10 PLANK to the stock, so it should return the number of WOOD in the stock (initial number of WOOD is 0)
        assertEquals(10, theStockManagerWeAreTesting.addToStock("WOOD", 10));
        // Then we add 90 PLANK to the stock, so it should return the number of wood in the stock (i.e 100 WOOD, because there is already 10 at the moment)
        assertEquals(100, theStockManagerWeAreTesting.addToStock("WOOD", 90));
        // TODO - when the function will be OK, check if we throw an exception if we add a non positive value
    }

    @Test
    public void removeFromStockTest() throws NotEnoughResourceException{
        theStockManagerWeAreTesting.addToStock("QUARTZ", 50);
        assertEquals(25, theStockManagerWeAreTesting.removeFromStock("QUARTZ", 25));
    }

    @Test
    public void removeFromStockTestByThrowingException(){
        theStockManagerWeAreTesting.addToStock("FISH", 10);
        try {
            theStockManagerWeAreTesting.removeFromStock("FISH", 11);
            fail("Error: wrong value, we don't have enough resource in the stock");
        } catch (NotEnoughResourceException e){
        }
    }

    @Test
    public void getStockValueTest(){
        // There is no ORE at the moment, so the method returns 0
        assertEquals(0, theStockManagerWeAreTesting.getStockValue("ORE"));
        // Now we add 10 ORE in the stock...
        theStockManagerWeAreTesting.addToStock("ORE", 10);
        // Now, the method getStockValue should returns 10
        assertEquals(10, theStockManagerWeAreTesting.getStockValue("ORE"));
    }
}
