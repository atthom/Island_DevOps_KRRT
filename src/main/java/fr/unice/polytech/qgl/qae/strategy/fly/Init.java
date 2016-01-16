package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;
import fr.unice.polytech.qgl.qae.strategy.FlyingPhase;
import java.util.Map;

/**
 * Created by user on 03/12/15.
 */
public class Init extends FlyingPhase {

    private Direction dir_to_echo = null;
    private Boolean manage_echo = false;

    public Init(AbstractStrategy parent, Coordinates currents_coords, Direction d, FlyingMap m) {
        super(parent, currents_coords, d, m);
        actions.add(new Echo(d.left()));
        actions.add(new Echo(d.right()));
        actions.add(new Echo(d));
    }

    @Override
    public AbstractPhase getNext() {
        if (actions.isEmpty() && next) {
            return new GoGround(parent, currents_coords, d, map);
        } else if (actions.isEmpty()) {
            try {
                execute();
                return this;
            } catch (Exception ex) {
                return new GoGround(parent, currents_coords, d, map);
            }
        } else {
            return this;
        }
    }

    /**
     * récupère les coordonnnées de chaque echo instancie la map avec les
     * valeurs max si elles existes
     */
    private void manage_echo() {
        Coordinates echo_front = map.getLastTile().getKey();
        Coordinates echo_right = map.preced(echo_front);
        Coordinates echo_left = map.preced(echo_right);

        map.setMin(echo_left);

        if (map.getTile(echo_front).getT() == Type.OUT_OF_RANGE) {
            Coordinates max = new Coordinates(echo_right.getX(), echo_front.getY());
            map.setMax(max);
        }
    }

    /**
     *
     * @return true si la carte a trouvé une terre
     */
    public boolean have_ground() {
        return map.getMap().entrySet().stream().anyMatch((entry) -> (entry.getValue().getT()==Type.GROUND));
    }

    public Direction best_dir() {
        int dist1 = map.get(0).distance(map.get(1));
        int dist2 = map.get(0).distance(map.get(2));
        if (dist1 > dist2) {
            return d.left();
        } else {
            return d.right();
        }
    }

    @Override
    public AbstractAction execute() {
        if (actions.isEmpty()) {
            if (manage_echo == false) {
                manage_echo();
                manage_echo = true;
            }

            if (have_ground()) {
                // si pas dans la bonne direction
                if (dir_to_echo != null) {
                    change_dir(dir_to_echo);
                }
                next = true;
            } else {
                dir_to_echo = best_dir();
                manageComposedAction(new FlyAndEcho(currents_coords, d, dir_to_echo));
            }
        }
        return actions.get(0);
    }

}
