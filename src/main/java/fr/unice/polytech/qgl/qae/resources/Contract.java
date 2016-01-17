package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.resources.ResourceType;

/**
 * Created by Loïc on 27/12/2015.
 */
public class Contract {

    private String name;
    private int amount;

    public Contract(ResourceType theResourceName, int theAmount){
        this.name = theResourceName.toString();
        this.amount = theAmount;
    }

    public Contract(String theResourceName, int theAmount){
        this.name = theResourceName;
        this.amount = theAmount;
    }

    public int getAmount(){
        return this.amount;
    }

    public String getResourceName(){
        return this.name;
    }
}
