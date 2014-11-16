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
public class TwoIsOneTest {
    
    public TwoIsOneTest() {
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
    public void twoIsOneTest() {
        TwoIsOne num = new TwoIsOne();
        
        //TwoIsOne(1, 2, 3) → true
        boolean result = num.twoIsOne(1, 2, 3);
        assertTrue(result);
        
        //TwoIsOne(3, 1, 2) → true    
        result = num.twoIsOne(3, 1, 2);
        assertTrue(result);
        
        //TwoIsOne(3, 2, 2) → false
        result = num.twoIsOne(3, 2, 2);
        assertFalse(result);
    }
}
