/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

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
public class FrontAndBackTest {
    
    public FrontAndBackTest() {
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
    public void frontAndBackTest() {
        FrontAndBack test = new FrontAndBack();
        
        //FrontAndBack("Hello", 2) -> "Helo"
        //FrontAndBack("Chocolate", 3) -> "Choate"
        //FrontAndBack("Chocolate", 1) -> "Ce"
        String result = test.frontAndBack("Hello", 2);
        assertEquals(result, "Helo");
        
        result = test.frontAndBack("Chocolate", 3);
        assertEquals(result, "Choate");
        
        
        result = test.frontAndBack("Chocolate", 1);
        assertEquals(result, "Ce");
    }
}
