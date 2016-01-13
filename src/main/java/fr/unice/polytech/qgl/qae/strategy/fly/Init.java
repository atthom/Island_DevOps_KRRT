package fr.unice.polytech.qgl.qae.strategy.fly;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.composed.FlyAndEcho;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Echo;
import fr.unice.polytech.qgl.qae.map.Map;
import fr.unice.polytech.qgl.qae.map.Type;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.strategy.AbstractPhase;
import fr.unice.polytech.qgl.qae.strategy.AbstractStrategy;

/**
 * Created by user on 03/12/15.
 */
public class Init extends AbstractPhase {

    private Direction dir_to_echo = null;
    private Boolean manage_echo = false;

    public Init(AbstractStrategy parent, Coordinates currents_coords, Direction d, Map m) {
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
        Coordinates echo_left = map.getFlyingmap().getlastCoord(0);
        Coordinates echo_right = map.getFlyingmap().getlastCoord(1);
        Coordinates echo_front = map.getFlyingmap().getlastCoord(2);

        map.getFlyingmap().setMin(echo_left);

        if (map.getFlyTile(echo_front).getT() == Type.OUT_OF_RANGE) {
            Coordinates max = new Coordinates(echo_right.getX(), echo_front.getY());
            map.getFlyingmap().setMax(max);
        }
    }

    /**
     *
     * @return true si la carte a trouvé une terre
     */
    public boolean have_ground() {
        return map.getFlyingmap().getCoordinates().stream().anyMatch((coordinate) -> (map.getFlyTile(coordinate).getT() == Type.GROUND));
    }

    public Direction best_dir() {
        int dist1 = map.getFlyingmap().getCoordinates(0).distance(map.getFlyingmap().getCoordinates(1));
        int dist2 = map.getFlyingmap().getCoordinates(0).distance(map.getFlyingmap().getCoordinates(2));
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
