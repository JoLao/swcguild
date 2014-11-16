/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

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
public class AreInOrderTest {
    
    public AreInOrderTest() {
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
    public void areInOrderTest() {
        AreInOrder num = new AreInOrder();
        
        //AreInOrder(1, 2, 4, false) → true
        boolean result = num.areInOrder(1, 2, 4, false);
        assertTrue(result);
        
        //AreInOrder(1, 2, 1, false) → false
        result = num.areInOrder(1, 2, 1, false);
        assertFalse(result);
        
        //AreInOrder(1, 1, 2, true) → true
        result = num.areInOrder(1, 2, 4, true);
        assertTrue(result);

    }
}
