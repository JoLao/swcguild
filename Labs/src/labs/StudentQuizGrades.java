
package labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//In this lab you will write a program that stores quiz scores for each student in a class and 
//calculates the average quiz score for each student on request.  The user should be able to do 
//the following: 
//● View a list of students in the system 
//● Add a student to the system 
//● Remove a student from the system 
//● View a list of quiz scores for a given student 
//● View the average quiz score for a given student 
// 
//It is left up to you to design and implement a reasonable UI menu system.  Design the UI and 
//program flow chart before coding ­ you must review your both with the instructor before 
//proceeding. 
// 
//Your program must have the following features:  
// 
//1. This program will be a Java Console Application called StudentQuizGrades  
//2. The program must use the ConsoleIO class created previously for all console input and 
//output. 
//3. The program must store student quiz data in a HashMap that has the student name as 
//the key and an ArrayList of Integers as the values (will this affect your ability to calculate 
//average scores?) 
// 
//Extension: 
//1. Calculate the average quiz score for the entire class 
//2. Find and list the student(s) with the highest quiz score 
//3. Find and list the student(s) with the lowest quiz score 
public class StudentQuizGrades {
    public  ConsoleIO io = new ConsoleIO();
        
    public  HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();
    public  ArrayList<Integer> studentScores;
    
    public static void main(String[] args) {
        StudentQuizGrades studQuizzes = new StudentQuizGrades();
        
        int choice = 0;

        choice = studQuizzes.displayMenu();
        System.out.println("");
        while (choice != 9) {
            switch (choice) {
                case 1:
                    studQuizzes.viewAListOfStudents();
                    break;
                case 2:
                    studQuizzes.addAStudent();
                    break;
                case 3:
                    studQuizzes.removeAStudent();
                    break;
                case 4:
                    studQuizzes.viewScoresOfStudent();
                    break;
                case 5:
                    studQuizzes.viewAverageScoreOfStudent();
                    break;
                case 6:
                    studQuizzes.calculateAverageScoreOfEntireClass();
                    break;
                case 7:
                    studQuizzes.findStudentsWithHighestQuizScore();
                    break;
                case 8:
                   studQuizzes.findStudentsWithLowestQuizScore();
            }
            choice = studQuizzes.displayMenu();
        }
    }
        
    public int displayMenu() {
        int choice = -1;
        while (choice < 0 || choice > 9) {
            System.out.println("");
            System.out.println("1) View a list of students");
            System.out.println("2) Add a student");
            System.out.println("3) Remove a student");
            System.out.println("4) View a list of quiz scores for a given student ");
            System.out.println("5) View the average quiz score for a given student");
            System.out.println("6) Calculate the average quiz score for the entire class");
            System.out.println("7) Find and list the student(s) with the highest quiz score");
            System.out.println("8) Find and list the student(s) with the lowest quiz score");
            System.out.println("9) Quit");
            System.out.println("");
            choice = io.promptForInteger("Please choose what you'd like to do: ");
        }
        return choice;
    }
    
    public  void viewAListOfStudents(){
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        boolean isEmpty = true;
        while (iter.hasNext()) {
            System.out.println(iter.next());
            isEmpty = false;
        }
        if (isEmpty) {
            System.out.println("No students stored.");
        }
    }
    
    public  void addAStudent() {
        System.out.println("Please enter the following information: ");
        String name = io.promptForString("Enter name: ");
        int score = -1;
        studentScores = new ArrayList<>();
        
        while (score != 0) {
            score = io.promptForInteger("Enter score (type 0 to stop) : ");
            if (score != 0) {
                studentScores.add(score);
            }
        }
        studentMap.put(name, studentScores);
        System.out.println("Student added.");
    }
    
    public  void removeAStudent() {
        String name = io.promptForString("Enter Name: ");
        ArrayList<Integer> scores = studentMap.remove(name);
        
        if (scores == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student removed.");
        }
    }
    
    public  void viewScoresOfStudent() {
        String name = io.promptForString("Enter Name: ");
        studentScores = studentMap.get(name);
        System.out.println("Scores: "+studentScores);        
    }
    
    public  void viewAverageScoreOfStudent() {
        viewScoresOfStudent();
        double sum = 0;
        for (int i = 0; i < studentScores.size(); i++) {
            sum += studentScores.get(i);
        }
        System.out.println("Average score is "+ sum / studentScores.size());
        
    }
    
    public  void calculateAverageScoreOfEntireClass() {
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        String name = "";
        double sum = 0;
        int numOfScores = 0;
        while (iter.hasNext()) {
            name = iter.next();
            studentScores = studentMap.get(name);
            for (int i = 0; i < studentScores.size(); i++) {
                //System.out.println(studentScores.get(i));
                sum += studentScores.get(i);
                numOfScores++;
            }
        }
       // System.out.println("sum "+sum+" num "+numOfScores);
        System.out.println("Average Score Of Entire Class is "+(sum / numOfScores));
        
    }
    
    public  void findStudentsWithHighestQuizScore() {
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        int highestScore = 0;
        String name = "";
        HashMap<String,Integer> highestScores = new HashMap<>();
        while (iter.hasNext()) {
            name = iter.next();
            studentScores = studentMap.get(name);
            Collections.sort(studentScores,Collections.reverseOrder());
            if (studentScores.get(0) > highestScore) {
                highestScore = studentScores.get(0);
            }
            highestScores.put(name, studentScores.get(0));
        }
        System.out.println("Highest Score is "+highestScore);
        System.out.println("The following students have the highest quiz score: ");
        Set<String> key1 = highestScores.keySet();
        Iterator<String> iter1 = key1.iterator();
        while (iter1.hasNext()) {
            name = iter1.next();
            if (highestScores.get(name) == highestScore) {
                System.out.println(name);
            }
        }
    }
    
    public  void findStudentsWithLowestQuizScore() {
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        int lowestScore = 999999;
        String name = "";
        HashMap<String,Integer> lowestScores = new HashMap<>();
        while (iter.hasNext()) {
            name = iter.next();
            studentScores = studentMap.get(name);
            Collections.sort(studentScores);
            if (studentScores.get(0) < lowestScore) {
                lowestScore = studentScores.get(0);
            }
            lowestScores.put(name, studentScores.get(0));
        }
        System.out.println("Highest Score is "+lowestScore);
        System.out.println("The following students have the lowest quiz score: ");
        Set<String> key1 = lowestScores.keySet();
        Iterator<String> iter1 = key1.iterator();
        while (iter1.hasNext()) {
            name = iter1.next();
            if (lowestScores.get(name) == lowestScore) {
                System.out.println(name);
            }
        }       
    }
}
