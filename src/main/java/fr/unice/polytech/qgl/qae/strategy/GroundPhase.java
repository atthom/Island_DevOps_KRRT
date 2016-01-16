/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.strategy;

import fr.unice.polytech.qgl.qae.actions.AbstractAction;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.map.FlyingMap;
import fr.unice.polytech.qgl.qae.map.map.GroundMap;
import fr.unice.polytech.qgl.qae.reply.ManageGroundReply;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public abstract class GroundPhase extends AbstractPhase {
    protected ManageGroundReply mgr;
    public GroundMap gm;
    protected Direction scout_dir;

    public GroundPhase(AbstractStrategy parent, Coordinates currents_coords, FlyingMap m, GroundMap gm) {
        super(parent, currents_coords, m);
        this.gm = gm;
        mgr = new ManageGroundReply();
    }

    @Override
    public abstract AbstractPhase getNext();

    @Override
    public abstract AbstractAction execute();

    @Override
    public void acknowledge(JSONObject s) {
        mgr.manage(s, gm, scout_dir, currents_coords);
    }
}
