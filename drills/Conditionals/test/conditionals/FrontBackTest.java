/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

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
public class FrontBackTest {
    
    public FrontBackTest() {
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
    public void frontBackTest() {
        FrontBack test = new FrontBack();
        
        //FrontBack("code") -> "eodc"                
        String s = test.frontBack("code");
        assertEquals(s, "eodc");
        
        //FrontBack("a") -> "a"
        s = test.frontBack("a");
        assertEquals(s, "a");
        
        //FrontBack("ab") -> "ba"
        s = test.frontBack("ab");
        assertEquals(s, "ba");
    }
}
