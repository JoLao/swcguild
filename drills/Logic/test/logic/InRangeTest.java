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
public class InRangeTest {
    
    public InRangeTest() {
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
    public void inRangeTest() {
        InRange myRange = new InRange();
        
        //InRange(5, false) → true
        boolean result = myRange.inRange(5, false);
        assertTrue(result);
        
        //InRange(11, false) → false
        result = myRange.inRange(11, false);
        assertFalse(result);
        
        //InRange(11, true) → true
        result = myRange.inRange(11, true);
        assertTrue(result);
     
        //InRange(5, true) → false
        result = myRange.inRange(5, true);
        assertFalse(result);
        
    }
}
