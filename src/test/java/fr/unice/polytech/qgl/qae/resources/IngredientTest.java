package fr.unice.polytech.qgl.qae.resources;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Loïc
 */
public class IngredientTest {

    Ingredient theIngredientWeAreTesting;

    @Before
    public void setUp(){theIngredientWeAreTesting = new Ingredient(PrimaryResourceType.FISH, 100);}

    @Test
    public void getPrimaryResourceTest(){
        assertEquals(PrimaryResourceType.FISH, theIngredientWeAreTesting.getPrimaryResourceName());
    }

    @Test
    public void getAmountTest(){
        assertEquals(100, theIngredientWeAreTesting.getAmount());
    }

}
