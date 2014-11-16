/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

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
public class SkipSumTest {
    
    public SkipSumTest() {
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
    public void skipSumTest() {
        SkipSum sum1 = new SkipSum();
        //SkipSum(3, 4) → 7
        int total = sum1.doASkipSum(3, 4);
        assertEquals(total, 7);
        
        //SkipSum(9, 4) → 20
        total = sum1.doASkipSum(9, 4);
        assertEquals(total, 20);

        //SkipSum(10, 11) → 21
        total = sum1.doASkipSum(10, 11);
        assertEquals(total, 21);

    }
}
