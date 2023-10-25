/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author quyen
 */
public class StoreKeeperTest {
    
    public StoreKeeperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStoreKeeper method, of class StoreKeeper.
     */
    @Test
    public void testGetStoreKeeper() {
        System.out.println("getStoreKeeper");
        StoreKeeper instance = null;
        String expResult = "";
        String result = instance.getStoreKeeper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class StoreKeeper.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        StoreKeeper instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStoreKeeper method, of class StoreKeeper.
     */
    @Test
    public void testSetStoreKeeper() {
        System.out.println("setStoreKeeper");
        String storeKeeper = "";
        StoreKeeper instance = null;
        instance.setStoreKeeper(storeKeeper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class StoreKeeper.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        StoreKeeper instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
