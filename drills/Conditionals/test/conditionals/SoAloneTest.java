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
public class SoAloneTest {
    
    public SoAloneTest() {
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
    public void soAloneTest() {
        SoAlone test = new SoAlone();
        
        //SoAlone(13, 99) -> true
        boolean result = test.soAlone(13, 99);
        assertTrue(result);
        
        //SoAlone(21, 19) -> true
        result = test.soAlone(21, 19);
        assertTrue(result);
        
        //SoAlone(13, 13) -> false
        result = test.soAlone(13, 13);
        assertFalse(result);
        
    }
}
