package fr.unice.polytech.qgl.qae.resources;

import fr.unice.polytech.qgl.qae.exceptions.InvalidNumberException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Created by Loïc on 08/12/2015.
 */
public class OldPrimaryResourcesTest {

    OldResource r;

    public OldPrimaryResourcesTest(){
        // default constructor
    }

    @Before
    public void setUp(){r = new OldResource();}

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

    @Ignore
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

    @Test
    public void testSetCondition(){
        r.setCondition(ResourceConditionType.EASY);
        assertEquals("EASY", r.getCondition());
    }

    @Test
    public void testSetAmountCondition(){
        r.setAmountCondition(ResourceAmountType.HIGH);
        assertEquals("HIGH", r.getAmount());
    }

}
