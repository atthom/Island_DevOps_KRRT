package fr.unice.polytech.qgl.qae.actions;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Heading extends ActionWithParameters {


    public Heading(Direction d){
        super(new Parameter("direction", d.toString()), "heading");
    }

}
