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
public class Count9Test {
    
    public Count9Test() {
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
    public void count9Test() {
        Count9 test = new Count9();
        
        //Count9({1, 2, 9}) -> 1
        //Count9({1, 9, 9}) -> 2
        //Count9({1, 9, 9, 3, 9}) -> 3    
        
        int[] numbers = {1, 2, 9};
        int result = test.count9(numbers);
        assertEquals(result, 1);
        
        int[] numbers1 = {1, 9, 9};
        result = test.count9(numbers1);
        assertEquals(result, 2);
        
        int[] numbers2 = {1, 9, 9, 3, 9};
        result = test.count9(numbers2);
        assertEquals(result, 3);
    }
}
