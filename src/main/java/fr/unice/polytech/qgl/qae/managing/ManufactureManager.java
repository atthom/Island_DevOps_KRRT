package fr.unice.polytech.qgl.qae.managing;

import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;
import fr.unice.polytech.qgl.qae.resources.Ingredient;
import fr.unice.polytech.qgl.qae.resources.ManufacturedResourceType;
import fr.unice.polytech.qgl.qae.resources.PrimaryResourceType;
import fr.unice.polytech.qgl.qae.resources.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Loïc on 30/12/2015.
 */
public class ManufactureManager {

    private HashMap<ManufacturedResourceType, Recipe> recipes = new HashMap<>();

    public ManufactureManager(){
        // Glass recipe
        Recipe recipe = new Recipe(ManufacturedResourceType.GLASS, 1);
        recipe.addIngredient(PrimaryResourceType.QUARTZ, 5);
        recipe.addIngredient(PrimaryResourceType.WOOD, 10);
        recipes.put(recipe.getManufacturedResource(), recipe);
        // Ingot recipe
        recipe = new Recipe(ManufacturedResourceType.INGOT, 1);
        recipe.addIngredient(PrimaryResourceType.ORE, 5);
        recipe.addIngredient(PrimaryResourceType.WOOD, 5);
        recipes.put(recipe.getManufacturedResource(), recipe);
        // Leather recipe
        recipe = new Recipe(ManufacturedResourceType.LEATHER, 1);
        recipe.addIngredient(PrimaryResourceType.FUR, 3);
        recipes.put(recipe.getManufacturedResource(), recipe);
        // Plank recipe
        recipe = new Recipe(ManufacturedResourceType.PLANK, 4);
        recipe.addIngredient(PrimaryResourceType.WOOD, 1);
        recipes.put(recipe.getManufacturedResource(), recipe);
        // Rum recipe
        recipe = new Recipe(ManufacturedResourceType.RUM, 1);
        recipe.addIngredient(PrimaryResourceType.SUGAR_CANE, 10);
        recipe.addIngredient(PrimaryResourceType.FRUITS, 1);
        recipes.put(recipe.getManufacturedResource(), recipe);
    }

    public HashMap<PrimaryResourceType,Ingredient> getIngredients(ManufacturedResourceType resourceName, int anAmount) throws InvalidResourceAmountException{
        return recipes.get(resourceName).getIngredients(anAmount);
    }

}
