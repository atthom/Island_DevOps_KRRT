package fr.unice.polytech.qgl.qae.resources;


import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Loïc on 28/11/2015.\
 *
 */
public class Recipe {

    private ManufacturedResourceType manufacturedResource;
    private HashMap<PrimaryResourceType, Ingredient> recipeIngredients = new HashMap<>();
    private int unitaryAmount;

    public Recipe(ManufacturedResourceType aManufacturedResource, int theUnitaryAmount){
        this.manufacturedResource = aManufacturedResource;
        this.unitaryAmount = theUnitaryAmount;
    }


    public ManufacturedResourceType getManufacturedResource() {
        return manufacturedResource;
    }
    public int getUnitaryAmount() {
        return unitaryAmount;
    }

    public void addIngredient(PrimaryResourceType primaryResourceName, int value){
        recipeIngredients.put(primaryResourceName,new Ingredient(primaryResourceName, value));
    }

    /**
     * This method calculate the amount of ingredients we need to produce a certain amount of manufactured resource.
     * @param manufacturedResourceAmount
     * @return
     * @throws InvalidResourceAmountException
     */
    public HashMap<PrimaryResourceType, Ingredient> getIngredients(int manufacturedResourceAmount) throws InvalidResourceAmountException{
        if ((manufacturedResourceAmount % unitaryAmount) != 0){
            throw new InvalidResourceAmountException();
        }
        int multiplier = manufacturedResourceAmount / unitaryAmount;
        HashMap<PrimaryResourceType, Ingredient> ingredients = new HashMap<>();
        for (Ingredient currentIngredient: recipeIngredients.values()) {
            Ingredient ingredient = new Ingredient(currentIngredient.getPrimaryResourceName(), currentIngredient.getAmount()*multiplier);
            ingredients.put(currentIngredient.getPrimaryResourceName(),ingredient);
        }
        return ingredients;
    }
}
