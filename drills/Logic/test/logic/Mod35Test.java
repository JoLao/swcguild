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
public class Mod35Test {
    
    public Mod35Test() {
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
    public void mod35Test() {
        Mod35 num = new Mod35();
        //Mod35(3) → true
        boolean result = num.mod35(3);
        assertTrue(result);
        
        //Mod35(10) → true
        result = num.mod35(10);
        assertTrue(result);
        
        //Mod35(15) → false
        result = num.mod35(15);
        assertFalse(result);
    }
}
