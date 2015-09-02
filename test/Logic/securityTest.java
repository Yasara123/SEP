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
public class securityTest {
    
    public securityTest() {
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
     * Test of symmetricEncrypt method, of class security.
     */
    @Test
    public void testSymmetricEncrypt() {
        System.out.println("symmetricEncrypt");
        String text = "";
        String secretKey = "";
        String expResult = "";
        String result = security.symmetricEncrypt(text, secretKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of symmetricDecrypt method, of class security.
     */
    @Test
    public void testSymmetricDecrypt() {
        System.out.println("symmetricDecrypt");
        String text = "";
        String secretKey = "";
        String expResult = "";
        String result = security.symmetricDecrypt(text, secretKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
