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
public class PosNegTest {
    
    public PosNegTest() {
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
    public void posNegTest() {
        PosNeg test = new PosNeg();
        
        //PosNeg(1, -1, false) -> true
        boolean result = test.posNeg(1, -1, false);
        assertTrue(result);
        
        //PosNeg(-1, 1, false) -> true
        result = test.posNeg(-1, 1, false);
        assertTrue(result);
        
        //PosNeg(-4, -5, true) -> true
        result = test.posNeg(-4, -5, true);
        assertTrue(result);
        
        result = test.posNeg(-4, -5, false);
        assertFalse(result);
    }
}
