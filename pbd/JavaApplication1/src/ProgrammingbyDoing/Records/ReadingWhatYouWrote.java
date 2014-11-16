
package ProgrammingbyDoing.Records;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


//Again, make a record to store information about a car. It should contain fields for:
//    the make, which is a String
//    the model, which is a String
//    the year, which is an integer
//    the license-plate number, which is a String 
//
//Create an array of type Car with five slots. (So far, this is the same as the previous assignment.)
//
//Ask the user for the name of a file, and then open that file and read all the data from that file
//into the array.
//cars.txt
public class ReadingWhatYouWrote {
       public static void main(String[] args) throws Exception {
        ConsoleIO io = new ConsoleIO();

        String inputFile = io.promptForString("From which file do you want to load this information?  ");
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));

        Car[] cars = new Car[5];
        int sub = 0;
        String make = "";
        String model = "";
        int year = 0;
        String license = "";

        while (in.hasNext()) {
            make = in.next();
            model = in.next();
            year = in.nextInt();
            license = in.next();
            cars[sub] = new Car(make, model, year, license);
            sub++;
        }
        in.close();
        System.out.println("Data loaded");
        
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car " + (i + 1));
            System.out.println("       Make: "+cars[i].getMake());
            System.out.println("       Model: "+cars[i].getModel());
            System.out.println("       Year: "+cars[i].getYear());
            System.out.println("       License: "+cars[i].getLicense());
            
            System.out.println("");
        }

    }

}
