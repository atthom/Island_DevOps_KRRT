package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.exceptions.InvalidNumberException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Loïc on 08/12/2015.
 */
public class ResourceTest {

    Resource r;

    public ResourceTest(){
        // default constructor
    }

    @Before
    public void setUp(){r = new Resource();}

    @Test
    public void testSetName(){r.setName("FISH"); assertEquals("FISH", r.getName());}

    @Test
    public void testGetName(){assertEquals("UNKNOWN", r.getName());}

    @Test
    public void testIsPrimary(){r.setName("FISH"); assertEquals(true, r.isPrimaryRessource()); r.setName("GLASS"); assertEquals(false, r.isPrimaryRessource());}

    @Test
    public void testGetAmount(){assertEquals("UNKNOWN", r.getAmount());}

    @Test
    public void testGetCondition(){assertEquals("UNKNOWN", r.getCondition());}

    @Test(expected = InvalidNumberException.class)
    public void testRetrieveWithBadValue() throws InvalidNumberException{
        r.setNbExploitedRessource(100);
        r.retrieve(1000);
    }

    @Test
    public void testRetrieveWithGoodValue() throws InvalidNumberException{
        r.setNbExploitedRessource(100);
        r.retrieve(50);
        assertEquals(50, r.getNbExploitedRessource());
    }

}
