/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

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
public class Multiple3or5Test {
    
    public Multiple3or5Test() {
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
    public void multiple3or5Test() {
        Multiple3or5 test = new Multiple3or5();
        
        //Multiple3or5(3) -> true
        boolean result = test.multiple3or5(3);
        assertTrue(result);
        
        //Multiple3or5(10) -> true
        result = test.multiple3or5(10);
        assertTrue(result);
        
        //Multiple3or5(8) -> false
        result = test.multiple3or5(8);
        assertFalse(result);
        
    }
}
