
package inheritanceexample;


public class SummerIntern extends Employee {

//    private String firstName;
//    private String lastName;
//    private String employeeId;
//    private String department;

//    public void doWork() {
//        System.out.println("SummerIntern doing work...");
//    }
//    
//    public void createObjectives() {
//        System.out.println("SummerIntern creating objectives...");
//    }    

    public void requestPerformanceReview() {
        System.out.println("SummerIntern requesting performance review...");
    }
    
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

    @Override
    public void doWork() {
        System.out.println("SummerIntern doing work...");
    }

    @Override
    public void createObjectives() {
        System.out.println("SummerIntern creating objectives...");
    }
    
    
}
