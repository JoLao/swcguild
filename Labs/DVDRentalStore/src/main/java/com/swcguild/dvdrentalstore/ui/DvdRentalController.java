/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.ui;

import com.swcguild.dvdrentalstore.dao.DvdRentalServiceLayer;
import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.AccountStatus;
import com.swcguild.dvdrentalstore.domain.Dvd;
import com.swcguild.dvdrentalstore.domain.Transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static javafx.scene.control.cell.ComboBoxTableCellBuilder.create;

/**
 *
 * @author apprentice
 */
public class DvdRentalController {

    ConsoleIO cIO;
    DvdRentalServiceLayer dvdRentalSvcLayer;

    LocalDate currentDate = LocalDate.now();
    //LocalDate.parse("2005-01-01", DateTimeFormatter.ISO_DATE)

    public void setcIO(ConsoleIO cIO) {
        this.cIO = cIO;
    }

    public void setDvdRentalSvcLayer(DvdRentalServiceLayer dvdRentalSvcLayer) {
        this.dvdRentalSvcLayer = dvdRentalSvcLayer;
    }

    public void run() {
        int menuChoice = 0;
        loadFiles();
        do {
            menuChoice = cIO.promptForInteger(" ________________________________________________________\n"
                    + "|                                                        |\n"
                    + "|                      MAIN MENU                         |\n"
                    + "|                                                        |\n"
                    + "|    Please make your selection from the menu below:     |\n"
                    + "|                                                        |\n"
                    + "|         1. List DVD By Title                           |\n"
                    + "|         2. List Blu Ray By Title                       |\n"
                    + "|         3. List All Videos Group By Type               |\n"
                    + "|         4. List All Videos By Title                    |\n"
                    + "|         5. List Available Videos By Title              |\n"
                    + "|         6. Checkout Video                              |\n"
                    + "|         7. Returning Video                             |\n"
                    + "|         8. Create Account                              |\n"
                    + "|         9. Update Account Information                  |\n"
                    + "|        10. Calculate Balance & Late Fees for Client    |\n"
                    + "|        11. Generate Report of Status of Each Movie     |\n"
                    + "|        12. Quit Program                                |\n"
                    + "|________________________________________________________|\n");

            switch (menuChoice) {
                case 1:
                    listDvdByTitle();
                    break;

                case 2:
                    listBluRayByTitle();
                    break;

                case 3:
                    listAllGroupByVideoType();
                    break;

                case 4:
                    listAllByTitle();
                    break;

                case 5:
                    listAllAvailableByTitle();
                    break;

                case 6:
                    checkOutVideo();
                    break;

                case 7:
                    returnVideo();
                    break;

                case 8:
                    createAccount();
                    break;

                case 9:
                    updateAccountInfo();
                    break;

                case 10:
                    calculateBalanceAndFees();
                    break;

                case 11:
                    generateReportOnStatusOfEachMovie();
                    break;
                case 12:
                    saveCurrentWork();
            }
        } while (menuChoice != 12);

    }

    private void loadFiles() {
        try {
            dvdRentalSvcLayer.loadCurrentFeesFile();
            dvdRentalSvcLayer.loadInventoryFile();
            dvdRentalSvcLayer.loadAccountFile();
        } catch (FileNotFoundException fnf) {
            cIO.printStringLn("File not found Exception. Contact developer." + fnf.getMessage());
        }
    }

    private void listDvdByTitle() {
        String title = enterTitle();

        List<Dvd> dvdList = dvdRentalSvcLayer.listDvdByTitle(title);
        displayList(dvdList);

    }

    private void listBluRayByTitle() {
        String title = enterTitle();

        List<Dvd> dvdList = dvdRentalSvcLayer.listBluRayByTitle(title);
        displayList(dvdList);

    }

    private void listAllGroupByVideoType() {
        Map<String, List<Dvd>> dvdMap = dvdRentalSvcLayer.listAllGroupByVideoType();

        Set<String> keys = dvdMap.keySet();
        Iterator<String> iter = keys.iterator();
        String videoType;
        List<Dvd> dvdList;
        while (iter.hasNext()) {
            videoType = iter.next();
            dvdList = dvdMap.get(videoType);
            cIO.printStringLn("Video Type : " + videoType);
            displayList(dvdList);
        }
    }

    private void listAllByTitle() {
        String title = enterTitle();

        List<Dvd> dvdList = dvdRentalSvcLayer.listAllByTitle(title);
        displayList(dvdList);

    }

    private void listAllAvailableByTitle() {
        String title = enterTitle();

        List<Dvd> dvdList = dvdRentalSvcLayer.listAllAvailableByTitle(title);
        displayList(dvdList);

    }

    private String enterTitle() {
        String title;
        do {
            title = cIO.promptForString("Enter title : ");
        } while (title.equals(""));
        return title;
    }

    private void displayList(List<Dvd> dvdList) {
        NumberFormat dvdNumFormat = new DecimalFormat("##");
        String available = "";
        String color = "\033[0m";

//        System.out.println("\033[0m BLACK");
//        System.out.println("\033[31m RED");
//        System.out.println("\033[32m GREEN");
//        System.out.println("\033[33m YELLOW");
//        System.out.println("\033[34m BLUE");
//        System.out.println("\033[35m MAGENTA");
//        System.out.println("\033[36m CYAN");
//        System.out.println("\033[37m WHITE");        
        if (dvdList.size() > 0) {
            cIO.printStringLn("DVD#  Video Type    Title                                              Director                  Rating    Released Date      Status");
            cIO.printStringLn("=========================================================================================================================================================");
            for (int i = 0; i < dvdList.size(); i++) {
                available = (dvdList.get(i).getCheckOutDate() == null ? "Available"
                        : "Checked out on " + dvdList.get(i).getCheckOutDate());
                color = available.equalsIgnoreCase("Available") ? "\033[0m" : "\033[31m";

                cIO.printString(color + String.format("%3s", dvdNumFormat.format(dvdList.get(i).getDvdNumber())));
                cIO.printString("   " + String.format("%-10s", dvdList.get(i).getVideoType()));
                cIO.printString("    " + String.format("%-50s", dvdList.get(i).getTitle()));
                cIO.printString(" " + String.format("%-25s", dvdList.get(i).getDirector()));
                cIO.printString(" " + String.format("%-6s", dvdList.get(i).getMpaaRating()));
//                cIO.printString("    " + String.format("%-20s",dvdList.get(i).getStudio()));
                cIO.printString("    " + String.format("%-10s", dvdList.get(i).getReleaseDate()));
//                cIO.printString(" " + String.format("%-20s",dvdList.get(i).getReviews()));                
                cIO.printStringLn("         " + String.format("%-25s", available));
            }
        } else {
            cIO.printStringLn("Not found/avalable.");
        }
        cIO.printStringLn("\033[0m");
    }

    private int enterDvdNumber(String action) {
        int dvdNumber = 0;
        do {
            try {
                dvdNumber = Integer.parseInt(cIO.promptForString("Enter Dvd Number [or any character to quit]: "));
                if (action.equalsIgnoreCase("returning") && dvdRentalSvcLayer.isDvdAvailable(dvdNumber)) {
                    cIO.printStringLn("Video is not checked out.");
                }
                if (action.equalsIgnoreCase("checkout") && !dvdRentalSvcLayer.isDvdAvailable(dvdNumber)) {
                    cIO.printStringLn(dvdNumber + " is not available.");
                }
            } catch (NumberFormatException e) {
                dvdNumber = 0;
                break;
            }
        } while ((action.equalsIgnoreCase("returning") && dvdRentalSvcLayer.isDvdAvailable(dvdNumber))
                || (action.equalsIgnoreCase("checkout") && !dvdRentalSvcLayer.isDvdAvailable(dvdNumber)));
        return dvdNumber;
    }

    private void checkOutVideo() {
        int dvdNumber;
        Dvd dvd;
        Account account;
        Transaction txn;

        int accountNumber = cIO.promptForInteger("Enter account number : ");
        if (!dvdRentalSvcLayer.checkIfAccountExists(accountNumber)) {
            cIO.printStringLn("Account not found.");
        } else {
            account = dvdRentalSvcLayer.getAccount(accountNumber);
            if (account.getStatus().equals(AccountStatus.DELINQUENT)) {
                cIO.printString("Your account has past dues. Please pay them first.");
            } else {
                dvdNumber = enterDvdNumber("checkout");

                if (dvdNumber > 0) {
                    displayFees();
                    dvd = dvdRentalSvcLayer.getDvd(dvdNumber);
                    cIO.printStringLn("You have rented a "+
                            (dvdRentalSvcLayer.isNewRelease(dvd) ? "newly released " : "classic ")
                            +dvd.getVideoType());
                    cIO.printStringLn("The fee is "+dvdRentalSvcLayer.determineFee(dvd));
                    dvd.setCheckOutDate(currentDate);
                    LocalDate dueDate = currentDate.plusDays(dvdRentalSvcLayer.getDuration());
                    cIO.printStringLn("The DVD is due on " + dueDate);
                    cIO.printStringLn("Enjoy & have a nice day!");
                    account.setStatus(AccountStatus.CHECKOUT);
                    //create transaction
                    txn = new Transaction();
                    txn.setAccountNumber(account.getAccountNumber());
                    txn.setCheckOutDate(LocalDate.now());
                    txn.setDvdNumber(dvd.getDvdNumber());
                    txn.setDateDue(dueDate);
                    txn.setDateReturned(null);
                    txn.setRentalFee(dvdRentalSvcLayer.determineFee(dvd));
                    txn.setLateFees(0);
                    txn.setBalance(dvdRentalSvcLayer.determineFee(dvd));
                    dvdRentalSvcLayer.addTransaction(txn);
                }
            }
        }
    }

    private void displayFees() {
        NumberFormat feeFormat = new DecimalFormat("$##.00");
        cIO.printStringLn("Price for classic DVD is " + feeFormat.format(dvdRentalSvcLayer.getDvdFee()));
        cIO.printStringLn("Price for new release is " + feeFormat.format(dvdRentalSvcLayer.getDvdFeeForNewRelease()));
        cIO.printStringLn("Additional cost for BluRay is " + feeFormat.format(dvdRentalSvcLayer.getBluRayAdditionalFee()));
        cIO.printStringLn("Late fee is "+feeFormat.format(dvdRentalSvcLayer.getLateFee())+"/day");
        cIO.printStringLn("========================================================");
    }

    private void returnVideo() {
        int dvdNumber = enterDvdNumber("returning");
        NumberFormat feeFormat = new DecimalFormat("$##.00");
        Dvd dvd;
        double totalFee = 0;
        String explanation1 = "";
        String explanation2 = "";

        if (dvdNumber > 0) {
            dvd = dvdRentalSvcLayer.getDvd(dvdNumber);
            if (dvd.getCheckOutDate() != null) {
                displayFees();
                cIO.printStringLn("Fees applied : " + feeFormat.format(dvdRentalSvcLayer.determineFee(dvd)));
                cIO.printString("Late fees    : " + feeFormat.format(dvdRentalSvcLayer.computeLateFees(dvd)));
                cIO.printStringLn(" Days Elapsed : " + dvdRentalSvcLayer.computeDaysElapsed(dvd));
                cIO.printStringLn("--------------------------------------");
                cIO.printStringLn("Total        : " + feeFormat.format(dvdRentalSvcLayer.computeFees(dvd)));
                cIO.printStringLn(" ");
                cIO.printStringLn("Thank you! Come again.");
                dvd.setCheckOutDate(null);
            }
        }

    }

    private void createAccount() {
        String userId;
        String name;
        String address;
        String city;
        String state;
        String zipCode;
        String phone;
        String email;

        Account account = new Account();

        userId = cIO.promptForString("User Id : ");
        name = cIO.promptForString("Name    : ");
        address = cIO.promptForString("Address : ");
        city = cIO.promptForString("City    : ");
        state = cIO.promptForString("State   : ");
        zipCode = cIO.promptForString("Zip Code: ");
        phone = cIO.promptForString("Phone   : ");
        email = cIO.promptForString("Email   : ");

        account.setUserId(userId);
        account.setName(name);
        account.setAddress(address);
        account.setAddress(address);
        account.setCity(city);
        account.setState(state);
        account.setZipCode(zipCode);
        account.setPhone(phone);
        account.setEmail(email);

        dvdRentalSvcLayer.addAccount(account);
    }

    private void updateAccountInfo() {
        int accountNumber;
        String userId;
        String name;
        String address;
        String city;
        String state;
        String zipCode;
        String phone;
        String email;
        Account account;
        boolean updated = false;

        accountNumber = cIO.promptForInteger("Enter account number : ");
        if (!dvdRentalSvcLayer.checkIfAccountExists(accountNumber)) {
            cIO.printStringLn("Account not found.");
        } else {
            account = dvdRentalSvcLayer.getAccount(accountNumber);
            userId = cIO.promptForString("User Id : " + account.getUserId());
            name = cIO.promptForString("Name    : " + account.getName());
            address = cIO.promptForString("Address : " + account.getAddress());
            city = cIO.promptForString("City    : " + account.getCity());
            state = cIO.promptForString("State   : " + account.getState());
            zipCode = cIO.promptForString("Zip Code: " + account.getZipCode());
            phone = cIO.promptForString("Phone   : " + account.getPhone());
            email = cIO.promptForString("Email   : " + account.getEmail());

            if (!userId.equals(account.getUserId())) {
                account.setUserId(userId);
                updated = true;
            }
            if (!name.equalsIgnoreCase(account.getName())) {
                account.setName(name);
                updated = true;
            }
            if (!address.equalsIgnoreCase(account.getAddress())) {
                account.setAddress(address);
                updated = true;
            }
            if (!city.equalsIgnoreCase(account.getCity())) {
                account.setCity(city);
                updated = true;
            }
            if (!state.equalsIgnoreCase(account.getState())) {
                account.setState(state);
                updated = true;
            }
            if (!zipCode.equalsIgnoreCase(account.getZipCode())) {
                account.setZipCode(zipCode);
                updated = true;
            }
            if (!phone.equalsIgnoreCase(account.getPhone())) {
                account.setPhone(phone);
                updated = true;
            }
            if (!email.equalsIgnoreCase(account.getEmail())) {
                account.setEmail(email);
                updated = true;
            }
            if (updated = true) {
                cIO.printStringLn("Account updated.");
            }
        }

    }

    private void calculateBalanceAndFees() {
        int accountNumber = cIO.promptForInteger("Enter account number : ");

        if (!dvdRentalSvcLayer.checkIfAccountExists(accountNumber)) {
            cIO.printStringLn("Account not found.");
        } else {

        }

    }

    private void generateReportOnStatusOfEachMovie() {

    }

    private void saveCurrentWork() {
        try {
            dvdRentalSvcLayer.saveInventoryFile();
        } catch (IOException fnf) {
            cIO.printStringLn("Error saving file. Please contact programmer.");
        }

    }
}
