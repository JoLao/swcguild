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
public class AtFirstTest {
    
    public AtFirstTest() {
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
    public void atFirstTest() {
        AtFirst test = new AtFirst();
        
        //AtFirst("hello") -> "he"
        //AtFirst("hi") -> "hi"
        //AtFirst("h") -> "h@"
        String result = test.AtFirst("hello");
        assertEquals(result, "he");
        
        result = test.AtFirst("hi");
        assertEquals(result, "hi");
        
        
        result = test.AtFirst("h");
        assertEquals(result, "h@");
    }
}
