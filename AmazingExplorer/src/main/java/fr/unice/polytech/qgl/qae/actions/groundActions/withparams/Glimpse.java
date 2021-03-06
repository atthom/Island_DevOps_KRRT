package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;

import fr.unice.polytech.qgl.qae.actions.ActionWithParameters;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.Parameter;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 19/12/15.
 */
public class Glimpse extends ActionWithParameters {

    /**
     * Action MoveTo avec une direction comme parametre
     *
     * @param d
     */
    public Glimpse(Direction d, int r) {
        super(new ArrayList<>(), "glimpse");
        parameters.add(new Parameter("direction",d));
        parameters.add(new Parameter("range",r));
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }

    public int getRange(){
        return (int) parameters.get(1).getValeur();
    }
}
