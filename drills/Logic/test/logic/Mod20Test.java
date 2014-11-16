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
public class Mod20Test {
    
    public Mod20Test() {
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
    public void mod20Test() {
        Mod20 num = new Mod20();
        
        //Mod20(20) → false
        boolean result = num.mod20(20);
        assertFalse(result);
        
        //Mod20(21) → true
        result = num.mod20(21);
        assertTrue(result);
        
        //Mod20(22) → true
        result = num.mod20(22);
        assertTrue(result);
        
        //Mod20(-21) -> false
        result = num.mod20(-21);
        assertFalse(result);
        
    }
}
