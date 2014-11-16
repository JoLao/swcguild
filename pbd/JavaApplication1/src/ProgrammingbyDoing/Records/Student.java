
package ProgrammingbyDoing.Records;
import java.util.Comparator;

public class Student implements Comparable<Student> {

    private int    studentID;
    private String name;
    private int    grade;
    private float  gradeFloat;
    private String gradeLetter;
    private double average;

    public Student() {
    }

    public Student(String name, int grade, double average) {
        this.name = name;
        this.grade = grade;
        this.average = average;
    }

    public Student(int studentID, int grade, float gradeFloat, String gradeLetter) {
        this.studentID   = studentID;        
        this.grade       = grade;
        this.gradeFloat  = gradeFloat;
        this.gradeLetter = gradeLetter;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getGradeFloat() {
        return gradeFloat;
    }

    public void setGradeFloat(float gradeFloat) {
        this.gradeFloat = gradeFloat;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }
    
    

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
    
    public int compareTo(Student compareStudent) {

        int compareGrade = ((Student) compareStudent).getGrade();

        //ascending order
        return this.grade - compareGrade;

		//descending order
        //return compareGrade - this.grade;
    }
    
}
