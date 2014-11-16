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
public class Unlukcy1Test {
    
    public Unlukcy1Test() {
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
    public void unluckyTest() {
        Unlucky1 test = new Unlucky1();
        
        //Unlucky1({1, 3, 4, 5}) -> true
        int[] a = {1, 3, 4, 5};
        boolean result = test.unlucky1(a);
        assertTrue(result);
                
        //Unlucky1({2, 1, 3, 4, 5}) -> true
        int[] b = {2, 1, 3, 4, 5};
        result = test.unlucky1(b);
        assertTrue(result);
        
        //Unlucky1({1, 1, 1}) -> false
         int[] c = {1, 1, 1};
        result = test.unlucky1(c);
        assertFalse(result);
    }
}
