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
public class RollDiceTest {
    
    public RollDiceTest() {
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
    public void rollDiceTest() {
        RollDice roll = new RollDice();
        
        //RollDice(2, 3, true) → 5
        int result = roll.rollDice(2, 3, true);
        assertEquals(result, 5);
        
        //RollDice(3, 3, true) → 7
        result = roll.rollDice(3, 3, true);
        assertEquals(result, 7);
        
        //RollDice(3, 3, false) → 6
        result = roll.rollDice(3, 3, false);
        assertEquals(result, 6);
        
        //RollDice(6, 6, true) -> 7
        result = roll.rollDice(6, 6, true);
        assertEquals(result, 7);
    }
}
