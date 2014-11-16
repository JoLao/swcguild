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
public class Pattern51Test {
    
    public Pattern51Test() {
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
    public void pattern51Test() {
        Pattern51 test = new Pattern51();
        
        //Pattern51({1, 2, 7, 1}) -> true
        //Pattern51({1, 2, 8, 1}) -> false
        //Pattern51({2, 7, 1}) -> true
        int[] numbers = {1, 2, 7, 1};
        boolean result = test.pattern51(numbers);
        assertTrue(result);
        
        int[] numbers1 = {1, 2, 8, 1};
        result = test.pattern51(numbers1);
        assertFalse(result);
        
        int[] numbers2= {2, 7, 1};
        result = test.pattern51(numbers2);
        assertTrue(result);
    }


}
