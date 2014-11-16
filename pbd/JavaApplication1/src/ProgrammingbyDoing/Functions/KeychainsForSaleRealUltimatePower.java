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
public class KeychainsForSaleRealUltimatePower {
//You're going to add some error checking and additional features, to Keychains2.
//
//You need to make sure that the user always has a positive number, or 0, of keychains in the order.
//
//You need to check for a valid menu choice. If not, display an error message and show the menu again.
//
//You will need 3 new variables in main, one to store the sales tax (8.25%), one to store the shipping 
//cost per order ($5.00), and one to store the additional per keychain shipping cost ($1.00).
//
//view_order() will need to be passed the three additional variables, a total of five, and have a return 
//type of void. It will display, on different lines, the number of keychains in the order, the price per 
//keychain, the shipping charges on the order, the subtotal before tax, the tax on the order, and the 
//final cost of the order.
//
//view_order() might look like public static void view_order( int num_keychains, double price_per_keychain,
//double tax, int base_shipping, int per_keychain_shipping )
//
//checkout() will need to be passed the same values as view_order(), and have a return type of void. It 
//will ask the user for his/her name in order to deliver them correctly, then call view_order() to display 
//the order information, and then thank the user, by name, for ordering.    

    public static void main(String[] args) {
        System.out.println("Ye Olde Keychain Shoppe");
        int choice;
        int numKeyChains = 0;
        double price = 10;
        double salesTax = 8.25;
        double shippingCost = 5;
        double additionalShippingCost = 1;

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
                    view_order(numKeyChains, price, salesTax, shippingCost, additionalShippingCost);
                    displayMenu();
                    break;
                case 4:
                    checkout(keybd, numKeyChains, price, salesTax, shippingCost, additionalShippingCost);
                default:
                    System.out.println("Invalid choice");
                    choice = 0;
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

        System.out.print("You have " + n + " keychains. How many to add? ");
        addNum = keybd.nextInt();
        if (addNum > 0) {
            newTotal = n + addNum;
            System.out.println("You now have " + newTotal + " keychains.");
        } else {
            System.out.println("Nothing to add");
            newTotal = n;
        }
        return newTotal;
    }

    public static int remove_keychains(Scanner keybd, int n) {
        System.out.print("You have " + n + " keychains. How many to remove? ");
        int removeNum = keybd.nextInt();
        int newTotal = 0;

        if (removeNum > 0) {
            newTotal = n - removeNum;
            System.out.println("You now have " + newTotal + " keychains.");
        } else {
            System.out.println("Nothing to remove");
            newTotal = n;
        }

        return newTotal;
    }

    public static void view_order(int n, double price, double tax,
            double base_shipping, double per_keychain_shipping) {
//the shipping charges on the order, the subtotal before tax, the tax on the order, and the 
//final cost of the order.  
        double totalPrice = 0;
        double shippingTotal = 0;
        double taxTotal = 0;
        double subTotal = 0;
        double finalCost = 0;

        totalPrice = n * price;
        System.out.println("You have " + n + " keychains.");
        System.out.println("Keychains cost $" + price);
        System.out.println("Total cost is $" + totalPrice);
        if (n > 0) { //(n > 0) ? base_shipping : 0)
            shippingTotal = base_shipping + per_keychain_shipping * (n - 1);
        } else {
            shippingTotal = 0;
        }
        System.out.println("Shipping Charges $" + shippingTotal);
        subTotal = totalPrice + shippingTotal;
        System.out.println("Subtotal before tax $" + subTotal);
        taxTotal = (n * price) * tax / 100;
        System.out.println("Sales Tax $" + taxTotal);
        finalCost = subTotal + taxTotal;
        System.out.println("Final Cost $" + finalCost);
    }

    public static void checkout(Scanner keybd, int n, double price, double tax,
            double base_shipping, double per_keychain_shipping) {
        System.out.println("CHECKOUT");
        System.out.println("");
        if (n > 0) {
            System.out.print("What is your name? ");
            String name = keybd.next();
            view_order(n, price, tax, base_shipping, per_keychain_shipping);
            System.out.println("Thanks for your order, " + name + "!");
        } else {
            System.out.println("Nothing to checkout");
        }

    }
}
