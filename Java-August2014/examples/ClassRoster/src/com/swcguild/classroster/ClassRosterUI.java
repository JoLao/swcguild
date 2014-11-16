/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classroster;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class ClassRosterUI {

    private ClassRoster roster = new ClassRoster();
    private ConsoleIO con = new ConsoleIO();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassRosterUI ui = new ClassRosterUI();
        ui.run();
    }

    /**
     * Runs the ClassRosterUI program.
     */
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            roster.loadRoster();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("Please select from the above choices.", 1, 5);

                switch (menuSelection) {
                    case 1:
                        con.print("Listing Student IDs...");
                        listStudents();
                        break;
                    case 2:
                        con.print("Create New Student...");
                        createStudent();
                        break;
                    case 3:
                        con.print("Viewing Student Information...");
                        viewStudent();
                        break;
                    case 4:
                        con.print("Removing Student....");
                        removeStudent();
                        break;
                    case 5:
                        con.print("Exiting...");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Command...");
                }

            }
            con.print("Thanks for playing...");
            roster.writeRoster();
        } catch (FileNotFoundException ex) {
            System.out.println("Error loading roster.");
        } catch (IOException ex) {
            System.out.println("Error writing to file");
        }
    }

    private void printMenu() {
        con.print("Main Menu");
        con.print("1. List Student IDs");
        con.print("2. Create New Student");
        con.print("3. View a Student");
        con.print("4. Remove a Student");
        con.print("5. Exit");
    }

    private void listStudents() {
        String[] studentIds = roster.getAllStudentIds();
        for (int i = 0; i < studentIds.length; i++) {
            Student currentStudent = roster.getStudent(studentIds[i]);
            con.print(studentIds[i] + ": " + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        con.readString("Please hit enter to continue.");
    }

    private void viewStudent() {
        String studentId = con.readString("Please enter the ID of the student you wish to veiw.");
        Student currentStudent = roster.getStudent(studentId);
        if (currentStudent != null) {
            con.print(currentStudent.getStudentID());
            con.print(currentStudent.getFirstName() + " " + currentStudent.getLastName());
            con.print(currentStudent.getCohort());
            con.print("");
        } else {
            con.print("No student with ID: " + studentId);
        }
        con.readString("Please hit enter to continue.");
    }
    
    private void createStudent() {
        String studentId = con.readString("Please enter Student ID");
        String firstName = con.readString("Please enter First Name");
        String lastName = con.readString("Please enter Last Name");
        String cohort = con.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        roster.addStudent(studentId, currentStudent);
        con.readString("Student successfully created.  Please hit enter to continue.");
    }
    
    private void removeStudent() {
        String studentId = con.readString("Please enter the ID of the student to be removed");
        roster.removeStudent(studentId);
        con.readString("Student successfully removed.  Please hit enter to continue.");
    }
}
