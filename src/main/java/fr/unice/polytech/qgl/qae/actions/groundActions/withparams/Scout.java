package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;


import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.ActionWithParameters;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Parameter;

/**
 * Created by Loïc on 05/12/2015.
 */
public class Scout extends ActionWithParameters {

    public Scout(Direction d){
        super(new Parameter("direction", d), "scout");
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }
}
