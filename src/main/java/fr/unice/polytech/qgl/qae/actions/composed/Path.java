/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.composed;

import fr.unice.polytech.qgl.qae.actions.simple.Fly;
import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;

/**
 *
 * @author user
 */
public final class Path extends ComposedAction {

    public Path(Coordinates current, Direction current_Dir, Coordinates c) {
        super(current, current_Dir);
        if (!current.equals(c)) {

            Coordinates path = current.coords_between(c);
            int Xval = path.getX();
            int Yval = path.getY();
            if ((Xval < 0 && Yval < 0 && !current_Dir.is_minus())) {
//                super.addAll(new TurnAround(current_Dir).getAll());
                current = maj_turnaround(current, current_Dir);
            } else if (Xval > 0 && Yval > 0 && current_Dir.is_minus()) {
  //              super.addAll(new TurnAround(current_Dir).getAll());
                current = maj_turnaround(current, current_Dir);
            }

            path = current.coords_between(c);

            Xval = Math.abs(path.getX());

            while (Xval > 1) {
                super.add(new Fly());
                Xval--;
            }

            if (path.getY() < 0) {
                super.add(new Heading(Direction.S));
            } else if (path.getY() > 0) {
                super.add(new Heading(Direction.N));
            } else {
                super.add(new Fly());
            }
            Yval = Math.abs(path.getY());
            while (Yval > 0) {
                super.add(new Fly());
                Yval--;
            }
        }
    }
    

    private Coordinates maj_turnaround(Coordinates c_curent, Direction d) {
        switch (d) {
            case E:
                return new Coordinates(c_curent.getX(), c_curent.getY() + 2);
            case W:
                return new Coordinates(c_curent.getX(), c_curent.getY() - 2);
            case S:
                return new Coordinates(c_curent.getX() + 2, c_curent.getY());
            default:
                return new Coordinates(c_curent.getX() - 2, c_curent.getY());
        }
    }
}
