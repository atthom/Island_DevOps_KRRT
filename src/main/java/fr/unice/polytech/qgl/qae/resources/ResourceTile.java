package fr.unice.polytech.qgl.qae.resources;

/**
 * Created by Loïc on 16/01/2016.
 */
public class ResourceTile {

    private PrimaryResourceType resourceName;
    private ResourceAmountType quantity;
    private ResourceConditionType difficulty;

    public ResourceTile(PrimaryResourceType aName, ResourceAmountType aQuantity, ResourceConditionType aDifficulty){
        this.resourceName = aName;
        this.quantity = aQuantity;
        this.difficulty = aDifficulty;
    }

    // Getters and Setter if needed

    /*

    public PrimaryResourceType getResourceName() {
        return resourceName;
    }
    public void setResourceName(PrimaryResourceType resourceName) {
        this.resourceName = resourceName;
    }
    public ResourceAmountType getQuantity() {
        return quantity;
    }
    public void setQuantity(ResourceAmountType quantity) {
        this.quantity = quantity;
    }
    public ResourceConditionType getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(ResourceConditionType difficulty) {
        this.difficulty = difficulty;
    }

    */
}
