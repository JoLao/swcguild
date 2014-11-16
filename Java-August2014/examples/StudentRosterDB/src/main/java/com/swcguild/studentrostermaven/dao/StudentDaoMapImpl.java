/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import com.swcguild.studentrostermaven.logging.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class StudentDaoMapImpl implements StudentDao {
    
    private Map<Integer, Student> students = new HashMap<>();
    private Logger logger;
    private static int idCounter = 0;
    
    public StudentDaoMapImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void addStudent(Student student) {
        student.setStudentId(idCounter++);
        students.put(student.getStudentId(), student);
        logger.logIt("Student Added: "+ student.toString());
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return students.values().stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public void removeStudent(int studentId) {
        students.remove(studentId);
        logger.logIt("Student Removed: " + studentId);
    }

    @Override
    public void updateStudent(Student student) {
        students.put(student.getStudentId(), student);
    }
    
}
