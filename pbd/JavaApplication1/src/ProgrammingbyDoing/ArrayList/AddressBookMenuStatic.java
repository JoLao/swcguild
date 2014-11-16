/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Write a program that functions as an address book. It should have entries containing at least the 
//following information: first and last name, phone number, address, and email address. You should 

//be able to add entries and remove entries, as well as printing out any given entry. It should save 
//entries to a file, and be able to read in entries from a file as well.
//
//The address book must be able to sort by at least one field (preferably last name). You may use 
//any sort for this that you like.
//
//The address book will almost certainly contain a fixed limit on the total number of entries. 
//However, it should be possible to increase this limit by simply changing a single line in your 
//program and then recompiling with no other modifications.
//
//An excellent program will be able to sort the entries by any field (first name, last name, phone number, 
//email address, etc).
//
//An excellent program will be able to display only entries matching a certain criteria (only last names 
//beginning with the letter 'M', for example).
//
//An excellent program easily and intelligently handles the use of multiple address books (multiple files).
//
//A spectacular program features the ability to move an entry from one address book to another.
public class AddressBookMenuStatic {

    public static ConsoleIO io = new ConsoleIO();

    public static ArrayList<AddressBook> addrBook = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        int choice = 0;

        AddressBook addr;
        choice = displayMenu();
        System.out.println("");
        while (choice != 8) {
            switch (choice) {
                case 1:
                    loadFromFile();
                    break;
                case 2:
                    saveToFile();
                    break;
                case 3:
                    addAnEntry();
                    break;
                case 4:
                    removeAnEntry();
                    break;
                case 5:
                    editAnEntry();
                    break;
                case 6:
                    sortAddressBook();
                    break;
                case 7:
                    addr = searchForAnEntry();
                    if (addr == null) {
                        System.out.println("Entry not found.");
                    } else {
                        System.out.println("");
                        System.out.println("Here is the information :");
                        addr.displayAddress();
                    }
            }
            choice = displayMenu();
        }
    }

    public static int displayMenu() {
        int choice = -1;
        while (choice < 0 || choice > 8) {
            System.out.println("");
            System.out.println("1) Load from file");
            System.out.println("2) Save to file");
            System.out.println("3) Add an entry");
            System.out.println("4) Remove an entry");
            System.out.println("5) Edit an existing entry");
            System.out.println("6) Sort the address book");
            System.out.println("7) Search for a specific entry");
            System.out.println("8) Quit");
            System.out.println("");
            choice = io.promptForInteger("Please choose what you'd like to do with the database: ");
        }
        return choice;
    }

    public static boolean loadFromFile() {

        Scanner in;
        String firstName = "";
        String lastName = "";
        String address = "";
        String phoneNum = "";
        String email = "";
        boolean isFound = true;
        String inputFile = "";

        do {
            try {
                inputFile = io.promptForString("Input File: ");
                in = new Scanner(new BufferedReader(new FileReader(inputFile)));
                isFound = true;
                while (in.hasNext()) {
                    firstName = in.next();
                    lastName = in.next();
                    phoneNum = in.next();
                    address = in.next();
                    email = in.next();
                    addrBook.add(new AddressBook(lastName, firstName, phoneNum, address, email));
                }
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                isFound = false;
            } catch (Exception e) {
                e.printStackTrace();
                isFound = false;
            }
        } while (!isFound);
        System.out.println("File loaded to ArrayList :" + addrBook);
        return isFound;
    }

    public static void saveToFile() {
        String outputFile = "";
        PrintWriter out;

        try {
            outputFile = io.promptForString("Output File: ");
            out = new PrintWriter(new FileWriter(outputFile));
            for (AddressBook addr : addrBook) {
                out.println(addr.toString());
               // System.out.println(addr.toString());
            }
            out.flush();
            out.close();
            System.out.println("Data saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addAnEntry() {
        System.out.println("Enter the following information :");
        String firstName = io.promptForString("  First Name  : ");
        String lastName = io.promptForString("  Last Name   : ");
        String phoneNum = io.promptForString("  Phone Number: ");
        String address = io.promptForString("  Address     : ");
        String email = io.promptForString("  Email       : ");

        addrBook.add(new AddressBook(lastName, firstName, phoneNum, address, email));
        System.out.println("Address saved to ArrayList : " + addrBook);

    }

    public static void removeAnEntry() {
        AddressBook addrEntry = searchForAnEntry();

        boolean isRemoved = false;

        if (addrEntry != null) {
            isRemoved = addrBook.remove(addrEntry);
            if (isRemoved) {
                System.out.println("Entry removed");
            } 
        } else {
            System.out.println("Entry not found");
        }

    }

    public static void editAnEntry() {
        AddressBook addrEntry = searchForAnEntry();
        String isChange  = "";
        String firstName = "";
        String lastName  = "";
        String phoneNum  = "";
        String address   = "";
        String email     = "";

        if (addrEntry != null) {
            firstName = addrEntry.getFirstName();
            lastName = addrEntry.getLastName();
            phoneNum = addrEntry.getPhoneNum();
            address = addrEntry.getAddress();
            email = addrEntry.getEmail();
            System.out.println("Current Information : ");
            System.out.println("   First Name  : " + addrEntry.getFirstName());
            do {
                isChange = io.promptForString("Do you want to change this entry [Y/N}");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
            if (isChange.equalsIgnoreCase("y")) {
                firstName = io.promptForString("Enter new first name: ");
                addrEntry.setFirstName(firstName);
            }
            System.out.println("   Last Name   : " + addrEntry.getLastName());
            do {
                isChange = io.promptForString("Do you want to change this entry [Y/N}");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
            if (isChange.equalsIgnoreCase("y")) {
                lastName = io.promptForString("Enter new last name: ");
                addrEntry.setLastName(lastName);
            }
            System.out.println("   Phone Number: " + addrEntry.getPhoneNum());
            do {
                isChange = io.promptForString("Do you want to change this entry [Y/N}");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
            if (isChange.equalsIgnoreCase("y")) {
                phoneNum = io.promptForString("Enter new phone number: ");
                addrEntry.setPhoneNum(phoneNum);
            }
            System.out.println("   Address     : " + addrEntry.getAddress());
            do {
                isChange = io.promptForString("Do you want to change this entry [Y/N}");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
            if (isChange.equalsIgnoreCase("y")) {
                address = io.promptForString("Enter new address     : ");
                addrEntry.setAddress(address);
            }
            System.out.println("   Email       : " + addrEntry.getEmail());
            do {
                isChange = io.promptForString("Do you want to change this entry [Y/N}");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
            if (isChange.equalsIgnoreCase("y")) {
                email = io.promptForString("Enter new email: ");
                addrEntry.setEmail(email);
            }
        }
    }

    public static void sortAddressBook() {
        if (addrBook.size() > 0) {
            Collections.sort(addrBook);
            System.out.println("ArrayList sorted.");
        } else {
            System.out.println("ArrayList is empty. Please load data from file first.");
        }

    }

    public static AddressBook searchForAnEntry() {
        Boolean entryFound = false;
        AddressBook addrEntry = null;
        if (addrBook.size() > 0) {
            System.out.println("Enter the following information :");
            String firstName = io.promptForString("  First Name  : ");
            String lastName  = io.promptForString("  Last Name   : ");

            for (AddressBook addr : addrBook) {
                if (addr.getFirstName().equals(firstName) && addr.getLastName().equals(lastName)) {
                    addrEntry = addr;
                    break;
                }
            }
        } else {
            System.out.println("ArrayList is empty. Please load data from file first.");
        }
        return addrEntry;
    }
}

