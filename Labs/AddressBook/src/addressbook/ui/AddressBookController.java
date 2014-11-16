package addressbook.ui;

import addressbook.dao.AddressBook;
import addressbook.dao.AddressBook2;
import addressbook.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookController {

    private ConsoleIO io = new ConsoleIO();
    private AddressBook  addressBook  = new AddressBook();
    private AddressBook2 addressBook2 = new AddressBook2();    

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
                    findAddress();
                    break;
                case 6:
                    editAddress();
                    break;

                case 7:
                    loadAddressBook();
                    break;
                case 8:
                    saveAddressBook();
                    break;
                case 9:
                    listAddressesByLastName();
            }
            mainMenu = goToMainMenu();
        } while (mainMenu == 1);
    }

    private int displayMenu() {
        System.out.println("Initial Menu: Please select the operation you wish to perform:");
        System.out.println("1. Add Address");
        System.out.println("2. Delete Address");
        System.out.println("3. Get Number of Addresses");
        System.out.println("4. List All Addresses");
        System.out.println("5. Find Address by Last Name");
        System.out.println("6. Enter Last Name of Address to Edit");
        System.out.println("7. Load Address Book from File");
        System.out.println("8. Save Address Book to File");
        System.out.println("9. List All Addresses by Last Name");
        System.out.println("");
        int option = io.promptForIntegerWithRange("Enter Choice Now ", 1, 9);
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
        Address addr = new Address(lastName, firstName, address, city, state, zipCode);
        addressBook.addAddress(lastName, addr);
        System.out.print("Address Added. ");
    }

    private void removeAddress() {
        String lastName = io.promptForString("Please Enter Last Name: ");
        Address addr = findAddress();
        String  isDelete;
        if (addr != null) {
            do {
                isDelete = io.promptForString("Really delete? ");
            } while (!isDelete.equalsIgnoreCase("y") && !isDelete.equalsIgnoreCase("n"));

            if (isDelete.equalsIgnoreCase("y")) {
                addressBook.removeAddress(lastName);
                System.out.println("Address Removed");
            } else {
                System.out.println("Address Not Removed");
            }
        }
        
    }

    private void getNumberOfAddresses() {
        System.out.print("There are " + addressBook.getNumberOfAddresses() + " in the book.");
    }

    private void listAllAddresses() {
        Address[] addressArray = addressBook.listAllAddresses();
        System.out.println("List Addresses Menu:");
        for (Address addr : addressArray) {
            this.detailedInfo(addr);
            System.out.println("");
        }
    }

    private Address findAddress() {
        String lastName = io.promptForString("Please Enter Last Name: ");
        Address addr = addressBook.findAddress(lastName);
        System.out.println("");
        this.detailedInfo(addr);        
        System.out.println("");
        return addr;
    }

    private void detailedInfo(Address addr) {
        System.out.println(addr.getFirstName() + " " + addr.getLastName());
        System.out.println(addr.getAddress());
        System.out.println(addr.getCity()+", "+addr.getState()+" "+addr.getZipCode());
    }
    
    private void editAddress() {
        Address addr = findAddress();

        String firstName = "";
        String address   = "";
        String city      = "";
        String state     = "";
        String zipCode   = "";
        String isChange  = "";
        if (addr == null) {
            System.out.println("Last Name Not Found in Address");
        } else {
            //firstName = addr.getFirstName();
            //address = addr.getAddress();
            do {
                isChange = io.promptForString("Do you want to change First Name? ");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));

            if (isChange.equalsIgnoreCase("y")) {
                firstName = io.promptForString("Please enter new First Name: ");
                addr.setFirstName(firstName);
            }

            do {
                isChange = io.promptForString("Do you want to change Address? ");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));

            if (isChange.equalsIgnoreCase("y")) {
                address = io.promptForString("Please enter new Address: ");
                addr.setAddress(address);
            }
            
            do {
                isChange = io.promptForString("Do you want to change City? ");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));

            if (isChange.equalsIgnoreCase("y")) {
                city = io.promptForString("Please enter new City: ");
                addr.setCity(city);
            }
            
            do {
                isChange = io.promptForString("Do you want to change State? ");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));

            if (isChange.equalsIgnoreCase("y")) {
                state = io.promptForString("Please enter new State: ");
                addr.setState(state);
            }
            
            do {
                isChange = io.promptForString("Do you want to change ZipCode ? ");
            } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));

            if (isChange.equalsIgnoreCase("y")) {
                zipCode = io.promptForString("Please enter new ZipCode: ");
                addr.setZipCode(zipCode);
            }
        }

    }

    private void loadAddressBook() {
        String inputFile = io.promptForString("Input File: ");

        try {
            addressBook.loadFromFile(inputFile);
            addressBook2.loadFromFile(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        }

    }
    
    private void saveAddressBook() {
        String outputFile = io.promptForString("Output File: ");
        
        try {
            addressBook.saveToFile(outputFile);            
        } catch (IOException e) {
            System.out.println("IO Exception Error : "+e.getMessage());
        }
    }
    
    private void listAddressesByLastName(){
        Address[] list;
        
        String lastName = io.promptForString("Please Enter Last Name: ");
        list = addressBook2.listAddressesByLastName(lastName);
        
        for (int i=0; i < list.length; i++) {
            System.out.println(list[i].getLastName()+", "+list[i].getFirstName()+" "+
                               list[i].getAddress()+", "+list[i].getCity()+", "+
                               list[i].getState()+" "+list[i].getZipCode());
        }
    }
}
