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
public class SpecialElevenTest {

    public SpecialElevenTest() {
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
    public void specialElevenTet() {
        SpecialEleven num = new SpecialEleven();

        //SpecialEleven(22) → true
        boolean result = num.specialEleven(22);
        assertTrue(result);               

        //SpecialEleven(23) → true
        result = num.specialEleven(23);
        assertTrue(result);
        
        //SpecialEleven(24) → false
        result = num.specialEleven(24);
        assertFalse(result);
    }
}
