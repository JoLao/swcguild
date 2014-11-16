/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class GreatPartyTest {

    public GreatPartyTest() {
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
    public void greatPartyTest() {
        GreatParty myParty = new GreatParty();

        //GreatParty(30, false) → false
        boolean result = myParty.greatParty(30, false);
        assertFalse(result);     //tells JUnit expected result should be false
        
        //GreatParty(50, false) → true
        result = myParty.greatParty(50, false);
        assertTrue(result);
        
        //GreatParty(70, true) → true    
        result = myParty.greatParty(70, true);
        assertTrue(result);
    }
}
