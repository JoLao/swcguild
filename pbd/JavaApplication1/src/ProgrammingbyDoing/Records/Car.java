/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Records;

import java.util.Comparator;

/**
 *
 * @author apprentice
 */
public class Car implements Comparable<Car> {

    private String make;
    private String model;
    private int year;
    private String license;

    public Car() {

    }

    public Car(String make, String model, int year, String license) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.license = license;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int compareTo(Car compareCar) {

        int compareYear = ((Car) compareCar).getYear();

        //ascending order
        return this.year - compareYear;

        //descending order
        //return compareYear - this.year;
    }
//     public static Comparator<Car> CarMakeComparator
//                    = new Comparator<Car>() {
//
//                @Override
//                public int compare(Car car1, Car car2) {
//
//                    String carMake1 = car1.getMake().toUpperCase();
//                    String carMake2 = car2.getMake().toUpperCase();
//
//                    //ascending order
//                    return carMake1.compareTo(carMake2);
//
//                    //descending order
//                    //return carMake2.compareTo(carMake1);
//                }
//
//            };
        public static Comparator<Car> CarMakeComparator
                    = (Car car1, Car car2) -> {
                        String carMake1 = car1.getMake().toUpperCase();
                        String carMake2 = car2.getMake().toUpperCase();
                        
                        //ascending order
                        return carMake1.compareTo(carMake2);
    };
}
