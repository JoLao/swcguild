/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;

import java.util.Date;

/**
 *
 * @author apprentice
 */
public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date   dob;
    private int    age;
    private String ssn;
    private double salary;
    

    
    private Date   dateHired;

    public Employee() {
    }

    public Employee(String lastName, String firstName, String middleName, String ssn, 
            Date dob, Date dateHired) {
        this.lastName   = lastName;
        this.firstName  = firstName;
        this.middleName = middleName;
        this.dob        = dob;
        this.ssn        = ssn;
        this.dateHired  = dateHired;
    }

    
    
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
   

    public Date getDateHired() {
        return dateHired;
    }       
    
    public void evaluatePerformance() {
        
    }
    
    public int calculateNumberOfYearsInCompany() {
        return 1;
    }
}
