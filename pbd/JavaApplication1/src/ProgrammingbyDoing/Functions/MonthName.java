/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Functions;

/**
 *
 * @author apprentice
 */
public class MonthName {

//Write a function. It will return the name of a month of the year, given the month number, 
//according to the table below. Make sure you do not put any input or output statements in 
//the function; the month number will be passed in and the string containing the name will be returned.        
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

    public static void main(String[] args) {
        System.out.println("Month 1: " + month_name(1));
        System.out.println("Month 2: " + month_name(2));
        System.out.println("Month 3: " + month_name(3));
        System.out.println("Month 4: " + month_name(4));
        System.out.println("Month 5: " + month_name(5));
        System.out.println("Month 6: " + month_name(6));
        System.out.println("Month 7: " + month_name(7));
        System.out.println("Month 8: " + month_name(8));
        System.out.println("Month 9: " + month_name(9));
        System.out.println("Month 10: " + month_name(10));
        System.out.println("Month 11: " + month_name(11));
        System.out.println("Month 12: " + month_name(12));
        System.out.println("Month 43: " + month_name(43));
    }
}
