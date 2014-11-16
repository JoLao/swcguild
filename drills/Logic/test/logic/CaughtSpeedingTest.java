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
public class CaughtSpeedingTest {
    
    public CaughtSpeedingTest() {
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
    public void caughtSpeedingTest() {
        CaughtSpeeding mySpeed = new CaughtSpeeding();
        
        //CaughtSpeeding(60, false) → 0
        int ticket = mySpeed.caughtSpeeding(60, false);
        assertEquals(ticket, 0);
        
        //CaughtSpeeding(65, false) → 1
        ticket = mySpeed.caughtSpeeding(65, false);
        assertEquals(ticket, 1);
        
        //CaughtSpeeding(65, true) → 0
        ticket = mySpeed.caughtSpeeding(65, true);
        assertEquals(ticket, 0);
        
        //CaughtSpeeding(90, true) → 2
        ticket = mySpeed.caughtSpeeding(90, false);
        assertEquals(ticket, 2);
        
        //CaughtSpeeding(90, true) → 0
        ticket = mySpeed.caughtSpeeding(90, true);
        assertEquals(ticket, 0);
    }
}
