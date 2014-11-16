/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loops;

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
public class EveryOtherTest {
    
    public EveryOtherTest() {
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
    public void everyOtherTest() {
        EveryOther test = new EveryOther();
        
        //EveryOther("Hello") -> "Hlo"
        //EveryOther("Hi") -> "H"
        //EveryOther("Heeololeo") -> "Hello"
        String result = test.everyOther("Hello");
        assertEquals(result, "Hlo");
        
        result = test.everyOther("Hi");
        assertEquals(result, "H");
        
        result = test.everyOther("Heeololeo");
        assertEquals(result, "Hello");
    }
}
