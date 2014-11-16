package ProgrammingbyDoing.ArrayList;

//Create an ArrayList of Integers. Fill up the list with 1,000 random numbers, each from 10 to 99. 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//Then display the contents of the ArrayList on the screen in any way you like.
public class BasicArraylists3 {

    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();

        Random rGen = new Random();
        int rInt = 0;

        for (int i = 0; i < 1000; i++) {
            arrInt.add(rGen.nextInt(90) + 10);
        }

        System.out.println("");
        Iterator<Integer> iter = arrInt.iterator();
        int j = 0;
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
            j++;
            if (j == 20) {
                System.out.println("");
                j = 0;
            }
        }
        System.out.println("");
        System.out.println("Using for iterator");
        j = 0;
        for (Integer i : arrInt) {
            System.out.print(i + ", ");
            j++;
            if (j == 20) {
                System.out.println("");
                j = 0;
            }
        }

        System.out.println("");
        System.out.println("Using for loop with array size");
        for (int i = 0; i < arrInt.size(); i++) {
            System.out.print(arrInt.get(i) + ", ");
            j++;
            if (j == 20) {
                System.out.println("");
                j = 0;
            }
        }
    }

}
