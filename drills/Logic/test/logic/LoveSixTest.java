package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class LoveSixTest {
    
    public LoveSixTest() {
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
    public void loveSixTest() {
        LoveSix sum = new LoveSix();
        
        //LoveSix(6, 4) → true
        boolean result = sum.loveSix(6, 4);
        assertTrue(result);
        
        //LoveSix(4, 5) → false
        result = sum.loveSix(4, 5);
        assertFalse(result);
        
        //LoveSix(1, 5) → true
        result = sum.loveSix(1, 5);
        assertTrue(result);
        
        //LoveSix(1, 7) → true
        result = sum.loveSix(1, 7);
        assertTrue(result);
        
    }
}
