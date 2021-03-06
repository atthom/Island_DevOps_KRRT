package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * @author Loïc
 */
public class RecipeTest {

    Recipe theRecipeWeAreTesting;
    Recipe theRecipeWhoTrowException;
    Ingredient ingredient_1;
    Ingredient ingredient_2;

    @Before
    public void setUp(){
        ingredient_1 = new Ingredient(PrimaryResourceType.QUARTZ, 5);
        ingredient_2 = new Ingredient(PrimaryResourceType.WOOD, 10);
        theRecipeWeAreTesting = new Recipe(ManufacturedResourceType.GLASS, 1);
        theRecipeWhoTrowException = new Recipe(ManufacturedResourceType.PLANK, 4);
    }

    @Test
    public void getManufacturedResourceTest(){
        assertEquals(ManufacturedResourceType.GLASS, theRecipeWeAreTesting.getManufacturedResource());
    }

    @Test
    public void getUnitaryAmountTest(){
        assertEquals(1, theRecipeWeAreTesting.getUnitaryAmount());
        assertNotEquals(2, theRecipeWeAreTesting.getUnitaryAmount());
    }

    @Ignore
    public void getIngredientsTest() throws InvalidResourceAmountException{
        theRecipeWeAreTesting.addIngredient(PrimaryResourceType.QUARTZ, 5);
        theRecipeWeAreTesting.addIngredient(PrimaryResourceType.WOOD, 10);
        // If we want to craft 10 GLASS we need to collect 50 QUARTZ (which is the first element in the list)
        assertEquals(50, theRecipeWeAreTesting.getIngredients(10).get(0));
        // If we want to craft 10 GLASS we need to collect 100 WOODS (which is the second element in the list)
        assertEquals(100, theRecipeWeAreTesting.getIngredients(10).get(1));
    }

    @Test
    public void getIngredientsTestWithIncorrectAmount(){
        try {
            // For the PLANK, the unitary amount is 4, so we cannot craft exactly 13 PLANK (not a multiple of 4)
            theRecipeWhoTrowException.getIngredients(13);
            fail("Error: wrong amount given");
        } catch (InvalidResourceAmountException e){
        }
    }

}
