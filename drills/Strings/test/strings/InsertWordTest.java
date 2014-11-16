/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

import strings.InsertWord;
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
public class InsertWordTest {
    
    public InsertWordTest() {
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
    public void insertWordTest() {
        InsertWord test = new InsertWord();
        
        //InsertWord("<<>>", "Yay") -> "<<Yay>>"
        //InsertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
        //InsertWord("[[]]", "word") -> "[[word]]"
        String result = test.InsertWord("<<>>", "Yay");
        assertEquals(result, "<<Yay>>");
        
        result = test.InsertWord("<<>>", "WooHoo");
        assertEquals(result, "<<WooHoo>>");
        
        result = test.InsertWord("[[]]", "word");
        assertEquals(result, "[[word]]");
    }
}
