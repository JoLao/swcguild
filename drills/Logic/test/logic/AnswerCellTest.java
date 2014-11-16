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
public class AnswerCellTest {
    
    public AnswerCellTest() {
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
    public void answerCellTest() {
        AnswerCell ans = new AnswerCell();
        
        //answerCell(boolean shouldAnswer, boolean isMorning, boolean momCalling, boolean isAsleep)
        boolean result = ans.answerCell(true, false, false, false);
        assertTrue(result);
        
        result = ans.answerCell(false, false, false, false);
        assertTrue(result);
        
        result = ans.answerCell(false, true, false, false);
        assertFalse(result);
        
        result = ans.answerCell(false, false, true, false);
        assertTrue(result);
        
        result = ans.answerCell(false, false, false, true);
        assertFalse(result);
    }
}
