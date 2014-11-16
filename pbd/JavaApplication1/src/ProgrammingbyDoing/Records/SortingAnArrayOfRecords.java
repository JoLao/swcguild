package ProgrammingbyDoing.Records;

//Repeat the previous assignment. However, once you've read in the car data from the file, 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

//then sort the array of cars by year. Then, print it out (now sorted). cars.txt
public class SortingAnArrayOfRecords {

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
        Arrays.sort(cars);
        System.out.println("Data sorted");
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
