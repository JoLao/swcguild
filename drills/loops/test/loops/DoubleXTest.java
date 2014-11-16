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
public class DoubleXTest {
    
    public DoubleXTest() {
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
    public void doubleXTest() {
        DoubleX test = new DoubleX();
        
        //DoubleX("axxbb") -> true
        //DoubleX("axaxxax") -> false
        //DoubleX("xxxxx") -> true
        boolean result = test.doubleX("axxbb");
        assertTrue(result);
        
        result = test.doubleX("axaxxax");
        assertFalse(result);
        
        result = test.doubleX("xxxxx");
        assertTrue(result);
    }
}
