/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

import strings.MultipleEndings;
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
public class MultipleEndingsTest {
    
    public MultipleEndingsTest() {
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
    public void multipleEndingsTest() {
        MultipleEndings test = new MultipleEndings();
        
        //MultipleEndings("Hello") -> "lololo"
        //MultipleEndings("ab") -> "ababab"
        //MultipleEndings("Hi") -> "HiHiHi"
        String result = test.multipleEndings("Hello");
        assertEquals(result, "lololo");
        
        result = test.multipleEndings("ab");
        assertEquals(result, "ababab");
        
        result = test.multipleEndings("Hi");
        assertEquals(result, "HiHiHi");
    }
}
