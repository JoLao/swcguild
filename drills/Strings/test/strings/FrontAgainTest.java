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
public class FrontAgainTest {
    
    public FrontAgainTest() {
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
    public void frontAgainTest() {
        FrontAgain test = new FrontAgain();
        
        //FrontAgain("edited") -> true
        //FrontAgain("edit") -> false
        //FrontAgain("ed") -> true
        boolean result = test.frontAgain("edited");
        assertTrue(result);
        
        result = test.frontAgain("edit");
        assertFalse(result);
        
        result = test.frontAgain("ed");
        assertTrue(result);
    }
}
