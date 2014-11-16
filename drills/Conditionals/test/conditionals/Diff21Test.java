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
public class Diff21Test {
    
    public Diff21Test() {
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
    public void diff21Test() {
        Diff21 test = new Diff21();
        
        //Diff21(23) -> 4
        int result = test.diff21(23);
        assertEquals(result, 4);
        
        //Diff21(10) -> 11
        result = test.diff21(10);
        assertEquals(result, 11);
        
        //Diff21(21) -> 0
        result = test.diff21(21);
        assertEquals(result, 0);
    }
}
