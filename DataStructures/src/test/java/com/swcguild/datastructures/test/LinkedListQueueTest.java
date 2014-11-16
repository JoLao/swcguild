/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.test;

import com.swcguild.datastructures.ArrayQueue;
import com.swcguild.datastructures.LinkedListQueue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class LinkedListQueueTest {
    LinkedListQueue q = new LinkedListQueue();
    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";
    String f = "f";
    String[] strArray = {"a", "b", "c", "d"};
    String[] strArray1 =  {"b", "c", "d"};
    String[] strArray2 =  {"b", "c", "d", "e", "f"};
    String[] strArray3 =  {"b", "c", "d", "e", "f"};
    String[] strArray4 =  {"d", "e", "f", "g", "h", "i"};
    boolean result;
    
    public LinkedListQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = "a";
        b = "b";
        c = "c";
        d = "d"; 
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
    public void linkedListQueueTest() {
        assertTrue(q.isEmpty());
        q.enqueue(a);
        q.enqueue(b);
        q.enqueue(c);
        q.enqueue(d);
        assertEquals(q.size(), strArray.length);
        
        String str = q.dequeue().toString();
        assertEquals(str, strArray[0]);
        assertEquals(q.size(), strArray1.length);
        
        int i = 0;
        for (Object o : q) {      
            assertTrue(o.toString().equals(strArray1[i++]));
        }
        assertFalse(q.isEmpty());
        
        q.enqueue(e);
        q.enqueue(f);
        assertEquals(q.size(), strArray2.length);
        
        i = 0;
        for (Object o : q) {      
            assertTrue(o.toString().equals(strArray2[i++]));
        }
        
        q.dequeue();
        q.dequeue();
        q.enqueue(b);
    }
}
