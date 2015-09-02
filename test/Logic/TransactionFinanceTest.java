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
public class TransactionFinanceTest {
    
    public TransactionFinanceTest() {
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
     * Test of getType method, of class TransactionFinance.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        TransactionFinance instance = new TransactionFinance();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class TransactionFinance.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        TransactionFinance instance = new TransactionFinance();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class TransactionFinance.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        TransactionFinance instance = new TransactionFinance();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class TransactionFinance.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int value = 0;
        TransactionFinance instance = new TransactionFinance();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class TransactionFinance.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TransactionFinance instance = new TransactionFinance();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class TransactionFinance.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        TransactionFinance instance = new TransactionFinance();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
