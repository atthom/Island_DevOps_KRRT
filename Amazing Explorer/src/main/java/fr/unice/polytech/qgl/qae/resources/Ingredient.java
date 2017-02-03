package fr.unice.polytech.qgl.qae.resources;

/**
 * Created by Loïc on 30/12/2015.
 */
public class Ingredient {

    private PrimaryResourceType primaryResourceName;
    private int amount;

    public Ingredient(PrimaryResourceType primaryResourceName, int anAmount){
        this.primaryResourceName = primaryResourceName;
        this.amount = anAmount;
    }

    public PrimaryResourceType getPrimaryResourceName() {
        return primaryResourceName;
    }
    public int getAmount() {
        return amount;
    }

}
