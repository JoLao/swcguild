package ProgrammingbyDoing.Records;

//Using Notepad or the text editor of your choice, create a text file containing five names and five ages. 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//Save this file in your home directory.
//
//Make a record to store information about a person. It should contain fields for:
//
//    a single name, which is a String, and
//    an age, which is an integer 
//
//Create an array of type Person with five slots.
//
//Ask the user for the name of a file to open, and open that file and read in five names and ages from 
//the file. nameage.txt
//
//Display the contents of the array using a loop.
public class GettingMoreDataFromAFile {

    public static void main(String[] args) throws Exception {
        Person[] persons = new Person[5];

        String name = "";
        int age = 0;
        int sub = 0;
        Scanner keybd = new Scanner(System.in);
        System.out.print("Which file to open: ");
        String inputFile = keybd.next();
        System.out.println("Reading from " + inputFile);

        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));

        while (in.hasNext()) {
            name = in.next();
            age = in.nextInt();
            persons[sub] = new Person(name, age);
            sub++;
        }

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName() + " is " + persons[i].getAge());
        }
    }
}
