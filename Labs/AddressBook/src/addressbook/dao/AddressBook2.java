
package addressbook.dao;

import addressbook.domain.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddressBook2 {

    private HashMap<String, Address> addressMap = new HashMap<String, Address>();
    private static int counter = 0;
    
    public static final String ADDRESS_FILE = "addressbookLab.txt";
    public static final String DELIMITER = "::";

    public Address addAddress(String lastName, Address address) {
        counter++;
        return addressMap.put(lastName, address);
    }

    public Address removeAddress(String lastName) {
        if (this.findAddress(lastName) != null)
            counter--;
        return addressMap.remove(lastName);
    }

    public int getNumberOfAddresses() {
        return counter;
    }

    public Address[] listAddressesByLastName(String lName) {
        Set<String>      keys  = addressMap.keySet();
        Iterator<String> iter  = keys.iterator();
        
        String[] names  = new String[2];
        String   currentLine;
        ArrayList<Address> list = new ArrayList<>();
        while (iter.hasNext()) {
            currentLine = iter.next();
            names       = currentLine.split(" ");
//            System.out.println(currentLine);
            if (names[0].equalsIgnoreCase(lName)) {
                list.add(addressMap.get(currentLine));
            }
        }
        return list.toArray(new Address[0]);
    }
    
    public Address[] listAllAddresses() {
        Collection<Address> values = addressMap.values();
        Address[] addressArray = values.toArray(new Address[0]);
        return addressArray;
    }

    public Address findAddress(String lastName) {
        return addressMap.get(lastName);
    }
    
    public void loadFromFile(String inputFile) throws FileNotFoundException{
               
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        
        String currentLine;
        String[] currentTokens;
        while (in.hasNextLine()) {
            //get the line
            currentLine   = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            if (currentTokens.length == 6) {
                addressMap.put(currentTokens[0]+" "+currentTokens[1], 
                               new Address(currentTokens[0], currentTokens[1], 
                                           currentTokens[2], currentTokens[3],
                                           currentTokens[4], currentTokens[5]));
                counter++;
            }
            
        }
        in.close();
        
    }
    
    public void saveToFile(String outputFile) throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        
        Collection<Address> values = addressMap.values();
        Iterator<Address>    iter  = values.iterator();
        Address currentAddress;
        while (iter.hasNext()) {
            currentAddress = iter.next();
            out.println(currentAddress.getLastName()+DELIMITER+currentAddress.getFirstName()+
                        DELIMITER+currentAddress.getAddress()+DELIMITER+currentAddress.getCity()+
                        DELIMITER+currentAddress.getState()+DELIMITER+currentAddress.getZipCode());
                        //force write
            out.flush();
        }
        out.close();
    }
    
}
