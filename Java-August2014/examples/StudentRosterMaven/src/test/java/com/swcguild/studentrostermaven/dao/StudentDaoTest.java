/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class StudentDaoTest {
    
    private StudentDao dao;
    
    private Student st1;
    private Student st2;
    private Student st3;
    
    public StudentDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (StudentDao) ctx.getBean("dao");
        
        st1 = new Student();
        st1.setFirstName("STUDENT1");
        st1.setLastName("TEST");
        st1.setStudentId("1");
        
        st2 = new Student();
        st2.setFirstName("STUDENT2");
        st2.setLastName("TEST2");
        st2.setStudentId("2");
        
        st3 = new Student();
        st3.setFirstName("STUDENT3");
        st3.setLastName("TEST2");
        st3.setStudentId("3");       
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetStudentTest() {
        
        // test the add and get with valid Student ID
        dao.addStudent(st1);
        Student temp = dao.getStudentById(st1.getStudentId());
        
        assertEquals(st1, temp);
        
        // test get with invalid Student ID
        temp = dao.getStudentById("BOGUS");
        assertNull(temp);
        
        // test adding a student with an existing student id replaces the
        // previous value
        Student replacement = new Student();
        replacement.setStudentId(st1.getStudentId());
        replacement.setFirstName("REPLACEMENT");
        replacement.setLastName("STUDENT");
        
        dao.addStudent(replacement);
        temp = dao.getStudentById(replacement.getStudentId());
        assertEquals(replacement, temp);
    }
    
    @Test
    public void removeStudentTest() {
        // test that we can remove a nonexistent student
        dao.removeStudent("BOGUS");
        
        // add a student to dao
        dao.addStudent(st1);
        // remove the student
        dao.removeStudent(st1.getStudentId());
        // make sure the removed student is actually gone
        Student temp = dao.getStudentById(st1.getStudentId());
        assertNull(temp);
        
    }
    
    @Test
    public void getByLastNameStudentTest() {
        // get students by nonexistent last name - should get empty list
        List<Student> temp = dao.getStudentsByLastName("BOGUS");
        assertEquals(temp.size(), 0);
        
        dao.addStudent(st1);
        dao.addStudent(st2);
        dao.addStudent(st3);
        
        temp = dao.getStudentsByLastName(st1.getLastName());
        assertEquals(temp.size(), 1);
        
        temp = dao.getStudentsByLastName(st2.getLastName());
        assertEquals(temp.size(), 2);
    }
    
    @Test
    public void updateStudentTest() {
        dao.addStudent(st1);
        st1.setFirstName("NEW LAST NAME");
        dao.updateStudent(st1);
        Student temp = dao.getStudentById(st1.getStudentId());
        assertEquals(st1, temp);
    }
    
}
