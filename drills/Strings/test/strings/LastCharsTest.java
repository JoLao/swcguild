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
public class LastCharsTest {
    
    public LastCharsTest() {
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
    public void lastCharsTest() {
        LastChars test = new LastChars();
        
        //LastChars("last", "chars") -> "ls"
        //LastChars("yo", "mama") -> "ya"
        //LastChars("hi", "") -> "h@"
        String result = test.lastChars("last", "chars");
        assertEquals(result, "ls");
        
        result = test.lastChars("yo", "mama");
        assertEquals(result, "ya");        
        
        result = test.lastChars("hi", "");
        assertEquals(result, "h@");
    }
}
