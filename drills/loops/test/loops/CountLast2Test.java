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
public class CountLast2Test {
    
    public CountLast2Test() {
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
    public void countLast2Test() {
        CountLast2 test = new CountLast2();
        
        //CountLast2("hixxhi") -> 1
        //CountLast2("xaxxaxaxx") -> 1
        //CountLast2("axxxaaxx") -> 2
        int result = test.countLast2("hixxhi");
        assertEquals(result, 1);
        
        result = test.countLast2("xaxxaxaxx");
        assertEquals(result, 1);
        
        result = test.countLast2("axxxaaxx");
        assertEquals(result, 2);
    }
}
