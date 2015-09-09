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
public class FinanceControllerTest {
    
    public FinanceControllerTest() {
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
     * Test of addEmployee method, of class FinanceController.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        String uname = "";
        String pword = "";
        Employee emp = null;
        FinanceController instance = new FinanceController();
        boolean expResult = false;
        boolean result = instance.addEmployee(uname, pword, emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadEmp method, of class FinanceController.
     */
    @Test
    public void testLoadEmp() {
        System.out.println("loadEmp");
        FinanceController instance = new FinanceController();
        instance.loadEmp();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadrem method, of class FinanceController.
     */
    @Test
    public void testLoadrem() {
        System.out.println("loadrem");
        FinanceController instance = new FinanceController();
        instance.loadrem();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployees method, of class FinanceController.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        FinanceController instance = new FinanceController();
        instance.getEmployees();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of removeEmp method, of class FinanceController.
     */
    @Test
    public void testRemoveEmp() {
        System.out.println("removeEmp");
        int id = 0;
        FinanceController instance = new FinanceController();
        boolean expResult = false;
        boolean result = instance.removeEmp(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadSalary method, of class FinanceController.
     */
    @Test
    public void testLoadSalary() {
        System.out.println("loadSalary");
        FinanceController instance = new FinanceController();
        instance.loadSalary();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadChartwindow method, of class FinanceController.
     */
    @Test
    public void testLoadChartwindow() {
        System.out.println("loadChartwindow");
        FinanceController instance = new FinanceController();
        instance.loadChartwindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payments method, of class FinanceController.
     */
    @Test
    public void testPayments() {
        System.out.println("payments");
        FinanceController instance = new FinanceController();
        int[] expResult = null;
        int[] result = instance.payments();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recordPayment method, of class FinanceController.
     */
    @Test
    public void testRecordPayment() {
        System.out.println("recordPayment");
        int total = 0;
        FinanceController instance = new FinanceController();
        boolean expResult = false;
        boolean result = instance.recordPayment(total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFinacialRecords method, of class FinanceController.
     */
    @Test
    public void testGetFinacialRecords() {
        System.out.println("getFinacialRecords");
        String date = "";
        FinanceController instance = new FinanceController();
        int[] expResult = null;
        int[] result = instance.getFinacialRecords(date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCostPieChart method, of class FinanceController.
     */
    @Test
    public void testDrawCostPieChart() {
        System.out.println("drawCostPieChart");
        String date = "";
        FinanceController instance = new FinanceController();
        instance.drawCostPieChart(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawProfitChart method, of class FinanceController.
     */
    @Test
    public void testDrawProfitChart() {
        System.out.println("drawProfitChart");
        String date = "";
        FinanceController instance = new FinanceController();
        instance.drawProfitChart(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
