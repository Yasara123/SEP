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
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of log method, of class LoginController.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        String uname = "";
        String password = "";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.log(uname, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class LoginController.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        LoginController instance = new LoginController();
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
