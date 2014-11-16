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
public class InheritanceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Employee     emp     = new Employee();
//       Manager      mgr     = new Manager();
//       SummerIntern intern  = new SummerIntern();
//       
//       emp.setLastName("Smith");
//       emp.doWork();
//       emp.createObjectives();
//       
//       System.out.println("+++++++++++++++++++++++++++++++");
//       mgr.setLastName("Johnson");          
//       mgr.doWork();
//       mgr.createObjectives();
//       mgr.hire();
//       intern.doWork();
//       intern.requestPerformanceReview();
        
//        Employee emp = new Employee();
//        emp.setFirstName("Joe");
//        emp.setLastName("Smith");
//        emp.doWork();
//        emp.createObjectives();
        
        System.out.println("====================================================");
        Employee emp2 = new Manager();
        emp2.setFirstName("John");
        emp2.setLastName("Doe");
        //not in Manager Class. Calls Employe Class' doWork()
        emp2.doWork();
        
        //calls Manager Class' createObjectives()
        emp2.createObjectives();
        //emp2.hire();  --> will not work because hire() is not in Employee Class
        
        //will not work because Manager has more functions that Employee
        //does not have
        //Manager mgr = new Employee(); 
    }
    
}
