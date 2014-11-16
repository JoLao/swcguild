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
public class CanHasTableTest {
    //Eric, I tried this approach, created separate methods, and tried to make one of the
    //conditions fail. It failed but the output doesn't say which one.
    
    CanHazTable canHasTbl;
    
    public CanHasTableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         canHasTbl = new CanHazTable();
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
    public void canHazTableTest1(){
        
        //CanHazTable(5, 10) → 2
        int result = canHasTbl.canHazTable(5, 10);
        assertEquals(result, 2);       
    }
   
    @Test
    public void canHazTableTest2(){
               
        //CanHazTable(5, 2) → 0
        int result = canHasTbl.canHazTable(5, 2);
        assertEquals(result, 0);
                
    }
    
    @Test
    public void canHazTableTest3(){
                  
        //CanHazTable(5, 5) → 1 
        int result = canHasTbl.canHazTable(5, 5);
        assertEquals(result, 1);
    }
}
