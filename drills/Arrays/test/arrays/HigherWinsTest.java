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
public class HigherWinsTest {
    
    public HigherWinsTest() {
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
    public void higherWinsTest() {
        HigherWins test = new HigherWins();
        
        //HigherWins({1, 2, 3}) -> {3, 3, 3}
        int[] a = {1, 2, 3};
        int[] result = test.higherWins(a);
        assertEquals(a[0], 3);
        assertEquals(a[1], 3);
        assertEquals(a[2], 3);
        
        //HigherWins({11, 5, 9}) -> {11, 11, 11}
        int[] b = {11, 5, 9};
        result = test.higherWins(b);
        assertEquals(b[0], 11);
        assertEquals(b[1], 11);
        assertEquals(b[2], 11);
        
        //HigherWins({2, 11, 3}) -> {3, 3, 3}
        int[] c = {2, 11, 3};
        result = test.higherWins(c);
        assertEquals(c[0], 3);
        assertEquals(c[1], 3);
        assertEquals(c[2], 3);
    }
}
