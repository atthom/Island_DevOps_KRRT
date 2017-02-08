package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;


import fr.unice.polytech.qgl.qae.actions.ActionWithParameters;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.Parameter;
import org.json.JSONObject;

/**
 * Created by Loïc on 05/12/2015.
 */
public class Scout extends ActionWithParameters {

    public Scout(Direction d){
        super(new Parameter("direction", d), "scout");
    }

    /**
     * Créer un object Scout à partir d'une chaine de caractères.
     *
     * @param s
     */
    public Scout(String s) {
      //  Direction.valueOf(name)
        super(new Parameter("direction", new JSONObject(s).getEnum(Direction.class, "direction")), "scout");
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }
    
    
}
