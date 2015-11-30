package fr.unice.polytech.qgl.qae.resources;

/**
 * Created by Loïc on 28/11/2015.
 */
public enum ManufacturedRessources {

    GLASS("GLASS"),
    INGOT("INGOT"),
    LEATHER("LEATHER"),
    PLANK("PLANK"),
    RUM("RUM");

    ManufacturedRessources(String name){
    // constructeur par defaut
    }

    public String getName(){
        return this.name();
    }
}
