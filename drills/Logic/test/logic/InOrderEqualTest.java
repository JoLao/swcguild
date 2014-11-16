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
public class InOrderEqualTest {
    
    public InOrderEqualTest() {
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
    public void inOrderEqaulTest() {
        InOrderEqual num = new InOrderEqual();
        
        //InOrderEqual(2, 5, 11, false) → true
        boolean result = num.inOrderEqual(2, 5, 11, false);
        assertTrue(result);
        
        //InOrderEqual(5, 7, 6, false) → false
        result = num.inOrderEqual(5, 7, 6, false);
        assertFalse(result);
        
        //InOrderEqual(5, 5, 7, true) → true
        result = num.inOrderEqual(5, 5, 7, true);
        assertTrue(result);
        
        //InOrderEqual(5, 5, 5, true) → true
        result = num.inOrderEqual(5, 5, 5, true);
        assertTrue(result);
    }
}
