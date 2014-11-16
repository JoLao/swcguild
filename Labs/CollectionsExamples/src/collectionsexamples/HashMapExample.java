
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
        temp = studentMap.put(st1.getLastName(), st1);
        //returns null if Doe does not exist
        if (temp == null) {
            System.out.println("No Mapping for Doe");
        }
        
        //returns the old value if Doe already exists in the studentMap
        temp = studentMap.put(st1.getLastName(), st2);
        if (temp != null) {
            System.out.println(temp.getFirstName());
        }
        
        studentMap.put(st2.getLastName(), st2);
        studentMap.put(st3.getLastName(), st3);
        
        temp = studentMap.get("Doe");
        System.out.println(temp.getFirstName());
        
        //list out all the keys in the map
        System.out.println("");
        System.out.println("List of Keys:");
        Set<String> keys = studentMap.keySet();
        Iterator<String> iter = keys.iterator();
        
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        //list out all the values in the map
        System.out.println("");
        System.out.println("List of Values: In this case Students");
        Collection<Student> values = studentMap.values();
        Iterator<Student> iter2 = values.iterator();
        while (iter2.hasNext()) {
            Student currentStudent = iter2.next();
            System.out.println(currentStudent.getFirstName()+" "+currentStudent.getLastName());
        }
        System.out.println("");
        System.out.println("To retrieve value with a known key :");
        System.out.println(studentMap.get("Gates").getFirstName());
    }
}
