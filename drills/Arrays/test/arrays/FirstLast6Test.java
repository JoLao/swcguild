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
public class FirstLast6Test {
    
    public FirstLast6Test() {
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
    public void firstLast6Test() {
        FirstLast6 test = new FirstLast6();
        
        //FirstLast6({1, 2, 6}) -> true
        //FirstLast6({6, 1, 2, 3}) -> true
        //FirstLast6({13, 6, 1, 2, 3}) -> false
        int[] n1 = {1, 2, 6};
        boolean result = test.firstLast6(n1);
        assertTrue(result);
        
        int[] n2 = {6, 1, 2, 3};
        result = test.firstLast6(n2);
        assertTrue(result);
        
        int[] n3 = {13, 6, 1, 2, 3};
        result = test.firstLast6(n3);
        assertFalse(result);
    }
}
