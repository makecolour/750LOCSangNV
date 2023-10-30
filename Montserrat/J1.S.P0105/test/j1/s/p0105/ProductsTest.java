/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

import java.util.Date;
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
public class ProductsTest {
    
    public ProductsTest() {
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
     * Test of getId method, of class Products.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Products instance = new Products();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Products.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Products instance = new Products();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Products.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Products instance = new Products();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Products.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Products instance = new Products();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExp method, of class Products.
     */
    @Test
    public void testGetExp() {
        System.out.println("getExp");
        Products instance = new Products();
        Date expResult = null;
        Date result = instance.getExp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMfg method, of class Products.
     */
    @Test
    public void testGetMfg() {
        System.out.println("getMfg");
        Products instance = new Products();
        Date expResult = null;
        Date result = instance.getMfg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Products.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Products instance = new Products();
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStorekeeper method, of class Products.
     */
    @Test
    public void testGetStorekeeper() {
        System.out.println("getStorekeeper");
        Products instance = new Products();
        StoreKeeper expResult = null;
        StoreKeeper result = instance.getStorekeeper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceiptDate method, of class Products.
     */
    @Test
    public void testGetReceiptDate() {
        System.out.println("getReceiptDate");
        Products instance = new Products();
        Date expResult = null;
        Date result = instance.getReceiptDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Products.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Products instance = new Products();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Products.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Products instance = new Products();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Products.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        Products instance = new Products();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Products.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        Products instance = new Products();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExp method, of class Products.
     */
    @Test
    public void testSetExp() {
        System.out.println("setExp");
        Date exp = null;
        Products instance = new Products();
        instance.setExp(exp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMfg method, of class Products.
     */
    @Test
    public void testSetMfg() {
        System.out.println("setMfg");
        Date mfg = null;
        Products instance = new Products();
        instance.setMfg(mfg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategory method, of class Products.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        Products instance = new Products();
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStorekeeper method, of class Products.
     */
    @Test
    public void testSetStorekeeper() {
        System.out.println("setStorekeeper");
        StoreKeeper storekeeper = null;
        Products instance = new Products();
        instance.setStorekeeper(storekeeper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReceiptDate method, of class Products.
     */
    @Test
    public void testSetReceiptDate() {
        System.out.println("setReceiptDate");
        Date receiptDate = null;
        Products instance = new Products();
        instance.setReceiptDate(receiptDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
