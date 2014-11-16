/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collectionsexamples;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayListExample {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        System.out.println(al.size());
        
        Integer a = 1;
        int b = 3;
        
        al.add(a);
        al.add(b);
        
        int c = al.get(0);
        
        ArrayList<Student> students = new ArrayList<>();
        Student st1 = new Student();
        st1.setFirstName("Joe");
        st1.setLastName("Smith");
        
        students.add(st1);
        
        Student st2 = students.get(0);
        
        st2.setFirstName("Mark");
        
        System.out.println(st1.getFirstName());
        
        Student st3 = new Student();
        st3.setFirstName("Sally");
        st3.setLastName("Jones");
        
        Student st4 = new Student();
        st4.setFirstName("John");
        st4.setLastName("Doe");
        
        students.add(st3);
        students.add(st4);
        
        System.out.println("Num Students = " + students.size());
        
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()) {
            Student currentStudent = iter.next();
            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        
        for (Student myStudent : students) {
            System.out.println(myStudent.getFirstName() + " " + myStudent.getLastName());
        }
        
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());
            
        }
        
    }
    
}
