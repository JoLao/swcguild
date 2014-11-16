package arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ReverseTest {
    
    public ReverseTest() {
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
    public void reverseTest() {
        Reverse test = new Reverse();
        
        int[] a = {1, 2, 3};
        int[] b = test.reverse(a);
        assertEquals(b[0], 3);
        assertEquals(b[1], 2);
        assertEquals(b[2], 1);
        
        int[] c = {1, 2, 3, 4};
        int[] d = test.reverse(c);
        assertEquals(d[0], 4);
        assertEquals(d[1], 3);
        assertEquals(d[2], 2);
        assertEquals(d[3], 1);
    }
}
