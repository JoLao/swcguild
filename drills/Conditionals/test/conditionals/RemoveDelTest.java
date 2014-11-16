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
public class RemoveDelTest {
    
    public RemoveDelTest() {
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
    public void removeDelTest() {
        RemoveDel test = new RemoveDel();
        
        //RemoveDel("adelbc") -> "abc"
        String result = test.removeDel("adelbc");
        assertEquals(result, "abc");
        
        //RemoveDel("adelHello") -> "aHello"
        result = test.removeDel("adelHello");
        assertEquals(result, "aHello");
        
        //RemoveDel("adedbc") -> "adedbc"
        result = test.removeDel("adedbc");
        assertEquals(result, "adedbc");
    }
}
