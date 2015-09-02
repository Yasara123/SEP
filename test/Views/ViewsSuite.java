/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Nandula
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Views.LoginTest.class, Views.ManagerTest.class, Views.ChartsTest.class, Views.UpdateDrugTest.class, Views.ReorderTest.class, Views.EmpDetailsTest.class, Views.InventoryTest.class, Views.RemoveEmpTest.class, Views.AddDrugTest.class, Views.FinanceTest.class, Views.TransactionTest.class, Views.RemoveDrugTest.class, Views.SalaryPaymentTest.class})
public class ViewsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
