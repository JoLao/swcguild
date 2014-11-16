
package ProgrammingbyDoing.Records;

//Make a record to store information about a car. It should contain fields for:

import java.io.FileWriter;
import java.io.PrintWriter;

//Make a record to store information about a car. It should contain fields for:
//    the make, which is a string
//    the model, which is a string
//    the year, which is an integer
//    the license-plate number, which is a string 
//
//Create an array of type Car with five slots. Have the user type in values to fill up the array.
//
//Ask the user for the name of a file, and then open that file and output all the data from the array 
//to that file. cars.txt
//
//Use Notepad or some other text editor to confirm that the data is correctly in the file. Be careful 
//to only put data in the file, and not labels.
public class StoringDataInAFile {
  public static void main(String[] args)  throws Exception{
        Car[] cars = new Car[5];
        
        ConsoleIO io = new ConsoleIO();
        String make = "";
        String model = "";
        int    year = 0;
        String license = "";
                
        String outputFile = "";        
        
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car "+(i+1));
            make    = io.promptForString("       Make: ");
            model   = io.promptForString("       Model: ");
            year    = io.promptForInteger("       Year: ");
            license = io.promptForString("       License: ");
            cars[i] = new Car(make, model, year, license);
            System.out.println("");
        }
        outputFile = io.promptForString("To which file do you want to save this information?  ");
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        
        for (int i = 0; i < cars.length; i++) {
            out.println(cars[i].getMake()+" "+cars[i].getModel()+" "+cars[i].getYear()+" "+cars[i].getLicense());
        }
        out.flush();
        out.close();
        System.out.println("Data saved.");
        
  }
}
