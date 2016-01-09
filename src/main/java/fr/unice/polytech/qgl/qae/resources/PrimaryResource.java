package fr.unice.polytech.qgl.qae.resources;

/**
 * Created by Loïc on 27/12/2015.
 * This class represents all the primary resources that will be associated with the tile.
 */
public class PrimaryResource {

    private PrimaryResourceType name;
    private ResourceAmountType quantity;
    private ResourceConditionType difficulty;

    public PrimaryResource(PrimaryResourceType aResourceName){
        this.name = aResourceName;
        this.quantity = ResourceAmountType.UNKNOWN;
        this.difficulty = ResourceConditionType.UNKNOWN;
    }

    public String getName(){return this.name.toString();}

    public void setQuantity(ResourceAmountType aQuantity){ this.quantity = aQuantity;}
    public ResourceAmountType getQuantity(){ return this.quantity;}

    public void setDifficulty(ResourceConditionType aDifficulty){ this.difficulty = aDifficulty;}
    public ResourceConditionType getDifficulty(){ return this.difficulty;}
}
