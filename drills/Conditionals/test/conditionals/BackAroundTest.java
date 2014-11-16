/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

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
public class BackAroundTest {
    
    public BackAroundTest() {
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
    public void backAroundTest() {
        BackAround test = new BackAround();
        
        //BackAround("cat") -> "tcatt"
        String result = test.backAround("cat");
        assertEquals(result, "tcatt" );
        
        //BackAround("Hello") -> "oHelloo"
        result = test.backAround("Hello");
        assertEquals(result, "oHelloo" );
        
        //BackAround("a") -> "aaa"
        result = test.backAround("a");
        assertEquals(result, "aaa" );
        
        
    }
}
