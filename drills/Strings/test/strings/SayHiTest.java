package strings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SayHiTest {
    
    public SayHiTest() {
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
    public void sayHiTest() {
        SayHi test = new SayHi();
        
        //SayHi("Bob") -> "Hello Bob!"
        //SayHi("Alice") -> "Hello Alice!"
        //SayHi("X") -> "Hello X!"
        String result = test.sayHi("Bob");
        assertEquals(result, "Hello Bob!");
        
        result = test.sayHi("Alice");
        assertEquals(result, "Hello Alice!");
        
        result = test.sayHi("X");
        assertEquals(result, "Hello X!");
    }
}
