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
public class InventoryControllerTest {
    
    public InventoryControllerTest() {
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
     * Test of loadInventory method, of class InventoryController.
     */
    @Test
    public void testLoadInventory() {
        System.out.println("loadInventory");
        InventoryController instance = new InventoryController();
        instance.loadInventory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openHome method, of class InventoryController.
     */
    @Test
    public void testOpenHome() {
        System.out.println("openHome");
        InventoryController instance = new InventoryController();
        instance.openHome();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of purchaseOrder method, of class InventoryController.
     */
    @Test
    public void testPurchaseOrder() {
        System.out.println("purchaseOrder");
        int id = 0;
        String name = "";
        InventoryController instance = new InventoryController();
        instance.purchaseOrder(id, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Message method, of class InventoryController.
     */
    @Test
    public void testMessage() {
        System.out.println("Message");
        String tel = "";
        String mess = "";
        String date = "";
        int id = 0;
        InventoryController instance = new InventoryController();
        boolean expResult = false;
        boolean result = instance.Message(tel, mess, date, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoadAddDrug method, of class InventoryController.
     */
    @Test
    public void testLoadAddDrug() {
        System.out.println("LoadAddDrug");
        InventoryController instance = new InventoryController();
        instance.LoadAddDrug();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDrugDetails method, of class InventoryController.
     */
    @Test
    public void testAddDrugDetails() {
        System.out.println("addDrugDetails");
        Drug adrug = null;
        supplier asup = null;
        InventoryController instance = new InventoryController();
        boolean expResult = false;
        boolean result = instance.addDrugDetails(adrug, asup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoadUpdate method, of class InventoryController.
     */
    @Test
    public void testLoadUpdate() {
        System.out.println("LoadUpdate");
        InventoryController instance = new InventoryController();
        instance.LoadUpdate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDetails method, of class InventoryController.
     */
    @Test
    public void testUpdateDetails() {
        System.out.println("updateDetails");
        Drug drug = null;
        int cost = 0;
        InventoryController instance = new InventoryController();
        boolean expResult = false;
        boolean result = instance.updateDetails(drug, cost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoadRemove method, of class InventoryController.
     */
    @Test
    public void testLoadRemove() {
        System.out.println("LoadRemove");
        InventoryController instance = new InventoryController();
        instance.LoadRemove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class InventoryController.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Drug drug = null;
        InventoryController instance = new InventoryController();
        boolean expResult = false;
        boolean result = instance.remove(drug);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
