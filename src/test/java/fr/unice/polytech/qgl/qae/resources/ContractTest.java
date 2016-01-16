package fr.unice.polytech.qgl.qae.resources;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Loïc on 08/01/2016.
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
