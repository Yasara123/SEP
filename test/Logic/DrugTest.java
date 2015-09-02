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
public class DrugTest {
    
    public DrugTest() {
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
     * Test of getName method, of class Drug.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Drug instance = new Drug();
        instance.setName("Panadol");
        String expResult = "Panadol";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Drug.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Panadol";
        Drug instance = new Drug();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Drug.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Drug instance = new Drug();
        instance.setPrice(10);
        int expResult = 10;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Drug.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 10;
        Drug instance = new Drug();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMOQ method, of class Drug.
     */
    @Test
    public void testGetMOQ() {
        System.out.println("getMOQ");
        Drug instance = new Drug();
        instance.setMOQ(15);
        int expResult = 15;
        int result = instance.getMOQ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMOQ method, of class Drug.
     */
    @Test
    public void testSetMOQ() {
        System.out.println("setMOQ");
        int MOQ = 15;
        Drug instance = new Drug();
        instance.setMOQ(MOQ);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Drug.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Drug instance = new Drug();
        instance.setQuantity(50);
        int expResult = 50;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Drug.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 50;
        Drug instance = new Drug();
        instance.setQuantity(quantity);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDrugId method, of class Drug.
     */
    @Test
    public void testGetDrugId() {
        System.out.println("getDrugId");
        Drug instance = new Drug();
        instance.setDrugId(1);
        int expResult = 1;
        int result = instance.getDrugId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDrugId method, of class Drug.
     */
    @Test
    public void testSetDrugId() {
        System.out.println("setDrugId");
        int drugId = 0;
        Drug instance = new Drug();
        instance.setDrugId(drugId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSellingPrice method, of class Drug.
     */
    @Test
    public void testGetSellingPrice() {
        System.out.println("getSellingPrice");
        Drug instance = new Drug();
        instance.setSellingPrice(5);
        int expResult = 5;
        int result = instance.getSellingPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSellingPrice method, of class Drug.
     */
    @Test
    public void testSetSellingPrice() {
        System.out.println("setSellingPrice");
        int sellingPrice = 0;
        Drug instance = new Drug();
        instance.setSellingPrice(sellingPrice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
