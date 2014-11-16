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
public class Rotateleft2Test {
    
    public Rotateleft2Test() {
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
    public void rotateleft2Test() {
        Rotateleft2 test = new Rotateleft2();
        
        //Rotateleft2("Hello") -> "lloHe"
        //Rotateleft2("java") -> "vaja"
        //Rotateleft2("Hi") -> "Hi"
        String result = test.rotateleft2("Hello");
        assertEquals(result, "lloHe");
        
        result = test.rotateleft2("java");
        assertEquals(result, "vaja");
        
        
        result = test.rotateleft2("Hi");
        assertEquals(result, "Hi");
    }
}
