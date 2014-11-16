/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classroster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * This class is responsible for adding/deleting/updating/retrieving Student
 * objects contained in the roster. It is also responsible for loading the
 * roster from a file and writing the roster to a file.
 *
 * @author apprentice
 */
public class ClassRoster {
    // Create a constant for the name of the roster file.  We do this to improve
    // readability and maintainability.  If we want to change the name of the
    // roster file, we just have to change it in one place.  Remember that 
    // constant name should be in all CAPS with words separated with underscores
    public static final String ROSTER_FILE = "roster.txt";
    // Create a constant for the delimiter we use to separate the pieces of
    // student data on each line of ROSTER_FILE
    public static final String DELIMITER = "::";
    // NOTE TO APPRENTICES: Keep all of these class properties private to provide
    // encapsulation and data hiding.
    // HashMap to store all of our student objects
    // NOTE FOR APPRENTICES: We have to specify both the key type and value type
    // for our map.  Since we want our key to be Strings and our values to be
    // Student objects we must specify HashMap<String, Student>
    private HashMap<String, Student> students = new HashMap<String, Student>();

    /**
     * Loads students into roster from ROSTER_FILE Each line in the file
     * represents one student record. The format of each record is:
     * StudentId::First Name::Last Name::cohort
     * 
     * @throws FileNotFoundException if ROSTER_FILE is not present 
     */
    // NOTE FOR APPRENTICES: We are not handling the FileNotFoundException in this
    // method, rather we are simply going to throw it (i.e. 'report' it) to the
    // code that called this method.  It is the responsibility of the calling code
    // to handing this error in some way if/when it occurs.  In our case, that code 
    // will be in the ClassRosterUI class.
    public void loadRoster() throws FileNotFoundException {
        // Create Scanner for reading the file
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has 
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES:  In our case we use :: as our delimiter.  If 
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a String array the looks like this:
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a Student
        // object
        // process while we have more lines in the file
        while(sc.hasNextLine()) {
            // get the next line in the file
            currentLine = sc.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES:  We are going to use the student id 
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            Student currentStudent = new Student(currentTokens[0]);
            // Set the remaining values on currentStudent manually
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            // Put currentStudent into the map using studentID as the key
            students.put(currentStudent.getStudentID(), currentStudent);          
        }
        // close scanner
        sc.close();
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     * @throws IOException if an error occurs writing to the file 
     */
    public void writeRoster() throws IOException {
        // NOTE FOR APPRENTICES:  We are not handling the IOException - we are 
        // simple throwing it (i.e. 'reporting' it) to the code that called us.
        // It is the responsibility of the calling code to handle any errors
        // that occur.
        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));
        
        // Write out the Student objects to the roster file.
        // NOTE TO APPRENTICES:  We could just grab the student map, get the 
        // key Set and iterate over them as we have done in the past but we
        // have already created a method that will give us a String array of
        // the keys and we have a method that will retrieve a Student object
        // for a given key so lets just reuse that code.
        String[] keys = this.getAllStudentIds();
        // go through the keys one-by-one and get the corresponding Student
        // object
        for (int i = 0; i < keys.length; i++) {
            // get the Student object
            Student currentStudent = this.getStudent(keys[i]);
            // write the Student object to the file
            out.println(currentStudent.getStudentID() + DELIMITER + 
                        currentStudent.getFirstName() + DELIMITER + 
                        currentStudent.getLastName() + DELIMITER +
                        currentStudent.getCohort());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up 
        out.close();
    }

    /**
     * Returns the student object associated with the given student id. Returns
     * null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id, null if
     * no such student exists
     */
    public Student getStudent(String studentId) {
        // NOTE FOR APPRENTICES: In this method we simply ask the student map for
        // the student associated with the given id and then return it.  No
        // more work than that is necessary.
        return students.get(studentId);
    }

    /**
     * Add the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given student
     * id if it exists, null otherwise
     */
    public Student addStudent(String studentId, Student student) {
        // NOTE FOR APPRENTICES: In this method we simple add the give student
        // to the student map using the given studentId as the key.  If there
        // is currently a Student object associated with the key, the student
        // map will return it to us and we'll simply return that value to our
        // caller.  No more work is necessary.
        return students.put(studentId, student);
    }

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the Student object that is being removed or null if there is no student
     * associated with the given id.
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student was
     * associated with the given student id
     */
    public Student removeStudent(String studentId) {
        // NOTE FOR APPRENTICES: In this method we simply ask the student map
        // to remove that Student object associated with the given id.  The 
        // map will return the object to us (if there is a Student object
        // associated with the given key - it returns null if there isn't).  No
        // more work that this is necessary.
        return students.remove(studentId);
    }

    /**
     * Returns a String array containing the student ids of all students in the
     * roster.
     *
     * @return String array containing the ids of all the students in the roster
     */
    public String[] getAllStudentIds() {
        // return a String array containing all of the keys from our student map
        // NOTE FOR APPRENTICES: We have to specify that this is Set of String.
        // This is necessary because we said above that all keys in our map must
        // be Strings.
        Set<String> keySet = students.keySet();
        // NOTE TO APPRENTICES: In order to return a String array of the keys
        // in the keySet, we must create an array big enough to hold all the
        // keys and then pass it into toArray.  toArray will then fill the
        // array up and return it to us.  We then just return it to the code that
        // called us.
        String[] keyArray = new String[keySet.size()];
        keyArray =  keySet.toArray(keyArray);
        return keyArray;
    }
}
