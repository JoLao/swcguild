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
public class IcyHotTest {
    
    public IcyHotTest() {
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
    public void icyHotTest() {
        IcyHot test = new IcyHot();
        
        //IcyHot(120, -1) -> true
        boolean result = test.icyHot(120, -1);
        assertTrue(result);
        
        //IcyHot(-1, 120) -> true
        result = test.icyHot(-1, 120);
        assertTrue(result);
        
        //IcyHot(2, 120) -> false
        result = test.icyHot(2, 120);
        assertFalse(result);
    }
            
}
