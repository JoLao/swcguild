/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

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
public class SleepingInTest {
    
    public SleepingInTest() {
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
    public void sleepingInTest() {
        SleepingIn test = new SleepingIn();
        
        //sleepIn(false, false) -> true
        boolean result = test.canSleepIn(false, false);
        assertTrue(result);
        
        //sleepIn(true, false) -> false
        result = test.canSleepIn(true, false);
        assertFalse(result);
        
        //sleepIn(false, true) -> true
        result = test.canSleepIn(false, true);
        assertTrue(result);
    }
}
