/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class HashMapExample {

    public static void main(String[] args) {
        HashMap<String, Student> studentMap = new HashMap<>();

        Student st1 = new Student();
        st1.setFirstName("John");
        st1.setLastName("Doe");

        Student st2 = new Student();
        st2.setFirstName("Jane");
        st2.setLastName("Smith");

        Student st3 = new Student();
        st3.setFirstName("Bill");
        st3.setLastName("Gates");
        
        Student temp;
        temp = studentMap.put("Doe", st1);
        if (temp == null) {
            System.out.println("No Mapping for Doe");
        }
        temp = studentMap.put("Doe", st2);
        if (temp != null) {
            System.out.println(temp.getFirstName());
        }
        studentMap.put("Gates", st3);
    
        
        temp = studentMap.get("Doe");
        System.out.println(temp.getFirstName());
        
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next()); 
       }
        
        Collection values = studentMap.values();
        Iterator<Student> iter2 = values.iterator();
        while(iter2.hasNext()) {
            Student currentStudent = iter2.next();
            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }

    }

}
