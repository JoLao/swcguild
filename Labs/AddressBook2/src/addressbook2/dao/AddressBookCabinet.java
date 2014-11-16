/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook2.dao;

import addressbook2.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//In this lab you will add the following features to your address book: 
// 
//1. Your address book must be able to handle multiple address entries with the same last 
//name. 
//2. Searching by last name must return some sort of Collection or array of Address objects. 
//3. The user must be able to search addresses by City 
//4. The user must be able to search addresses by State 
//a. When searching by state, the results must be sorted into separate data 
//structures by City 
//5. The user must be able to search addresses by Zipcode 
//6. You must use an ArrayList rather than a HashMap to hold the Address objects. 
//7. You must create an Interface for the AddressBook API (i.e. your DAO) that contains all of 
//the methods specified here and in AddressBook Version 1. 
//8. You must create an AddressBookImpl class that implements the AddressBook interface ­ 
//you must use Lambdas, Streams, and Aggregates in your implementation. 
public interface AddressBookCabinet {
    public Address addAddress(String lastName, Address address);
    public Address removeAddress(Address address);
    public int getNumberOfAddresses();
    public Address[] listAllAddressesArray();
    public List<Address> listAllAddressesList();
    public Address[] findAddressArray(String lastName);
    public List<Address> listAddressesByLastName(String lastName);
    public List<Address> listAddressesByCity (String city);
    public Map<String, List<Address>> listAddressesByState (String state);
    public List<Address> listAddressesByZip (String zip);
    
    public void loadFromFile(String inputFile) throws FileNotFoundException ;
    public void saveToFile(String outputFile) throws IOException;
}
