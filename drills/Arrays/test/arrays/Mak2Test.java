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
public class Mak2Test {
    
    public Mak2Test() {
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
    public void make2Test() {
        Make2 test = new Make2();
        
        //Make2({4, 5}, {1, 2, 3}) -> {4, 5}
        int[] a = {4, 5};
        int[] b = {1, 2, 3};
        int[] c = test.make2(a, b);
        assertEquals(c[0], 4);
        assertEquals(c[1], 5);
                
        //Make2({4}, {1, 2, 3}) -> {4, 1}
        int[] d = {4};
        int[] e = {1, 2, 3};
        c = test.make2(d, e);
        assertEquals(c[0], 4);
        assertEquals(c[1], 1);
        
        //Make2({}, {1, 2}) -> {1, 2}
        int[] f = {};
        int[] g = {1, 2};
        c = test.make2(f, g);
        assertEquals(c[0], 1);
        assertEquals(c[1], 2);
    }
}
