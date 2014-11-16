package loops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import loops.NoTriples;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class NoTriplesTest {
    
    public NoTriplesTest() {
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
    public void noTriplesTest() {
        NoTriples test = new NoTriples();
        
        //NoTriples({1, 1, 2, 2, 1}) -> true
        //NoTriples({1, 1, 2, 2, 2, 1}) -> false
        //NoTriples({1, 1, 1, 2, 2, 2, 1}) -> false
        int[] numbers = {1, 1, 2, 2, 1};
        boolean result = test.noTriples(numbers);
        assertTrue(result);
        
        int[] numbers1 = {1, 1, 2, 2, 2, 1};
        result = test.noTriples(numbers1);
        assertFalse(result);
        
        int[] numbers2 = {1, 1, 1, 2, 2, 2, 1};
        result = test.noTriples(numbers2);
        assertFalse(result);
    }
}
