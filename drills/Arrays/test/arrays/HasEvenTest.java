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
public class HasEvenTest {
    
    public HasEvenTest() {
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
    public void hasEvenTest() {
        HasEven test = new HasEven();
        
        //HasEven({2, 5}) -> true
        int [] a = {2, 5};
        boolean result = test.hasEven(a);
        assertTrue(result);
        
        //HasEven({4, 3}) -> true
        int [] b = {4, 3};
        result = test.hasEven(b);
        assertTrue(result);
        
        //HasEven({7, 5}) -> false
        int [] c = {7, 5};
        result = test.hasEven(c);
        assertFalse(result);
        
    }
}
