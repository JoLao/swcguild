/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;


public class Student {

    private String name;
    private int    grade;
    private double average;

    public Student() {
    }

    public Student(String name, int grade, double average) {
        this.name = name;
        this.grade = grade;
        this.average = average;
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

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double calculateFinalGrade() {
        return 1.0;
    }
}
