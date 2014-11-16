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
public class Array667Test {
    
    public Array667Test() {
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
    public void array667Test() {
        Array667 test = new Array667();
        
        
        //Array667({6, 6, 2}) -> 1
        //Array667({6, 6, 2, 6}) -> 1
        //Array667({6, 7, 2, 6}) -> 1
        int[] numbers = {6, 6, 2};
        int result = test.array667(numbers);
        assertEquals(result, 1);
        
        int[] numbers1 = {6, 6, 2, 6};
        result = test.array667(numbers1);
        assertEquals(result, 1);
        
         int[] numbers2 = {6, 7, 2, 6};
        result = test.array667(numbers2);
        assertEquals(result, 1);
    }
}
