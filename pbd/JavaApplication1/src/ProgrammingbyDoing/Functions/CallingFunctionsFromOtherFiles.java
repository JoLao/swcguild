/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;

import java.util.Scanner;
import static ProgrammingbyDoing.Functions.MonthOffset.month_offset;


/**
 *
 * @author apprentice
 */
public class CallingFunctionsFromOtherFiles {

//Rewrite the Weekday Calculator to have almost no functions in it. Start by opening up 
//WeekdayCalculator.java and saving a copy of it as CallingFunctionsFromOtherFiles.java.
//
//Then erase all the functions except for main() and weekday().
//
//Now, when you compile it, you should get a lot of errors about undefined functions.
//
//Then rewrite all the function calls so that they refer to versions in your previous assignments. The functions will be these:
//
//    MonthName.month_name()
//    WeekdayName.weekday_name()
//    MonthOffset.month_offset()
//    WeekdayCalculator.is_leap()  
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");
        System.out.println("12 10 2003 => " + weekday(12, 10, 2003));
        System.out.println(" 2 13 1976 => " + weekday(2, 13, 1976));
        System.out.println(" 2 13 1977 => " + weekday(2, 13, 1977));
        System.out.println(" 7  2 1974 => " + weekday(7, 2, 1974));
        System.out.println(" 1 15 2003 => " + weekday(1, 15, 2003));
        System.out.println("10 13 2000 => " + weekday(10, 13, 2000));
        System.out.println();

        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        // put a function call for weekday() here
        System.out.println("You were born on ");
    }

    public static String weekday(int mm, int dd, int yyyy) {
        int yy, total;
        String date = "";

        // bunch of calculations go here
        yy = yyyy - 1900;
        total = yy / 4;
        total = total + yy + month_offset(mm);

        if (is_leap(yyyy) && (mm == 1 ||mm == 2)) {
            total--;
        }    

       
        date = weekDayName(total%7)+", "+month_name(mm)+ " "+dd + ", " + yyyy;
        

        return date;
    }

    // paste your functions from MonthName, WeekdayName, and MonthOffset here
    public static String month_name(int month) {
        String result;
        // Your code goes in here.
        String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            result = monthName[month - 1];
        } else {
            result = "error";
        }
        return result;
    }
    
    public static String weekDayName(int wk) {
        String result;
        String[] weekName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                             "Saturday", "Sunday"};
        if (wk >= 1 && wk <= 7) {
            result = weekName[wk];
        } else {
            result = "error";
        }
        return result;
        
    }

    public static int month_offset(int month) {
        int result;
        // Your code goes in here.
        int[] monthOffset = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

        if (month >= 1 && month <= 12) {
            result = monthOffset[month];
        } else {
            result = -1;
        }

        return result;
    }

    public static boolean is_leap(int year) {
		// years which are evenly divisible by 4 are leap years,
        // but years divisible by 100 are not leap years,
        // though years divisible by 400 are leap years
        boolean result;

        if (year % 400 == 0) {
            result = true;
        } else if (year % 100 == 0) {
            result = false;
        } else if (year % 4 == 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}

