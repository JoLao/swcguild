package addressbook2.dao;

import addressbook2.domain.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookImpl implements AddressBookCabinet {

    private List<Address> addressList = new ArrayList<>();

    public static final String ADDRESS_FILE = "addressbookLab.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String lastName, Address address) {

        addressList.add(address);        
        
        return address;
    }

    @Override
    public Address removeAddress(Address address) {
        addressList.remove(address);
        return address;
    }

    @Override
    public int getNumberOfAddresses() {
        
        return addressList.size();
    }

    @Override
    public Address[] listAllAddressesArray() {

        return addressList.toArray(new Address[0]);
    }

    @Override
    public List<Address> listAllAddressesList() {
        
        Collections.sort(addressList);
        return addressList;
    }
       

    @Override
    public Address[] findAddressArray(String lastName) {
        
        return listAddressesByLastName(lastName).toArray(new Address[0]);
    }

     @Override
    public List<Address> listAddressesByLastName(String lastName) {
        
        return addressList.stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        
    }

    @Override
    public List<Address> listAddressesByCity(String city) {
        return addressList.stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Address>>  listAddressesByState(String state) {
        return addressList.stream()
                .filter(a -> a.getState().equalsIgnoreCase(state))
                .collect(Collectors.groupingBy(a -> a.getCity()));
    }

    @Override
    public List<Address> listAddressesByZip(String zip) {
        return addressList.stream()
                .filter(a -> a.getZipCode().equalsIgnoreCase(zip))
                .collect(Collectors.toList());
    }

    @Override
    public void loadFromFile(String inputFile) throws FileNotFoundException {
        List<Address> addrList = new ArrayList<>();

        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));

        String currentLine;
        String[] currentTokens;
        Address currentAddr;
        while (in.hasNextLine()) {
            //get the line
            currentLine = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            if (currentTokens.length == 6) {
                currentAddr = new Address(currentTokens[0], currentTokens[1],
                        currentTokens[2], currentTokens[3],
                        currentTokens[4], currentTokens[5]);
                addAddress(currentTokens[0], currentAddr);
            }

        }
        in.close();

    }

    @Override
    public void saveToFile(String outputFile) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        List<Address> addrList = listAllAddressesList();

        Iterator<Address> iter = addrList.iterator();
        Address currentAddress;
        while (iter.hasNext()) {
            currentAddress = iter.next();
            out.println(currentAddress.getLastName() + DELIMITER + currentAddress.getFirstName()
                    + DELIMITER + currentAddress.getAddress() + DELIMITER + currentAddress.getCity()
                    + DELIMITER + currentAddress.getState() + DELIMITER + currentAddress.getZipCode());
            //force write
            out.flush();
        }
        out.close();
    }   
}
