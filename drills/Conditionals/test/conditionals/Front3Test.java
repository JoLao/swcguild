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
public class Front3Test {
    
    public Front3Test() {
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
    public void front3Test() {
        Front3 test = new Front3();
        
        //Front3("Microsoft") -> "MicMicMic"
        String result = test.front3("Microsoft");
        assertEquals(result, "MicMicMic");
        
        //Front3("Chocolate") -> "ChoChoCho"
        result = test.front3("Chocolate");
        assertEquals(result, "ChoChoCho");
        
        //Front3("at") -> "atatat"
        result = test.front3("at");
        assertEquals(result, "atatat");
        
    }
}
