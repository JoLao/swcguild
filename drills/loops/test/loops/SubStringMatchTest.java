package loops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import loops.SubStringMatch;
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
public class SubStringMatchTest {
    
    public SubStringMatchTest() {
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
    public void subStringMatchTest() {
        SubStringMatch test = new SubStringMatch();
        
    //SubStringMatch("xxcaazz", "xxbaaz") -> 3
    //SubStringMatch("abc", "abc") -> 2
    //SubStringMatch("abc", "axc") -> 0
        
        int result = test.subStringMatch("xxcaazz", "xxbaaz");
        assertEquals(result, 3);
        
        result = test.subStringMatch("abc", "abc");
        assertEquals(result, 2);
        
         result = test.subStringMatch("abc", "axc");
        assertEquals(result, 0);
    }
}
