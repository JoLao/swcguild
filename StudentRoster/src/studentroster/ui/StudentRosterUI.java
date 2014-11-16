
package studentroster.ui;

import studentroster.dao.StudentRoster;
import studentroster.domain.Student;
import java.io.IOException;


public class StudentRosterUI {


    public static void main(String[] args) {
       StudentRoster roster = new StudentRoster();
       
       Student a = new Student("001");
       a.setFirstName("Joe");
       a.setLastName("Smith");
       a.setCohort("Java-Aug2014");
       
       Student b = new Student("002");
       b.setFirstName("Sally");
       b.setLastName("Jones");
       b.setCohort("Java-Sept2013");
       
       roster.addStudent(a.getStudentId(), a);
       roster.addStudent(b.getStudentId(), b);
       
       try {
        roster.writeRoster();
       } catch (IOException ioe) {
           System.out.println("Error writing roster file:"+ioe.getMessage());
           //ioe.printStackTrace();
       }
       
       
    }
    
}
