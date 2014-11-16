
package ProgrammingbyDoing.Records;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
//Make a record to store information about a student's grades. It should contain fields for:
//
//    the student, which is identified by a three-digit integer for their "student id number"
//    the grade number, which is an integer (1-6)
//    the grade, which is a floating-point value (0.0 through 100.0)
//    the corresponding letter grade, which should be a String 
//
//I have provided a file filled with grade information. You should create an array of records 
//with 30 slots. Read the contents of the file into the array of records.
//
//    gb.txt

public class SortingRecordsOnTwoFields {
    public static void main(String[] args) throws Exception {
        ConsoleIO io       = new ConsoleIO();
        Student[] students = new Student[30];
        
        int       sub         = 0;
        int       studentID   = 0;
        int       grade       = 0;
        float     gradeFloat  = 0f;
        String    gradeLetter = "";
        
        String inputFile = io.promptForString("Open which file: ");
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        
        while (in.hasNext()) {
            studentID   = in.nextInt();
            grade       = in.nextInt();
            gradeFloat  = in.nextFloat();
            gradeLetter = in.next();
            students[sub] = new Student(studentID, grade, gradeFloat, gradeLetter);
            sub++;
        }
        System.out.println("Data loaded.");
        Arrays.sort(students);
        System.out.println("Data sorted.");
        System.out.println("Here are the sorted grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getStudentID()+" "+students[i].getGrade()+" "+
                               students[i].getGradeFloat()+" "+students[i].getGradeLetter());
        }
        
    }
    
}
