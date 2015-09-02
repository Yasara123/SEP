/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import java.util.List;
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
public class TransactionControllerTest {
    
    public TransactionControllerTest() {
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
     * Test of loadDrugs method, of class TransactionController.
     */
    @Test
    public void testLoadDrugs() {
        System.out.println("loadDrugs");
        TransactionController instance = new TransactionController();
        List<Drug> expResult = null;
        List<Drug> result = instance.loadDrugs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processOrder method, of class TransactionController.
     */
    @Test
    public void testProcessOrder() {
        System.out.println("processOrder");
        int empid = 0;
        String transaction = "";
        int total = 0;
        List<Drug> update = null;
        TransactionController instance = new TransactionController();
        boolean expResult = false;
        boolean result = instance.processOrder(empid, transaction, total, update);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
