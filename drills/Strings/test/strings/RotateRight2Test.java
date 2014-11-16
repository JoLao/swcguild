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
public class RotateRight2Test {
    
    public RotateRight2Test() {
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
    public void rotateRight2Test() {
        RotateRight2 test = new RotateRight2();
//RotateRight2("Hello") -> "loHel"
//RotateRight2("java") -> "vaja"
//RotateRight2("Hi") -> "Hi"
        String result = test.rotateRight2("Hello");
        assertEquals(result, "loHel");
        
        result = test.rotateRight2("java");
        assertEquals(result, "vaja");
        
        result = test.rotateRight2("Hi");
        assertEquals(result, "Hi");
    }
}
