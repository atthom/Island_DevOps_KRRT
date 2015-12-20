package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.composed.PrettyTTOL;
import fr.unice.polytech.qgl.qae.actions.flyActions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.MoveTo;
import fr.unice.polytech.qgl.qae.actions.groundActions.withparams.Scout;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 * Created by user on 19/12/15.
 */
public class MoveAndScout extends ComposedAction {

    public MoveAndScout(Coordinates current, Direction dir) {
        super(current, dir);
        super.add(new Scout(dir));
        super.add(new MoveTo(dir));
        maj_coord(current, dir);
    }
}
