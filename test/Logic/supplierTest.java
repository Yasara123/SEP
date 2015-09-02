/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nandula
 */
public class supplierTest {
    
    public supplierTest() {
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
     * Test of getName method, of class supplier.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        supplier instance = new supplier();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class supplier.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        supplier instance = new supplier();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class supplier.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        supplier instance = new supplier();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class supplier.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        supplier instance = new supplier();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTel method, of class supplier.
     */
    @Test
    public void testGetTel() {
        System.out.println("getTel");
        supplier instance = new supplier();
        int expResult = 0;
        int result = instance.getTel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTel method, of class supplier.
     */
    @Test
    public void testSetTel() {
        System.out.println("setTel");
        int tel = 0;
        supplier instance = new supplier();
        instance.setTel(tel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class supplier.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        supplier instance = new supplier();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class supplier.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        supplier instance = new supplier();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
