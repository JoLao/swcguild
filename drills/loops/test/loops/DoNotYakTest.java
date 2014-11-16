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
public class DoNotYakTest {
    
    public DoNotYakTest() {
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
    public void doNotYakTest() {
        DoNotYak test = new DoNotYak();
        
        //DoNotYak("yakpak") -> "pak"
        //DoNotYak("pakyak") -> "pak"
        //DoNotYak("yak123ya") -> "123ya"
        String result = test.doNotYak("yakpak");
        assertEquals(result, "pak");
        
        result = test.doNotYak("pakyak");
        assertEquals(result, "pak");
        
        result = test.doNotYak("yak123ya");
        assertEquals(result, "123ya");
    }
}
