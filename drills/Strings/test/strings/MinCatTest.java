/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

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
public class MinCatTest {
    
    public MinCatTest() {
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
    public void minCatTest() {
        MinCat test = new MinCat();  

        //MinCat("Hello", "Hi") -> "loHi"
        //MinCat("Hello", "java") -> "ellojava"
        //MinCat("java", "Hello") -> "javaello"
        String result = test.MinCat("Hello", "Hi");
        assertEquals(result, "loHi");
        
        result = test.MinCat("Hello", "java");
        assertEquals(result, "ellojava");
        
        
        result = test.MinCat("java", "Hello");
        assertEquals(result, "javaello");
     }
}
