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
public class TakeTwoFromPositionTest {
    
    public TakeTwoFromPositionTest() {
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
    public void takeTwoFromPositionTest() {
        TakeTwoFromPosition test = new TakeTwoFromPosition();
        
        //TakeTwoFromPosition("java", 0) -> "ja"
        //TakeTwoFromPosition("java", 2) -> "va"
        //TakeTwoFromPosition("java", 3) -> "ja"
        String result = test.takeTwoFromPosition("java", 0);
        assertEquals(result, "ja");
        
        result = test.takeTwoFromPosition("java", 2);
        assertEquals(result, "va");
        
        result = test.takeTwoFromPosition("java", 3);
        assertEquals(result, "ja");
        
        result = test.takeTwoFromPosition("happily", 5);
        assertEquals(result, "ly");
    }
}
