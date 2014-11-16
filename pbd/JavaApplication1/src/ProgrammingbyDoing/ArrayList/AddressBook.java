
package ProgrammingbyDoing.ArrayList;
//Write a program that functions as an address book. It should have entries containing at least the 
//following information: first and last name, phone number, address, and email address. You should 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
public class AddressBook implements Comparable<AddressBook> {
    private String lastName;
    private String firstName;
    private String phoneNum;
    private String address;
    private String email;

    public AddressBook(String lastName, String firstName, String phoneNum, String address, String email) {
        this.lastName  = lastName;
        this.firstName = firstName;
        this.phoneNum  = phoneNum;
        this.address   = address;
        this.email     = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return firstName+" "+lastName+" "+phoneNum+" "+address+" "+email;
    }
    
    public void displayAddress() {
        System.out.println("First Name   : "+firstName);
        System.out.println("Last Name    : "+lastName);
        System.out.println("Phone Number : "+phoneNum);
        System.out.println("Address      : "+address);
        System.out.println("Email        : "+email);
    }
    
    public int compareTo(AddressBook compareAddrBook) {
        return this.firstName.compareTo(compareAddrBook.firstName);
    }

}
