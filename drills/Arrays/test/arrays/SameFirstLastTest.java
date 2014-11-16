package arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SameFirstLastTest {
    
    public SameFirstLastTest() {
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
    public void sameFirstLastTest() {
        SameFirstLast test = new SameFirstLast();
        
        //SameFirstLast({1, 2, 3}) -> false
        int num1[] = {1, 2, 3};
        boolean result = test.sameFirstLast(num1);
        assertFalse(result);
        
        //SameFirstLast({1, 2, 3, 1}) -> true
        int num2[] = {1, 2, 3, 1};
        result = test.sameFirstLast(num2);
        assertTrue(result);
        
        //SameFirstLast({1, 2, 1}) -> true
        int num3[] = {1, 2, 1};
        result = test.sameFirstLast(num3);
        assertTrue(result);

    }
}
