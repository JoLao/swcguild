
package ProgrammingbyDoing.Records;

//Make a record to store information about a dog. It should contain fields for:
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//
//    a breed, which is a String,
//    an age, which is an integer, and
//    a weight, which is a double 
//
//Using Notepad or the text editor of your choice, create a text file containing 
//six pieces of information. Save this file in your home directory.
//
//Create two Dog objects (not in an array).
//
//Ask the user for the name of a file to open, and open that file and read in a 
//breed, age, weight, and breed, age, weight from the file. dogs.txt
public class GettingDataFromAFile {

    public static void main(String[] args) throws Exception {
        Scanner keybd = new Scanner(System.in);

        Dog[] dogs = new Dog[2];
        String breed = "";
        int age = 0;
        int weight = 0;
        int sub = 0;

        System.out.print("Which file to open: ");
        String inputFile = keybd.next();
        System.out.println("Reading data from " + inputFile);

        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));

        while (in.hasNext()) {
            breed = in.next();
            age = in.nextInt();
            weight = in.nextInt();
            if (sub < dogs.length) {
                dogs[sub] = new Dog(breed, age, weight);
                //still needs to instantiate per element
//                dogs[sub].setBreed(breed);
//                dogs[sub].setAge(age);
//                dogs[sub].setWeight(weight);
                sub++;              
            }
        }
        
        for (int i = 0; i < dogs.length; i++) {
            System.out.println("Dog "+i+" "+dogs[i]);
        }
    }
}
