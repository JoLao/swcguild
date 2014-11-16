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
public class PlayOutsideTest {
    
    public PlayOutsideTest() {
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
    public void playOutsideTest() {
        PlayOutside playOutside = new PlayOutside();
        
        //PlayOutside(70, false) → true
        boolean canPlay = playOutside.canPlayOutside(70, false);
        assertTrue(canPlay);
        
        //PlayOutside(95, false) → false
        canPlay = playOutside.canPlayOutside(95, false);
        assertFalse(canPlay);
        
        //PlayOutside(95, true) → true
        canPlay = playOutside.canPlayOutside(95, true);
        assertTrue(canPlay);
    }
}
