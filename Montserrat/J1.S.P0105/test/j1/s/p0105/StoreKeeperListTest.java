/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

import java.util.ArrayList;
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
public class StoreKeeperListTest {
    
    public StoreKeeperListTest() {
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
     * Test of getLastID method, of class StoreKeeperList.
     */
    @Test
    public void testGetLastID() {
        System.out.println("getLastID");
        StoreKeeperList instance = new StoreKeeperList();
        int expResult = 0;
        int result = instance.getLastID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastID method, of class StoreKeeperList.
     */
    @Test
    public void testSetLastID() {
        System.out.println("setLastID");
        int lastID = 0;
        StoreKeeperList instance = new StoreKeeperList();
        instance.setLastID(lastID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeeperList method, of class StoreKeeperList.
     */
    @Test
    public void testGetKeeperList() {
        System.out.println("getKeeperList");
        StoreKeeperList instance = new StoreKeeperList();
        ArrayList<StoreKeeper> expResult = null;
        ArrayList<StoreKeeper> result = instance.getKeeperList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeeperList method, of class StoreKeeperList.
     */
    @Test
    public void testSetKeeperList() {
        System.out.println("setKeeperList");
        ArrayList<StoreKeeper> keeperList = null;
        StoreKeeperList instance = new StoreKeeperList();
        instance.setKeeperList(keeperList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printKeeperList method, of class StoreKeeperList.
     */
    @Test
    public void testPrintKeeperList() {
        System.out.println("printKeeperList");
        StoreKeeperList instance = new StoreKeeperList();
        instance.printKeeperList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStoreKeeper method, of class StoreKeeperList.
     */
    @Test
    public void testAddStoreKeeper() {
        System.out.println("addStoreKeeper");
        StoreKeeper sk = null;
        StoreKeeperList instance = new StoreKeeperList();
        instance.addStoreKeeper(sk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExist method, of class StoreKeeperList.
     */
    @Test
    public void testCheckExist() {
        System.out.println("checkExist");
        StoreKeeper sk = null;
        StoreKeeperList instance = new StoreKeeperList();
        boolean expResult = false;
        boolean result = instance.checkExist(sk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choose method, of class StoreKeeperList.
     */
    @Test
    public void testChoose() {
        System.out.println("choose");
        StoreKeeperList instance = new StoreKeeperList();
        StoreKeeper expResult = null;
        StoreKeeper result = instance.choose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
