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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook3 {

    private HashMap<String, ArrayList<Address>> addressMap = new HashMap<String, ArrayList<Address>>();
    private static int counter = 0;

    public static final String ADDRESS_FILE = "addressbookLab.txt";
    public static final String DELIMITER = "::";

    public Address addAddress(String lastName, Address address) {
        ArrayList<Address> addrList = new ArrayList<>();
        boolean lastNamePresent = addressMap.containsKey(lastName);

        if (lastNamePresent) {
            addrList = addressMap.get(lastName);
        }
        addrList.add(address);

        if (!lastNamePresent) {
            addressMap.put(lastName, addrList);
        }
        counter++;
        return address;
    }

    public Address removeAddress(Address address) {
        ArrayList<Address> addrList = new ArrayList<>();
        boolean lastNamePresent = addressMap.containsKey(address.getLastName());

        if (lastNamePresent) {
            addrList = addressMap.get(address.getLastName());
            addrList.remove(address);
            counter--;
            if (addrList.isEmpty()) {
                addressMap.remove(address.getLastName());
                System.out.println("map entry removed");
            }
        } else {
            address = null;
        }

        return address;
    }

    public int getNumberOfAddresses() {
        return counter;
    }

    public Address[] listAllAddressesArray() {

        ArrayList<Address> addrList = listAllAddressesArrayList();

        Address[] addressArray = addrList.toArray(new Address[0]);

        return addressArray;
    }

    public ArrayList<Address> listAllAddressesArrayList() {
        Collection<ArrayList<Address>> values = addressMap.values();
        Iterator<ArrayList<Address>> iter = values.iterator();
        ArrayList<Address> addrList = new ArrayList<>();

        while (iter.hasNext()) {
            addrList.addAll(iter.next());
        }

        return addrList;
    }

    public Address[] findAddressArray(String lastName) {
        ArrayList<Address> addrList = findAddressArrayList(lastName);

        Address[] addressArray = addrList.toArray(new Address[0]);

        return addressArray;
    }

    public ArrayList<Address> findAddressArrayList(String lastName) {
        ArrayList<Address> addrList = addressMap.get(lastName);
        return addrList;
    }

    public void loadFromFile(String inputFile) throws FileNotFoundException {
        ArrayList<Address> addrList = new ArrayList<>();

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

    public void saveToFile(String outputFile) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        ArrayList<Address> addrList = listAllAddressesArrayList();

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
