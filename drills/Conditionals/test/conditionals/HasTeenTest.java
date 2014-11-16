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
public class HasTeenTest {
    
    public HasTeenTest() {
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
    public void hasTeenTest() {
        HasTeen test = new HasTeen();
        
        //HasTeen(13, 20, 10) -> true
        boolean result = test.hasTeen(13, 20, 10);
        assertTrue(result);
        
        //HasTeen(20, 19, 10) -> true
        result = test.hasTeen(20, 19, 10);
        assertTrue(result);
        
        //HasTeen(20, 10, 12) -> false
        result = test.hasTeen(20, 10, 12);
        assertFalse(result);
        
    }
}
