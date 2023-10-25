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
public class InputTest {
    
    public InputTest() {
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
     * Test of getInt method, of class Input.
     */
    @Test
    public void testGetInt() {
        System.out.println("getInt");
        String msg = "";
        int min = 0;
        int max = 0;
        Input instance = new Input();
        int expResult = 0;
        int result = instance.getInt(msg, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getString method, of class Input.
     */
    @Test
    public void testGetString() {
        System.out.println("getString");
        String msg = "";
        String formatMsg = "";
        String regex = "";
        Input instance = new Input();
        String expResult = "";
        String result = instance.getString(msg, formatMsg, regex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDouble method, of class Input.
     */
    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        String msg = "";
        Input instance = new Input();
        double expResult = 0.0;
        double result = instance.getDouble(msg);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Input.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String msg = "";
        Input instance = new Input();
        Date expResult = null;
        Date result = instance.getDate(msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
