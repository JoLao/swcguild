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
public class CountXXTest {
    
    public CountXXTest() {
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
    public void countXXTest() {
        CountXX test = new CountXX();
        
        //CountXX("abcxx") -> 1
        //CountXX("xxx") -> 2
        //CountXX("xxxx") -> 3
        int result = test.countXX("abcxx");
        assertEquals(result, 1);
        
        result = test.countXX("xxx");
        assertEquals(result, 2);
        
        result = test.countXX("xxxx");
        assertEquals(result, 3);
    }
}
