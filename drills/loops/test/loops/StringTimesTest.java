/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loops;

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
public class StringTimesTest {
    
    public StringTimesTest() {
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
    public void stringTimesTest() {
        StringTimes test = new StringTimes();
        
        //StringTimes("Hi", 2) -> "HiHi"
        //StringTimes("Hi", 3) -> "HiHiHi"
        //StringTimes("Hi", 1) -> "Hi"
        String result = test.stringTimes("Hi", 2);
        assertEquals(result, "HiHi");
        
        result = test.stringTimes("Hi", 3);
        assertEquals(result, "HiHiHi");

        result = test.stringTimes("Hi", 1);
        assertEquals(result, "Hi");

    }
}
