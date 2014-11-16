package conditionals;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Make10Test {
    
    public Make10Test() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void make10Test() {
        Make10 test = new Make10();
        
        //Makes10(9, 10) -> true
        boolean result = test.makes10(9, 10);
        assertTrue(result);
        
        //Makes10(9, 9) -> false
        result = test.makes10(9, 9);
        assertFalse(result);
        
        //Makes10(1, 9) -> true
        result = test.makes10(1, 10);
        assertTrue(result);
    }
}
