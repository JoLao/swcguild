/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class StudentDaoMockImpl implements StudentDao {

    Student temp;
    List<Student> tempList;
    
    public StudentDaoMockImpl() {
        temp = new Student();
        temp.setFirstName("Mock");
        temp.setLastName("Student");
        temp.setStudentId(0);
        
        tempList = new ArrayList<>();
        tempList.add(temp);
    }
    
    @Override
    public void addStudent(Student student) {
    }

    @Override
    public Student getStudentById(int id) {
        return temp;
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return tempList;
    }

    @Override
    public void removeStudent(int studentId) {
    }

    @Override
    public void updateStudent(Student student) {
    }
    
}
