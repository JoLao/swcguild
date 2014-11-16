/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;

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
public class Double23Test {
    
    public Double23Test() {
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
    public void double23Test() {
        Double23 test = new Double23();
        
        //Double23({2, 2, 3}) -> true
        int[] a = {2, 2, 3};
        boolean result = test.double23(a);
        assertTrue(result);
        
        //Double23({3, 4, 5, 3}) -> true
        int[] b = {3, 4, 5, 3};
        result = test.double23(b);
        assertTrue(result);
        
        //Double23({2, 3, 2, 2}) -> false
        int[] c = {2, 3, 2, 2};
        result = test.double23(c);
        assertFalse(result);
    }
}
