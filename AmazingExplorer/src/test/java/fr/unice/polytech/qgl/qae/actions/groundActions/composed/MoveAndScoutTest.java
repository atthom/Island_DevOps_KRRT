/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.actions.groundActions.composed;

import fr.unice.polytech.qgl.qae.actions.flyActions.composed.PrettyTTOL;
import fr.unice.polytech.qgl.qae.actions.flyActions.withparams.Direction;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thom
 */
public class MoveAndScoutTest {

  MoveAndScout masE, masS, masN, masW;
  Coordinates c;
  Direction E, S, N, W;

  public MoveAndScoutTest() {
  }

  @Before
  public void setUp() {
    c = new Coordinates(0, 0);
    E = Direction.E;
    S = Direction.S;
    W = Direction.W;
    N = Direction.N;
    masE = new MoveAndScout(c, E);
    masS = new MoveAndScout(c, S);
    masW = new MoveAndScout(c, W);
    masN = new MoveAndScout(c, N);
  }

  @Test
  public void testSomeMethod() {
    assertEquals(new Coordinates(1, 0), masE.getCoords());
    assertEquals(E, masE.getDir());

    assertEquals(new Coordinates(-1, 0), masW.getCoords());
    assertEquals(W, masW.getDir());

    assertEquals(new Coordinates(0, -1), masS.getCoords());
    assertEquals(S, masS.getDir());

    assertEquals(new Coordinates(0, 1), masN.getCoords());
    assertEquals(N,  masN.getDir());
  }

}
