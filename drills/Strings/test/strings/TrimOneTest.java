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
public class TrimOneTest {
    
    public TrimOneTest() {
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
    public void trimOneTest() {
        TrimOne test = new TrimOne();
        
        //TrimOne("Hello") -> "ell"
        //TrimOne("java") -> "av"
        //TrimOne("coding") -> "odin"
        String result = test.TrimOne("Hello");
        assertEquals(result, "ell");
        
        result = test.TrimOne("java");
        assertEquals(result, "av");
        
        result = test.TrimOne("coding");
        assertEquals(result, "odin");
    }
}
