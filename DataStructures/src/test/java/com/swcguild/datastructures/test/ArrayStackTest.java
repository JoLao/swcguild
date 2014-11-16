/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.test;

import com.swcguild.datastructures.ArrayStack;
import com.swcguild.datastructures.Stack;
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
public class ArrayStackTest {

    Stack st = new ArrayStack();
    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";
    String[] strArray = {"a", "b", "c", "d"};
    String[] strArray1 =  {"a", "b", "c"};
    String[] strArray2 = {"a", "b", "c", "d", "e"};
    boolean result;

    public ArrayStackTest() {
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
    public void arrayStackTest() {
        assertTrue(st.isEmpty());
        st.push(a);
        st.push(b);
        st.push(c);
        st.push(d);
        result = st.size() == strArray.length;
        assertTrue(result);
        
        String str = st.pop().toString();
        result = str.equals(strArray[strArray.length - 1]);
        assertTrue(result);
        
        int i = strArray1.length -1;
        for (Object o : st) {      
            assertTrue(o.toString().equals(strArray1[i--]));
        }
        assertFalse(st.isEmpty());
        
        st.push(d);
        st.push(e);
        assertEquals(st.size(), strArray2.length);
        i = strArray2.length -1;
        for (Object o : st) {      
            assertTrue(o.toString().equals(strArray2[i--]));
        }
        
    }
}
