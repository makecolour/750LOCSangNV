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
public class ProductsListTest {
    
    public ProductsListTest() {
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
     * Test of getProdList method, of class ProductsList.
     */
    @Test
    public void testGetProdList() {
        System.out.println("getProdList");
        ProductsList instance = new ProductsList();
        ArrayList<Products> expResult = null;
        ArrayList<Products> result = instance.getProdList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdList method, of class ProductsList.
     */
    @Test
    public void testSetProdList() {
        System.out.println("setProdList");
        ArrayList<Products> prodList = null;
        ProductsList instance = new ProductsList();
        instance.setProdList(prodList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
