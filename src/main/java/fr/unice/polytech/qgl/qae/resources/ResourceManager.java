package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.Objectif;

import java.util.ArrayList;

/**
 * Created by Loïc on 27/12/2015.
 */
public class ResourceManager extends PrimaryResource {

    private Objectif objectif;
    private ArrayList<PrimaryResource> resourcesNeeded;

    public ResourceManager(Objectif theObjectif){
        objectif = theObjectif;
        resourcesNeeded = new ArrayList<>();
        for (PrimaryResource r : objectif.getContract()) {
            this.resourcesNeeded.add(r);
        }
    }



}
