/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.controller;

import com.swcguild.studentrostermaven.dao.StudentDao;
import com.swcguild.studentrostermaven.domain.Student;
import com.swcguild.studentrostermaven.ui.IO;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class StudentController {

    IO io;
    StudentDao dao;

    public StudentController(IO io, StudentDao dao) {
        this.io = io;
        this.dao = dao;
    }

    public void run() {
        String menuChoice = "";

        do {
            menuChoice = displayMenu();

            switch (menuChoice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    getStudentById();
                    break;
                case "3":
                    getStudentsByLastName();
                    break;
                case "4":
                    removeStudent();
                    break;
                case "5":
                    updateStudent();
                    break;
                case "Q":
                case "q":
                    io.print("Thank you - Goodbye!");
                    break;
                default:
                    io.print("Invalid Input, Please Try Again");
            }

        } while (!menuChoice.equalsIgnoreCase("Q"));
    }

    private String displayMenu() {
        return io.readString("================================================\n"
                + "1. Add Student\n"
                + "2. Get Student By ID\n"
                + "3. Get Students By Last Name\n"
                + "4. Remove Student\n"
                + "5. Update Student\n"
                + "Q. Quit\n"
                + "================================================\n");
    }

    private void addStudent() {
        Student temp = new Student();
        temp.setFirstName(io.readString("Please enter first name:"));
        temp.setLastName(io.readString("Please enter last name:"));
        temp.setMajor(io.readString("Please enter major:"));
        temp.setStreet(io.readString("Please enter street:"));
        temp.setCity(io.readString("Please enter city:"));
        temp.setState(io.readString("Please enter state:"));
        temp.setZipcode(io.readString("Please enter zip:"));

        dao.addStudent(temp);

        io.print("Student added successfully:");
        io.print("============================");
        io.print(temp.toString());
        io.print("============================");
    }

    private void getStudentById() {
        Student temp = dao.getStudentById(io.readInt("Enter id of student to retrieve:"));
        if (temp != null) {
            io.print("============================");
            io.print(temp.toString());
            io.print("============================");
        } else {
            io.print("No student found with that id");
        }
    }

    private void getStudentsByLastName() {
        List<Student> temp = dao.getStudentsByLastName(io.readString("Enter last name to search for:"));
//        temp.stream()
//                .forEach(student -> io.print(student.toString()));
        for (Student student : temp) {
            io.print("============================");
            io.print(student.toString());
            io.print("============================");
        }
    }

    private void removeStudent() {
        int studentId = io.readInt("Enter the id of the student you wish to remove:");
        dao.removeStudent(studentId);
    }

    private void updateStudent() {
        Student temp = dao.getStudentById(io.readInt("Enter the id of the student to edit:"));
        if (temp != null) {
            io.print("Student found:");
            io.print(temp.toString());
            temp.setFirstName(io.readString("Please enter first name:"));
            temp.setLastName(io.readString("Please enter last name:"));
            temp.setMajor(io.readString("Please enter major:"));
            temp.setStreet(io.readString("Please enter street:"));
            temp.setCity(io.readString("Please enter city:"));
            temp.setState(io.readString("Please enter state:"));
            temp.setZipcode(io.readString("Please enter zip:"));

            dao.updateStudent(temp);

            io.print("Student updated successfully:");
            io.print("============================");
            io.print(temp.toString());
            io.print("============================");
        } else {
            io.print("No student for given student id.");
        }
    }

}
