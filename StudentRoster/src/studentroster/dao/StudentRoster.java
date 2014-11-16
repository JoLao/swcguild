package studentroster.dao;

import studentroster.domain.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//Does 3 things:
//1) store in memory
//2) take in memory and write to a file
//3) get from file and store in memory
public class StudentRoster {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private HashMap<String, Student> students = new HashMap<>();

    public Student addStudent(String studentId, Student student) {
        return students.put(studentId, student);
    }

    public Student removeStudent(String studentId) {
        return students.remove(studentId);
    }

    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public String[] getAllStudentIds() {
        Set<String> keySet = students.keySet();

        //String[] keyArray = new String[keys.size()];
        //keyArray = keySet.toArray(keyArray);
        String[] keyArray = keySet.toArray(new String[0]);  //needs to know what type of array
        
       
        return keyArray;
    }

    public void writeRoster() throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));

        String[] studentKeys = this.getAllStudentIds();
        Student currentStudent = null;

        for (int i = 0; i < studentKeys.length; i++) {

            currentStudent = this.getStudent(studentKeys[i]);
            out.println(currentStudent.getStudentId() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            //force write
            out.flush();

        }
        out.close();

    }

    public void loadRoster() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));

        String currentLine;

        String[] currentTokens;
        Student currentStudent;
        while (in.hasNextLine()) {
            //get the line
            currentLine = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            if (currentTokens.length == 4) {
                currentStudent = new Student(currentTokens[0]);
                currentStudent.setFirstName(currentTokens[1]);
                currentStudent.setLastName(currentTokens[2]);
                currentStudent.setCohort(currentTokens[3]);

                students.put(currentStudent.getStudentId(), currentStudent);
                //or this.addStudent(currentStudent.getStudentId(), currentStudent);
            }
        }
        in.close();
    }

}
