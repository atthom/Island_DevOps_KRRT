package fr.unice.polytech.qgl.qae.actions.flyActions.withparams;

import fr.unice.polytech.qgl.qae.actions.Parameter;
import fr.unice.polytech.qgl.qae.actions.ActionWithParameters;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.json.JSONObject;

/**
 * Created by Loic on 11/15/2015.
 */
public class Heading extends ActionWithParameters {

    /**
     * Action Heading avec une direction comme parametre
     *
     * @param d
     */
    public Heading(Direction d) {
        super(new Parameter("direction", d), "heading");
    }

    /**
     * Créer un object Heading à partir d'une chaine de caractères.
     *
     * @param s
     */
    public Heading(String s) {
        super(new Parameter("direction", new JSONObject(s).getEnum(Direction.class, "direction")), "heading");
    }

    @Override
    public Direction getValueParameter() {
        return (Direction) parameters.get(0).getValeur();
    }

    public void maj_coord(Coordinates c, Direction old_dir, Direction new_dir) {
        switch (old_dir) {
            case E:
                c.addX(1);
                if (new_dir == Direction.N) {
                    c.addY(1);
                } else {
                    c.addY(-1);
                }
                break;

            case W:
                c.addX(-1);
                if (new_dir == Direction.N) {
                    c.addY(1);
                } else {
                    c.addY(-1);
                }
                break;

            case S:
                c.addY(-1);
                if (new_dir == Direction.E) {
                    c.addX(1);
                } else {
                    c.addX(-1);
                }
                break;
            default:
                c.addY(1);
                if (new_dir == Direction.E) {
                    c.addX(1);
                } else {
                    c.addX(-1);
                }

                break;
        }
    }

}
