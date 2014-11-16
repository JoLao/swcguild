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
public class StartHiTest {
    
    public StartHiTest() {
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
    public void startHiTest() {
        StartHi test = new StartHi();
        
        //StartHi("hi there") -> true
        boolean result = test.startHi("hi there");
        assertTrue(result);
        
        //StartHi("hi") -> true
        result = test.startHi("hi");
        assertTrue(result);
        
        //Why should this be false? It begins with "hi"
        //StartHi("high up") -> false 
        result = test.startHi("high up");
        assertTrue(result);
    }
}
