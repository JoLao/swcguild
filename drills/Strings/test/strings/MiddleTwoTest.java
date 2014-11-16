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
public class MiddleTwoTest {
    
    public MiddleTwoTest() {
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
    public void middleTwoTest() {
        MiddleTwo test = new MiddleTwo();
        
        //MiddleTwo("String") -> "ri"
        //MiddleTwo("code") -> "od"
        //MiddleTwo("Practice") -> "ct"
        String result = test.MiddleTwo("String");
        assertEquals(result, "ri");
        
        result = test.MiddleTwo("code");
        assertEquals(result, "od");
        
        
        result = test.MiddleTwo("Practice");
        assertEquals(result, "ct");
    }
}
