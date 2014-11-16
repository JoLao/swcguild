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
public class AltPairsTest {
    
    public AltPairsTest() {
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
    public void altPairsTest() {
        AltPairs test = new AltPairs();
        
//AltPairs("kitten") -> "kien"
//AltPairs("Chocolate") -> "Chole"
//AltPairs("CodingHorror") -> "Congrr"
        String result = test.altPairs("kitten");
        assertEquals(result, "kien");
        
        result = test.altPairs("Chocolate");
        assertEquals(result, "Chole");
        
        result = test.altPairs("CodingHorror");
        assertEquals(result, "Congrr");
    }
}
