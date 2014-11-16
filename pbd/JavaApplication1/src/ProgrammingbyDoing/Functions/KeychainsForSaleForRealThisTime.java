/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class KeychainsForSaleForRealThisTime {

//    You will need 2 new variables in main, one to store the current number of keychains, 
//    and one to store the price per keychain.
//    The price should be $10 per keychain.
//    add_keychains() will need to be passed one int, and have a return type of int. It will ask the 
//    user for the number of keychains to add to the order, and then return the new number of keychains.
//    remove_keychains() will need to be passed one int, and have a return type of int. It will ask the 
//    user for the number of keychains to remove from the order, and then return the new number of 
//    keychains.
//    view_order() will need to be passed two ints, and have a return type of void. It will display, 
//    on three different lines, the number of keychains in the order, the price per keychain, and the 
//    total cost of the order.
//    checkout() will need to be passed two ints, and have a return type of void. It will ask the 
//    user for his/her name in order to deliver them correctly, display the order information, and 
//    then thank the user, by name, for ordering.     
     public static void main(String[] args) {
        System.out.println("Ye Olde Keychain Shoppe");
        int choice;
        int numKeyChains = 0, price = 0;
        
        displayMenu();
        do {
            Scanner keybd = new Scanner(System.in);
            System.out.print("Please enter your choice: ");
            choice = keybd.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    numKeyChains = add_keychains(keybd, numKeyChains);
                    displayMenu();
                    break;
                case 2:
                    numKeyChains = remove_keychains(keybd, numKeyChains);
                    displayMenu();
                    break;
                case 3:
                    view_order(numKeyChains, 10);
                    displayMenu();
                    break;
                case 4:
                    checkout(keybd, numKeyChains, 10);
            }
        } while (choice < 4);
        
    }
    
    public static void displayMenu() {
        System.out.println("");
        System.out.println("1. Add Keychains to Order");
        System.out.println("2. Remove Keychains from Order");
        System.out.println("3. View Current Order");
        System.out.println("4. Checkout");
        System.out.println("");
    }
    
    public static int add_keychains(Scanner keybd, int n) {
        int addNum = 0;
        int newTotal = 0;
        
        System.out.print("You have "+n+" keychains. How many to add? ");
        addNum = keybd.nextInt();
        if (addNum > 0) {            
            newTotal = n + addNum;
            System.out.println("You now have "+ newTotal +" keychains.");
        } else {
            System.out.println("Nothing to add");
            newTotal = n;
        }
        return newTotal;
    }
    
    public static int remove_keychains(Scanner keybd, int n) {
        System.out.print("You have "+n+" keychains. How many to remove? ");
        int removeNum = keybd.nextInt();
        int newTotal = 0;
        
        if (removeNum > 0) {
            newTotal = n - removeNum;
            System.out.println("You now have "+ newTotal +" keychains.");
        } else {
            System.out.println("Nothing to remove");
            newTotal = n;
        }
        
        return newTotal;
    }
        
    public static void view_order(int n, int price) {
        System.out.println("You have "+n+" keychains.");
        System.out.println("Keychains cost "+price);
        System.out.println("Total cost is $"+ (n * price));
        
    }
    
    public static void checkout(Scanner keybd, int n, int price) {
        System.out.println("CHECKOUT");
        System.out.println("");
        System.out.print("What is your name? ");
        String name = keybd.next();
        view_order(n, price);
        System.out.println("Thanks for your order, "+name+"!");
        
    }   
}
