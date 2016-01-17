package fr.unice.polytech.qgl.qae.resources;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Loïc
 */
public class ContractTest {

    Contract theContractWeAreTesting;

    @Before
    public void setUp(){
        theContractWeAreTesting = new Contract(ResourceType.FISH, 100);
    }

    @Test
    public void testGetAmount(){
        assertEquals(100, theContractWeAreTesting.getAmount());
    }

    @Test
    public void testGetResourceName(){
        assertEquals(ResourceType.FISH, theContractWeAreTesting.getResourceName());
    }
}
