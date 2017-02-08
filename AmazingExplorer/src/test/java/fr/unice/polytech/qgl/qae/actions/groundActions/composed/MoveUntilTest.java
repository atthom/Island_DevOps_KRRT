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
public class MoveUntilTest {

  MoveUntil muE, muS, muN, muW;
  Coordinates c;
  Direction E, S, N, W;

  public MoveUntilTest() {
  }

  @Before
  public void setUp() {
    c = new Coordinates(0, 0);
    E = Direction.E;
    S = Direction.S;
    W = Direction.W;
    N = Direction.N;
    muE = new MoveUntil(c, E, 2);
    muS = new MoveUntil(c, S, 2);
    muW = new MoveUntil(c, W, 2);
    muN = new MoveUntil(c, N, 2);
  }

  @Test
  public void testSomeMethod() {
    assertEquals(new Coordinates(2, 0), muE.getCoords());
    assertEquals(E, muE.getDir());

    assertEquals(new Coordinates(-2, 0), muW.getCoords());
    assertEquals(W, muW.getDir());

    assertEquals(new Coordinates(0, -2), muS.getCoords());
    assertEquals(S, muS.getDir());

    assertEquals(new Coordinates(0, 2), muN.getCoords());
    assertEquals(N, muN.getDir());
  }

}
