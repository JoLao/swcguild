/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface StudentDao {
    
    public void addStudent(Student student);
    public Student getStudentById(int id);
    public List<Student> getStudentsByLastName(String lastName);
    public void removeStudent(int studentId);
    public void updateStudent(Student student);
    
}
