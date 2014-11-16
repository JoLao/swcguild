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
public class MissingCharTest {
    
    public MissingCharTest() {
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
    public void missingCharTest() {
        MissingChar test = new MissingChar();
        
        //MissingChar("kitten", 1) -> "ktten"
        String result = test.missingChar("kitten", 1);
        assertEquals(result, "ktten");
        
        //MissingChar("kitten", 0) -> "itten"
        result = test.missingChar("kitten", 0);
        assertEquals(result, "itten");
        
        //MissingChar("kitten", 4) -> "kittn"
        result = test.missingChar("kitten", 4);
        assertEquals(result, "kittn");
    }
}
