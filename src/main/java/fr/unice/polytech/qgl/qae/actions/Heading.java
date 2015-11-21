package fr.unice.polytech.qgl.qae.actions;

import org.json.JSONObject;

/**
 * Created by Lo�c on 11/15/2015.
 */
public class Heading extends ActionWithParameters {


    public Heading(Direction d){
        super(new Parameter("direction", d), "heading");
    }
    
    
    public Heading(String s) {
        super(new Parameter("direction", new JSONObject(s).get("direction")), "heading");
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }
    
    

}
