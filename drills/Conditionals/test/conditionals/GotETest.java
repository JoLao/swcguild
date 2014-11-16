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
public class GotETest {
    
    public GotETest() {
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
    public void gotETest() {
        GotE test = new GotE();
        
        //GotE("Hello") -> true
        //GotE("Heelle") -> true
        //GotE("Heelele") -> false
        
        boolean result = test.gotE("Hello");
        assertTrue(result);
        
        result = test.gotE("Heelle");
        assertTrue(result);
        
        result = test.gotE("Heelele");
        assertFalse(result);
    }
}
