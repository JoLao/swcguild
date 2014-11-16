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
public class CommonEndTest {
    
    public CommonEndTest() {
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
    public void commonEndTest() {
        CommonEnd test = new CommonEnd();
        
        //CommonEnd({1, 2, 3}, {7, 3}) -> true
        int[] a = {1, 2, 3};
        int[] b = {7, 3};
        boolean result = test.commonEnd(a, b);
        assertTrue(result);
                
        //CommonEnd({1, 2, 3}, {7, 3, 2}) -> false
        int[] c = {1, 2, 3};
        int[] d = {7, 3, 2};
        result = test.commonEnd(c, d);
        assertFalse(result);
        
        //CommonEnd({1, 2, 3}, {1, 3}) -> true
        int[] e = {1, 2, 3};
        int[] f = {1, 3};
        result = test.commonEnd(e, f);
        assertTrue(result);
    }
}
