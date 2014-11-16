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
public class LastDigitTets {
    
    public LastDigitTets() {
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
    public void lastDigitTest() {
        LastDigit num = new LastDigit();
        
        //LastDigit(23, 19, 13) → true
        boolean result = num.lastDigit(23, 19, 13);
        assertTrue(result);
        
        //LastDigit(23, 19, 12) → false
        result = num.lastDigit(23, 19, 12);
        assertFalse(result);
        
        //LastDigit(23, 19, 3) → true
        result = num.lastDigit(23, 19, 3);
        assertTrue(result);
    }
}
