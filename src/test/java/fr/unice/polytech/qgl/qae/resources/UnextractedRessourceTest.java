package fr.unice.polytech.qgl.qae.resources;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Loïc on 11/21/2015.
 */
public class UnextractedRessourceTest {

    UnextractedResource ur;

    public UnextractedRessourceTest() {
        // constructeur par defaut vide
    }

    @Before
    public void setUp() {
        ur = new UnextractedResource("WOOD");
    }

    @Test
    public void testGetA() {
        assertEquals(Amount.UNKNOWN_AMOUNT, ur.getA());
    }

    @Test
    public void testGetCond() {
        assertEquals(Condition.COND_UNKNOWN, ur.getCond());
    }

    @Test
    public void testSetA() {
        ur.setA(Amount.HIGH);
        assertEquals(Amount.HIGH, ur.getA());
    }

    @Test
    public void testSetCond() {
        ur.setCond(Condition.EASY);
        assertEquals(Condition.EASY, ur.getCond());
    }
}
