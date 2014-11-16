package strings;

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
public class ConCatTest {
    
    public ConCatTest() {
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
    public void conCatTest() {
        ConCat test = new ConCat();
        
        //ConCat("abc", "cat") -> "abcat"
        //ConCat("dog", "cat") -> "dogcat"
        //ConCat("abc", "") -> "abc"
        String result = test.conCat("abc", "cat");
        assertEquals(result, "abcat");
        
        result = test.conCat("dog", "cat");
        assertEquals(result, "dogcat");
        
        result = test.conCat("abc", "");
        assertEquals(result, "abc");
    }
}
