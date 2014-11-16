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
public class AlarmClockTest {
    
    public AlarmClockTest() {
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
    public void alarmClockTest() {
        AlarmClock myClock = new AlarmClock();
        
        //AlarmClock(1, false) → "7:00"
        String clock = myClock.ringAlarmClock(1, false);
        assertEquals(clock, "7:00");
        
        //AlarmClock(5, false) → "7:00"
        clock = myClock.ringAlarmClock(5, false);
        assertEquals(clock, "7:00");
        
        //AlarmClock(0, false) → "10:00"
        clock = myClock.ringAlarmClock(0, false);
        assertEquals(clock, "10:00");
        
        //AlarmClock(0, false) → "10:00"
        clock = myClock.ringAlarmClock(6, true);
        assertEquals(clock, "off");
        
         //AlarmClock(2, false) → "10:00"
        clock = myClock.ringAlarmClock(2, true);
        assertEquals(clock, "10:00");
    }
}
