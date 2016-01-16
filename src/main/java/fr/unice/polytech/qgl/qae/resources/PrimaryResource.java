package fr.unice.polytech.qgl.qae.resources;

import java.util.Objects;


/**
 * Created by Loïc on 08/12/2015.
 */
public class PrimaryResource {

    private String name;
    private String amountCondition; /* can be high, medium, low or unknown */
    private String condition; /* can be harsh, fair, easy or unknown */
    private boolean isPrimaryResource;
    private boolean isNeeded;
    private int nbExploitedRessource;
    private int nbResourcesNeeded;

    // section == CONSTRUCTOR
    public PrimaryResource(){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = 0;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = ResourceType.UNKNOWN.name();
        this.amountCondition = AmountResource.UNKNOWN.name();
        this.condition = ConditionResource.UNKNOWN.name();
    } /* For any PrimaryResource object we  */

    public PrimaryResource(int nbResourcesNeeded, String name){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = nbResourcesNeeded;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = name;
        this.amountCondition = AmountResource.UNKNOWN.name();
        this.condition = ConditionResource.UNKNOWN.name();
    } /* For any PrimaryResource when we know how many resource of what type of resource we need to collect */


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

    public void setAmountCondition(AmountResource amount) {
        this.amountCondition = amount.name();
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(ConditionResource condition) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrimaryResource other = (PrimaryResource) obj;
        if (this.isPrimaryResource != other.isPrimaryResource) {
            return false;
        }
        if (this.isNeeded != other.isNeeded) {
            return false;
        }
        if (this.nbExploitedRessource != other.nbExploitedRessource) {
            return false;
        }
        if (this.nbResourcesNeeded != other.nbResourcesNeeded) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.amountCondition, other.amountCondition)) {
            return false;
        }
        return Objects.equals(this.condition, other.condition);
    }
    
    
}
