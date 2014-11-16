/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

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
public class TakeOneTest {
    
    public TakeOneTest() {
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
    public void takeOneTest() {
        TakeOne test = new TakeOne();
        
        //TakeOne("Hello", true) -> "H"
        //TakeOne("Hello", false) -> "o"
        //TakeOne("oh", true) -> "o"
        String result = test.TakeOne("Hello", true);
        assertEquals(result, "H");
        
        result = test.TakeOne("Hello", false);
        assertEquals(result, "o");
        
        result = test.TakeOne("oh", true);
        assertEquals(result, "o");
    }
}
