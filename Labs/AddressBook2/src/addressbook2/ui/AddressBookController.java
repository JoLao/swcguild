package addressbook2.ui;


import addressbook2.dao.AddressBookImpl;
import addressbook2.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ui.ConsoleIO;

public class AddressBookController {

    private ConsoleIO io = new ConsoleIO();
    private AddressBookImpl addressBook = new AddressBookImpl();

    public static void main(String[] args) {
        AddressBookController ui = new AddressBookController();
        ui.run();
    }

    public void run() {
        int mainMenu = 0;
        do {
            int userChoice = displayMenu();
            switch (userChoice) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    getNumberOfAddresses();
                    break;
                case 4:
                    listAllAddresses();
                    break;
                case 5:
                    findAddressByLastName();
                    break;
                case 6:
                    findAddressByCity();
                    break;
                case 7:
                    findAddressByState();
                    break;
                case 8:
                    findAddressByZipCode();
                    break;
                case 9:
                    editAddress();
                    break;
                case 10:
                    loadAddressBook();
                    break;
                case 11:
                    saveAddressBook();
                    break;                
            }
            if (userChoice != 12) {
                mainMenu = goToMainMenu();
            } else {
                mainMenu = 12;
            }
        } while (mainMenu == 1);
    }

    private int displayMenu() {
        System.out.println("Initial Menu: Please select the operation you wish to perform:");
        System.out.println(" 1. Add Address");
        System.out.println(" 2. Delete Address");
        System.out.println(" 3. Get Number of Addresses");
        System.out.println(" 4. List All Addresses");
        System.out.println(" 5. Find Address by Last Name");
        System.out.println(" 6. Find Address by City");
        System.out.println(" 7. Find Address by State");
        System.out.println(" 8. Find Address by Zip Code");
        System.out.println(" 9. Modify Address");
        System.out.println("10. Load Address Book from File");
        System.out.println("11. Save Address Book to File");
        System.out.println("12. Quit");
        System.out.println("");
        int option = io.promptForIntegerWithRange("Enter Choice Now ", 1, 12);
        return option;
    }

    private int goToMainMenu() {
        int n = 0;
        n = io.promptForInteger("Press 1 to go to Main Menu ");
        return n;
    }

    private void addAddress() {
        String firstName = io.promptForString("Please Enter First Name     : ");
        String lastName  = io.promptForString("Please Enter Last Name      : ");
        String address   = io.promptForString("Please Enter Street Address : ");
        String city      = io.promptForString("Please Enter City           : ");
        String state     = io.promptForString("Please Enter State          : ");
        String zipCode   = io.promptForString("Please Enter ZipCode        : ");
        Address addr     = new Address(lastName, firstName, address, city, state, zipCode);
        addressBook.addAddress(lastName, addr);
        System.out.print("Address Added. ");
    }

    private void removeAddress() {
        Address[] addrArray = findAddressByLastName();
        int entry = -1;
        String isDelete;

        if (addrArray.length == 0) {
            System.out.println("Address Book is empty. Please load data first.");
        } else {
            while (entry < 0 || entry >= addrArray.length) {
                entry = io.promptForInteger("Choose entry to delete : ");
            }

            do {
                isDelete = io.promptForString("Really delete? ");
            } while (!isDelete.equalsIgnoreCase("y") && !isDelete.equalsIgnoreCase("n"));

            if (isDelete.equalsIgnoreCase("y")) {
                System.out.println(addrArray[entry].getFirstName());
                addressBook.removeAddress(addrArray[entry]);
                System.out.println("Address removed.");
            } else {
                System.out.println("Address Not Removed");
            }
        }

    }

    private void getNumberOfAddresses() {
        System.out.print("There are " + addressBook.getNumberOfAddresses() + " in the book.");
    }

    private void listAllAddresses() {
        Address[] addressArray = addressBook.listAllAddressesArray();
        System.out.println("List Addresses Menu:");
        for (Address addr : addressArray) {
            this.detailedInfo(addr);
            System.out.println("");
        }
    }

    private Address[] findAddressByLastName() {
        String lastName = io.promptForString("Please Enter Last Name: ");
        Address[] addrArray = addressBook.findAddressArray(lastName);
        Address addr;

        System.out.println("");
        for (int i = 0; i < addrArray.length; i++) {
            addr = addrArray[i];
            System.out.println("Entry " + i);
            this.detailedInfo(addr);
            System.out.println("");
        }
        return addrArray;
    }

    private void findAddressByCity() {
        String city = io.promptForString("Please Enter City: ");
        List<Address> addrList = addressBook.listAddressesByCity(city);
        //Iterator<Address> iter = addrList.iterator();
        for (Address a : addrList) {
            io.printString("");
            this.detailedInfo(a);
        }
        
    }
    
    private void findAddressByState() {
        String state = io.promptForString("Please enter State: ");
        Map<String, List<Address>> addrMap = addressBook.listAddressesByState(state);
        
        Set              keys = addrMap.keySet();
        Iterator<String> iter = keys.iterator();
        List<Address>    addrList;
        String           city;
        while (iter.hasNext()) {
            city     = iter.next();
            io.printStringLn("");
            io.printStringLn("City : "+city);
            addrList = addrMap.get(city);
            for (Address a : addrList) {
                io.printStringLn("");
                this.detailedInfo(a);
            }
            
        }
    }
    
    private void findAddressByZipCode() {
        String zipCode = io.promptForString("Please enter Zip Code: ");
        List<Address> addrList = addressBook.listAddressesByZip(zipCode);
        
        for (Address a : addrList) {
            this.detailedInfo(a);
        }
    }
    
    private void detailedInfo(Address addr) {
        System.out.println(addr.getFirstName() + " " + addr.getLastName());
        System.out.println(addr.getAddress());
        System.out.println(addr.getCity() + ", " + addr.getState() + " " + addr.getZipCode());
    }

    private void editAddress() {
        Address[] addrArray = findAddressByLastName();
        int entry = -1;
        String firstName = "";
        String address = "";
        String city = "";
        String state = "";
        String zipCode = "";

        int choice = -1;
        Address addr;

        if (addrArray.length == 0) {
            System.out.println("Address Book is empty. Please load data first.");
        } else {
            while (entry < 0 || entry > addrArray.length) {
                entry = io.promptForInteger("Choose entry to edit: ");
            }
            addr = addrArray[entry];

            while (choice != 6) {
                choice = editMenu();
                switch (choice) {
                    case 1:
                        firstName = io.promptForString("Please enter new First Name: ");
                        addr.setFirstName(firstName);
                        break;

                    case 2:
                        address = io.promptForString("Please enter new Address: ");
                        addr.setAddress(address);
                        break;

                    case 3:
                        city = io.promptForString("Please enter new City: ");
                        addr.setCity(city);
                        break;

                    case 4:
                        state = io.promptForString("Please enter new State: ");
                        addr.setState(state);
                        break;

                    case 5:
                        zipCode = io.promptForString("Please enter new ZipCode: ");
                        addr.setZipCode(zipCode);
                }
            }

           
        }

    }

    private int editMenu() {
        System.out.println("Edit Menu: Please select the field to edit:");
        System.out.println("1. First Name");
        System.out.println("2. Street Address");
        System.out.println("3. City");
        System.out.println("4. State");
        System.out.println("5. ZipCode");
        System.out.println("6. Exit Edit Menu");
        System.out.println("");
        int option = io.promptForIntegerWithRange("Enter Choice Now ", 1, 6);
        return option;

    }

    private void loadAddressBook() {
        String inputFile = io.promptForString("Input File: ");

        try {
            addressBook.loadFromFile(inputFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        }

    }

    private void saveAddressBook() {
        String outputFile = io.promptForString("Output File: ");

        try {
            addressBook.saveToFile(outputFile);
        } catch (IOException e) {
            System.out.println("IO Exception Error : " + e.getMessage());
        }
    }

}
