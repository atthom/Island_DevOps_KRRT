package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.exceptions.InvalidNumberException;
import org.omg.CORBA.UNKNOWN;

import java.util.ArrayList;

/**
 * Created by Loïc on 08/12/2015.
 */
public class Resource {

    private String name;
    private String amountCondition;
    private String condition;
    private boolean isPrimaryResource;
    private boolean isNeeded;
    private int nbExploitedRessource;
    private int nbResourcesNeeded;

    // section == CONSTRUCTOR
    public Resource(){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = 0;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = ResourceType.UNKNOWN.name();
        this.amountCondition = AmountResource.UNKNOWN.name();
        this.condition = ConditionResource.UNKNOWN.name();
    } /* For any Resource object we  */

    public Resource(int nbResourcesNeeded, String name){
        this.nbExploitedRessource = 0;
        this.nbResourcesNeeded = nbResourcesNeeded;
        this.isNeeded = false;
        this.isPrimaryResource = false;
        this.name = name;
        this.amountCondition = AmountResource.UNKNOWN.name();
        this.condition = ConditionResource.UNKNOWN.name();
    } /* For any Resource when we know how many resource of what type of resource we need to collect */



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

    public void setCondition(String exploitCondition) {
        this.condition = exploitCondition;
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
    public void retrieve(int n) throws InvalidNumberException {
        // if we try to retrieve more than our number of resource
        if(n > this.getNbExploitedRessource()){
            // we throw an InvalidNumberException exception because it's impossible
            throw new InvalidNumberException(n);
        } else {
            // else we just retrieve the amount specified
            this.nbExploitedRessource -= n;
        }
    }
}
