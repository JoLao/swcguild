/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class FirstHalfTest {
    
    public FirstHalfTest() {
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
    public void firstHalfTest() {
        FirstHalf test = new FirstHalf();
        
        //FirstHalf("WooHoo") -> "Woo"
        //FirstHalf("HelloThere") -> "Hello"
        //FirstHalf("abcdef") -> "abc"
        String result = test.firstHalf("WooHoo");
        assertEquals(result, "Woo");
        
        result = test.firstHalf("HelloThere");
        assertEquals(result, "Hello");
        
        result = test.firstHalf("abcdef");
        assertEquals(result, "abc");
    }
}
