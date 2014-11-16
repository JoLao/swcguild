/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inheritanceexample;

public abstract class Employee {

//    private String firstName;
//    private String lastName;
//    private String employeeId;
//    private String department;
    
    //in order for these variables to be accessed by subclasses,
    //make it protected
    protected String firstName;
    protected String lastName;
    protected String employeeId;
    protected String department;

    public abstract void doWork();
    
    public abstract void createObjectives();
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
