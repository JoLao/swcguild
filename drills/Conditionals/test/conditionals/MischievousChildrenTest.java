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
public class MischievousChildrenTest {
    
    public MischievousChildrenTest() {
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
    public void mischievousChildrenTest() {
        MischievousChildren test = new MischievousChildren();
                
        //AreWeInTrouble(true, true) -> true
        boolean result = test.areWeInTrouble(true, true);
        assertTrue(result);
        
        //AreWeInTrouble(false, false) -> true
        result = test.areWeInTrouble(false, false);
        assertTrue(result);
        
        //AreWeInTrouble(true, false) -> false
        result = test.areWeInTrouble(true, false);
        assertFalse(result);
        
    }
    
}
