/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inheritanceexample;

/**
 *
 * @author apprentice
 */
public class Manager extends Employee {

//    private String firstName;
//    private String lastName;
//    private String employeeId;
//    private String department;

//    @Override
//    public void doWork() {        
//        System.out.println("Manager doing work...");
//    }
    
    @Override
    public void doWork() {
        System.out.println("Manager doing work...");
    }
    
    @Override
    public void createObjectives() {
        System.out.println("Manager doing some stuff before base class..");
        System.out.println("Manager creating objectives...");
    }

    public void hire() {
        System.out.println("Manager hiring...");
    }
    
    public void fire() {
        System.out.println("Manager firing...");
    }
    
//    public void givePerformanceReview() {
//            System.out.println("Manager giving performance review...");
//    }
//    
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(String employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//    
    
    
}
