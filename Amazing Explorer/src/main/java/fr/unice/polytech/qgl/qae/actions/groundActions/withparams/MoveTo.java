package fr.unice.polytech.qgl.qae.actions.groundActions.withparams;

import fr.unice.polytech.qgl.qae.actions.ActionWithParameters;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.Parameter;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;

/**
 * Created by user on 19/12/15.
 */
public class MoveTo extends ActionWithParameters {

    Direction d;
    /**
     * Action MoveTo avec une direction comme parametre
     *
     * @param d
     */
    public MoveTo(Direction d) {
        super(new Parameter("direction", d), "move_to");
        this.d = d;
    }

    /**
     * Créer un object MoveTo à partir d'une chaine de caractères.
     *
     * @param s
     */
    public MoveTo(String s) {
        super(new Parameter("direction", new JSONObject(s).getEnum(Direction.class, "direction")), "move_to");
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }

    public void maj_coord(Coordinates c) {
        switch (d) {
            case E:
                c.addX(1);
                break;
            case W:
                c.addX(-1);
                break;

            case S:
                c.addY(-1);
                break;
            default:
                c.addY(1);
                break;
        }
    }
}
