/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alberto
 */
public class inicioTest {
    
    public inicioTest() {
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
     * Test of suma method, of class inicio.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        Calculadora instance = new Calculadora();
        int expResult = 0;
        int result = (int) instance.suma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaserie method, of class inicio.
     */
    @Test
    public void testSumaserie() {
        System.out.println("sumaserie");
        Calculadora instance = new Calculadora();
        float expResult = 0.0F;
        float result = instance.sumaserie();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class inicio.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculadora.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
