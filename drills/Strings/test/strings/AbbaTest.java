/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

import strings.Abba;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class AbbaTest {
    
    public AbbaTest() {
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
    public void abbaTest() {
        Abba test = new Abba();
        
        //Abba("Hi", "Bye") -> "HiByeByeHi"
        //Abba("Yo", "Alice") -> "YoAliceAliceYo"
        //Abba("What", "Up") -> "WhatUpUpWhat"
        String result = test.abba("Hi", "Bye");
        assertEquals(result, "HiByeByeHi");
        
        result = test.abba("Yo", "Alice");
        assertEquals(result, "YoAliceAliceYo");
        
        result = test.abba("What", "Up");
        assertEquals(result, "WhatUpUpWhat");
    }
}
