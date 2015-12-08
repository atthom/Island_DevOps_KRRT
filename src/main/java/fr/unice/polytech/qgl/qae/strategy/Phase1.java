package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.simple.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.reply.ManageReply;
import org.json.JSONObject;
import java.lang.Math;
/**
 * Created by user on 03/12/15.
 */
public class Phase1 extends FlyingStrategy {

    public Phase1(Heading heading) {
        super(heading);
    }

    public String execute() {

        return null;
    }

}
