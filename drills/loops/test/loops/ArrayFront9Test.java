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
public class ArrayFront9Test {
    
    public ArrayFront9Test() {
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
    public void arrayFront9Test() {
        ArrayFront9 test = new ArrayFront9();
        
        //ArrayFront9({1, 2, 9, 3, 4}) -> true
        //ArrayFront9({1, 2, 3, 4, 9}) -> false
        //ArrayFront9({1, 2, 3, 4, 5}) -> false
        int[] numbers = {1, 2, 9, 3, 4};
        boolean result = test.arrayFront9(numbers);
        assertTrue(result);
        
        int[] numbers1 = {1, 2, 3, 4, 9};
        result = test.arrayFront9(numbers1);
        assertFalse(result);
        
    }
}
