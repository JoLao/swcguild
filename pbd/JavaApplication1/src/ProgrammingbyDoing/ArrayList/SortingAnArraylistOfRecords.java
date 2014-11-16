package ProgrammingbyDoing.ArrayList;
//Make a record to store information about a car. (This should seem familiar.) It should contain fields for:
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//    the make (String)
//    the model (String)
//    the year (int)
//    the license-plate number (String) 
//
//Create an ArrayList of Car objects.
//
//Ask the user for the name of a file, and then open that file and read all that data from that file into 
//the ArrayList.
//
//Finally, sort the ArrayList of cars by year and print them out. (Note: Printing them the "easy" way won't 
//work unless you've added a toString() method to the Car object.)
public class SortingAnArraylistOfRecords {

    public static void main(String[] args) { //throws Exception {
        ArrayList<Car> carList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        String inputFile = "";

        boolean isFound = false;
        String make = "";
        String model = "";
        int year = 0;
        String license = "";

       
        Scanner in; 
        do {
            try {
                System.out.print("From which file do you want to load this information? ");
                inputFile = keyboard.next();
                in = new Scanner(new BufferedReader(new FileReader(inputFile)));
                isFound = true;
                while (in.hasNext()) {
                    make = in.next();
                    model = in.next();
                    year = in.nextInt();
                    license = in.next();
                    carList.add(new Car(make, model, year, license));
                }
                Collections.sort(carList);
                System.out.println("ArrayList: " + carList);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                
            }
        } while (!isFound);

    }

}
