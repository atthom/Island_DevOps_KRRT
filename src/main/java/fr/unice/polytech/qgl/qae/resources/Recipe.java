package fr.unice.polytech.qgl.qae.resources;


import fr.unice.polytech.qgl.qae.exceptions.InvalidResourceAmountException;

import java.util.ArrayList;

/**
 * Created by Loïc on 28/11/2015.\
 *
 */
public class Recipe {

    private ManufacturedResourceType manufacturedResource;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
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
        recipeIngredients.add(new Ingredient(primaryResourceName, value));
    }

    /**
     * This method calculate the amount of ingredients we need to produce a certain amount of manufactured resource.
     * @param manufacturedResourceAmount
     * @return
     * @throws InvalidResourceAmountException
     */
    public ArrayList<Ingredient> getIngredients(int manufacturedResourceAmount) throws InvalidResourceAmountException{
        if ((manufacturedResourceAmount % unitaryAmount) != 0){
            throw new InvalidResourceAmountException();
        }
        int multiplier = manufacturedResourceAmount / unitaryAmount;
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Ingredient currentIngredient: recipeIngredients) {
            Ingredient ingredient = new Ingredient(currentIngredient.getPrimaryResourceName(), currentIngredient.getAmount()*multiplier);
            ingredients.add(ingredient);
        }
        return ingredients;
    }
}
