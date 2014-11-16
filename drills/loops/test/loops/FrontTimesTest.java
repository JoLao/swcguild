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
public class FrontTimesTest {
    
    public FrontTimesTest() {
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
    public void frontTimesTest() {
        FrontTimes test = new FrontTimes();
        
        //FrontTimes("Chocolate", 2) -> "ChoCho"
        //FrontTimes("Chocolate", 3) -> "ChoChoCho"
        //FrontTimes("Abc", 3) -> "AbcAbcAbc"
        String result = test.frontTimes("Chocolate", 2);
        assertEquals(result, "ChoCho");
        
        result = test.frontTimes("Chocolate", 3);
        assertEquals(result, "ChoChoCho");
        
        result = test.frontTimes("Abc", 3);
        assertEquals(result, "AbcAbcAbc");
        
        result = test.frontTimes("Ab", 3);
        assertEquals(result, "AbAbAb");
    }
}
