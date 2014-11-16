package conditionals;

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
public class SumTest {
    
    public SumTest() {
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
    public void sumDoubleTest() {
        SumDouble test = new SumDouble();
        
        //SumDouble(1, 2) -> 3
        int sum = test.sumDouble(1, 2);
        assertEquals(sum, 3);
        
        //SumDouble(3, 2) -> 5
        sum = test.sumDouble(3, 2);
        assertEquals(sum, 5);
        
        //SumDouble(2, 2) -> 8
        sum = test.sumDouble(2, 2);
        assertEquals(sum, 8);
    }
}
