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
public class EndUpTest {
    
    public EndUpTest() {
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
    public void endUpTest() {
        EndUp test = new EndUp();
        //EndUp("Hello") -> "HeLLO"
        //EndUp("hi there") -> "hi thERE"
        //EndUp("hi") -> "HI"
        
        String result = test.endUp("Hello");
        assertEquals(result, "HeLLO");
        
        result = test.endUp("hi there");
        assertEquals(result, "hi thERE");
        
        result = test.endUp("hi");
        assertEquals(result, "HI");
    }
}
