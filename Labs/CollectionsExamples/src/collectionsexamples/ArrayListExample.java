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
        
        //in lower Java Version you put the type before ()
        //not required in Java 8
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        
        System.out.println(al.size());
        
        Integer a = new Integer(1);
        Integer b = 1 + 2 * 3;
        int     c  =3;
        
        al.add(a);
        al.add(b);
        al.add(c);  //converts primitive to Integer object for you
        
        int d = al.get(0);  //can get Integer object and converts it to primitive for you
        
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
        
        System.out.println("Num Students = "+students.size());
        
        Iterator<Student> iter = students.iterator();
        
        System.out.println("");
        System.out.println("Using Iterator : while loop");
        while (iter.hasNext()) {
            Student currentStudent = iter.next();
            System.out.println(currentStudent.getFirstName()+ " "+ currentStudent.getLastName());
        }
        System.out.println("");
        System.out.println("Using Iterator : Enhanced for loop");
        //enhanced for loop
        //for each student st in my arraylist students
        for (Student st : students) {
            System.out.println(st.getFirstName()+" "+st.getLastName());
        }
        
        System.out.println("");
        System.out.println("Using ordinary for loop");
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            System.out.println(currentStudent.getFirstName()+ " "+ currentStudent.getLastName());            
        }
    }
    
}
