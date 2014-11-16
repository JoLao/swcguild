/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;

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
public class RotateLeftTest {
    public RotateLeft test = new RotateLeft();
    
    public RotateLeftTest() {
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
    public void rotateLeftTest1() {
                        
        //RotateLeft({1, 2, 3}) -> {2, 3, 1}
        int[] a = {1, 2, 3};
        int[] result = test.rotateLeft(a);
        assertEquals(result[0], 2);
        assertEquals(result[1], 3);
        assertEquals(result[2], 1);     
        
    }
    @Test
    public void rotateLeftTest2() {
        //RotateLeft({5, 11, 9}) -> {11, 9, 5}
        int[] b = {5, 11, 9};
        int[] result = test.rotateLeft(b);
        assertEquals(result[0], 11);
        assertEquals(result[1], 9);
        assertEquals(result[2], 5);
        
    }
    @Test    
    public void rotateLeftTest3() {
        //RotateLeft({7, 0, 0}) -> {0, 0, 7}                
        int[] c = {7, 0, 0};
        int[] result = test.rotateLeft(c);
        assertEquals(result[0], 0);
        assertEquals(result[1], 0);
        assertEquals(result[2], 7);        
    }
}
