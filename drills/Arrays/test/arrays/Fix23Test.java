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
public class Fix23Test {
    
    public Fix23Test() {
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
    public void fix23Test() {
        Fix23 test = new Fix23();
        
        //Fix23({1, 2, 3}) ->{1, 2, 0}
        int[] a = {1, 2, 3};
        a = test.Fix23(a);
        assertEquals(a[0], 1);
        assertEquals(a[1], 2);
        assertEquals(a[2], 0);
        
        //Fix23({2, 3, 5}) -> {2, 0, 5}
        int[] b = {2, 3, 5};
        b = test.Fix23(b);
        assertEquals(b[0], 2);
        assertEquals(b[1], 0);
        assertEquals(b[2], 5);
        
        //Fix23({1, 2, 1}) -> {1, 2, 1}
        int[] c = {1, 2, 1};
        c = test.Fix23(c);
        assertEquals(c[0], 1);
        assertEquals(c[1], 2);
        assertEquals(c[2], 1);

    }
}
