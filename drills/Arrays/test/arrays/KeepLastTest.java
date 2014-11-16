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
public class KeepLastTest {
    
    public KeepLastTest() {
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
    public void keepLastTest() {
        KeepLast test = new KeepLast();
        
        //KeepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
        int[] a      = {4, 5, 6};
        int[] result = test.keepLast(a);
        assertEquals(result[0], 0);
        assertEquals(result[1], 0);
        assertEquals(result[2], 0);
        assertEquals(result[3], 0);
        assertEquals(result[4], 0);
        assertEquals(result[5], 6);
        
        //KeepLast({1, 2}) -> {0, 0, 0, 2}
        int[] b   = {1, 2};
        result    = test.keepLast(b);
        assertEquals(result[0], 0);
        assertEquals(result[1], 0);
        assertEquals(result[2], 0);
        assertEquals(result[3], 2);        
        
        //KeepLast({3}) -> {0, 3}
        int[] c   = {3};
        result    = test.keepLast(c);
        assertEquals(result[0], 0);
        assertEquals(result[1], 3);
  
    }
}
