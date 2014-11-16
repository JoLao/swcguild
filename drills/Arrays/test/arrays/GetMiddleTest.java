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
public class GetMiddleTest {
    
    public GetMiddleTest() {
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
    public void getMiddleTest() {
        GetMiddle test = new GetMiddle();
        
        //GetMiddle({1, 2, 3}, {4, 5, 6}) -> {2, 5}
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] result = test.getMiddle(a, b);
        assertEquals(result[0], a[1]);
        assertEquals(result[1], b[1]);
        
        //GetMiddle({7, 7, 7}, {3, 8, 0}) -> {7, 8}
        int[] c = {7, 7, 7};
        int[] d = {3, 8, 0};
        assertEquals(result[0], c[1]);
        assertEquals(result[1], d[1]);
                
        //GetMiddle({5, 2, 9}, {1, 4, 5}) -> {2, 4}
        int[] e = {5, 2, 9};
        int[] f = {1, 4, 5};
        assertEquals(result[0], e[1]);
        assertEquals(result[1], f[1]);
        
    }
}
