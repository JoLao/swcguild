/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

import strings.MakeTags;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class MakeTagsTest {
    
    public MakeTagsTest() {
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
    public void makeTagsTest() {
        MakeTags test = new MakeTags();
        
        //MakeTags("i", "Yay") -> "<i>Yay</i>"
        //MakeTags("i", "Hello") -> "<i>Hello</i>"
        //MakeTags("cite", "Yay") -> "<cite>Yay</cite>"
        String result = test.makeTags("i", "Yay");
        assertEquals(result, "<i>Yay</i>");
        
        result = test.makeTags("i", "Hello");
        assertEquals(result, "<i>Hello</i>");
        
        result = test.makeTags("cite", "Yay");
        assertEquals(result, "<cite>Yay</cite>");
    }
}
