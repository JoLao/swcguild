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
public class StringXTest {
    
    public StringXTest() {
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
    public void stringXTest() {
        StringX test = new StringX();
        
        //StringX("xxHxix") -> "xHix"
        //StringX("abxxxcd") -> "abcd"
        //StringX("xabxxxcdx") -> "xabcdx"
        
        String result = test.stringX("xxHxix");
        assertEquals(result, "xHix");
        
        result = test.stringX("abxxxcd");
        assertEquals(result, "abcd");
        
        result = test.stringX("xabxxxcdx");
        assertEquals(result, "xabcdx");
    }
}
