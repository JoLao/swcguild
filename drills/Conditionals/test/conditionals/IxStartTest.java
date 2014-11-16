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
public class IxStartTest {
    
    public IxStartTest() {
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
    public void ixStartTest() {
        IxStart test = new IxStart();
        
        //IxStart("mix snacks") -> true
        boolean result = test.ixStart("mix snacks");
        assertTrue(result);
        
        //IxStart("pix snacks") -> true
        result = test.ixStart("pix snacks");
        assertTrue(result);
        
        //IxStart("piz snacks") -> false
        result = test.ixStart("piz snacks");
        assertFalse(result);
    }
}
