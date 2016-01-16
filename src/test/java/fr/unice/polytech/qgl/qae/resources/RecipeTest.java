package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Loïc
 */
public class RecipeTest {

    Recipe theRecipeWeAreTesting;
    Ingredient ingredient_1;
    Ingredient ingredient_2;

    @Before
    public void setUp(){
        ingredient_1 = new Ingredient(PrimaryResourceType.QUARTZ, 5);
        ingredient_2 = new Ingredient(PrimaryResourceType.WOOD, 10);
        theRecipeWeAreTesting = new Recipe(ManufacturedResourceType.GLASS, 1);
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

    @Test
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
        theRecipeWeAreTesting.addIngredient(PrimaryResourceType.QUARTZ, 5);
        theRecipeWeAreTesting.addIngredient(PrimaryResourceType.WOOD, 10);
        try {
            theRecipeWeAreTesting.getIngredients(-5);
            fail("Error: negative amount...");
        } catch (InvalidResourceAmountException e){
            assert (e.getMessage().contains("Negative number"));
        }
    }

}
