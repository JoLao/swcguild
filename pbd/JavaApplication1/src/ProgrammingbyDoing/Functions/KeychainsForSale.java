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
public class KeychainsForSale {
    public static void main(String[] args) {
        System.out.println("Ye Olde Keychain Shoppe");
        int choice;
        
        displayMenu();
        do {
            Scanner keybd = new Scanner(System.in);
            System.out.print("Please enter your choice: ");
            choice = keybd.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    add_keychains();
                    displayMenu();
                    break;
                case 2:
                    remove_keychains();
                    displayMenu();
                    break;
                case 3:
                    view_order();
                    displayMenu();
                    break;
                case 4:
                    checkout();
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
    
    public static void add_keychains() {
        System.out.println("ADD KEYCHAINS");
    }
    
    public static void remove_keychains() {
        System.out.println("REMOVE KEYCHAINS");
    }
        
    public static void view_order() {
        System.out.println("VIEW ORDER");
    }
    
    public static void checkout() {
        System.out.println("CHECKOUT");
    }
}
