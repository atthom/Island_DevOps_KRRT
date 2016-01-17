package fr.unice.polytech.qgl.qae.resources;


/**
 * Created by Loïc on 08/12/2015.
 */
public class OldResource {

    private String name;
    private String amountCondition; /* can be high, medium, low or unknown */
    private String condition; /* can be harsh, fair, easy or unknown */
    private boolean isPrimaryResource;
    private boolean isNeeded;
    private int nbExploitedRessource;
    private int nbResourcesNeeded;

    // section == CONSTRUCTOR
    public OldResource(){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = 0;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = ResourceType.UNKNOWN.name();
        this.amountCondition = ResourceAmountType.UNKNOWN.name();
        this.condition = ResourceConditionType.UNKNOWN.name();
    } /* For any OldResource object we  */

    public OldResource(int nbResourcesNeeded, String name){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = nbResourcesNeeded;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = name;
        this.amountCondition = ResourceAmountType.UNKNOWN.name();
        this.condition = ResourceConditionType.UNKNOWN.name();
    } /* For any OldResource when we know how many resource of what type of resource we need to collect */



    // section == SETTER & GETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return this.amountCondition;
    }

    public void setAmountCondition(ResourceAmountType amount) {
        this.amountCondition = amount.name();
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(ResourceConditionType condition) {
        this.condition = condition.name();
    }

    public boolean isPrimaryRessource() {
        boolean isPrimary = true;
        if(this.name.equals("GLASS") || this.name.equals("INGOT") || this.name.equals("LEATHER") || this.name.equals("PLANK") || this.name.equals("RUM")){
            isPrimary = false;
        }
        return isPrimary;
    }

    public void setPrimaryRessource(boolean primaryRessource) {
        isPrimaryResource = primaryRessource;
    }

    public int getNbExploitedRessource() {
        return nbExploitedRessource;
    }

    public void setNbExploitedRessource(int nbExploitedRessource) {
        this.nbExploitedRessource = nbExploitedRessource;
    }

    public boolean isNeeded() {
        return isNeeded;
    }

    public void setNeeded(boolean needed) {
        isNeeded = needed;
    }

    public int getNbResourcesNeeded() {
        return nbResourcesNeeded;
    }

    public void setNbResourcesNeeded(int nbResourcesNeeded) {
        this.nbResourcesNeeded = nbResourcesNeeded;
    }



    // METHODS
    public void retrieve(int n)  {
        // if we try to retrieve more than our number of resource
        if(n > this.getNbExploitedRessource()){
            // we throw an InvalidNumberException exception because it's impossible
    //        throw new InvalidNumberException(n);
        } else {
            // else we just retrieve the amount specified
            this.nbExploitedRessource -= n;
        }
    }
}
