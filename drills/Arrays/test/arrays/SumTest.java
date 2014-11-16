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
public class SumTest {
    
    public SumTest() {
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
    public void sumTest() {
        Sum test = new Sum();
        
        //Sum({1, 2, 3}) -> 6
        int[] a = {1, 2, 3};
        int total = test.Sum(a);
        assertEquals(total, 6);

        //Sum({5, 11, 2}) -> 18
        int[] b = {5, 11, 2};
        total = test.Sum(b);
        assertEquals(total, 18);

        //Sum({7, 0, 0}) -> 7
        int[] c = {7, 0, 0};
        total = test.Sum(c);
        assertEquals(total, 7);
        
    }
}
