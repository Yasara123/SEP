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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Nandula
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Logic.DrugTest.class, Logic.securityTest.class, Logic.InventoryControllerTest.class, Logic.EmployeeTest.class, Logic.TransactionControllerTest.class, Logic.LoginControllerTest.class, Logic.FinanceControllerTest.class, Logic.TransactionFinanceTest.class, Logic.SMSTest.class, Logic.supplierTest.class})
public class LogicSuite {

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
