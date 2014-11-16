
package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;
//Create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList. 
//Then display the contents of the ArrayList on the screen.
//
//Do not use a loop. Also, do not use any variable for the index; you must use literal numbers to 
//refer to each slot.
public class BasicArraylists0 {
    
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        num.add(-113);
        
        System.out.println("Slot 0 contains a "+num.get(0));
        System.out.println("Slot 0 contains a "+num.get(1));
        System.out.println("Slot 0 contains a "+num.get(2));
        System.out.println("Slot 0 contains a "+num.get(3));
        System.out.println("Slot 0 contains a "+num.get(4));
        System.out.println("Slot 0 contains a "+num.get(5));
        System.out.println("Slot 0 contains a "+num.get(6));
        System.out.println("Slot 0 contains a "+num.get(7));
        System.out.println("Slot 0 contains a "+num.get(8));
        System.out.println("Slot 0 contains a "+num.get(9));
        
    }
    
}
