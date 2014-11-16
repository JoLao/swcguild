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
public class StringSplosionTest {
    
    public StringSplosionTest() {
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
    public void stringSplosionTest() {
        StringSplosion test = new StringSplosion();
        
        //StringSplosion("Code") -> "CCoCodCode"
        //StringSplosion("abc") -> "aababc"
        //StringSplosion("ab") -> "aab"
        
        String result = test.stringSplosion("Code");
        assertEquals(result, "CCoCodCode");
        
        result = test.stringSplosion("abc");
        assertEquals(result, "aababc");
        
        result = test.stringSplosion("ab");
        assertEquals(result, "aab");
        
    }
}
