/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

//Requirements
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//Design a program which acts as an ATM machine. The user can specify a PIN and it shows 
//them a menu of their account types (checking and savings). Allow the user to deposit or 
//withdraw money from a selected account type. Be sure to check that they cannot withdraw more 
//money than they have or if they deposit more than $10k dollars, it lets the user know it will have 
//to contact the bank manager to clear the deposit and won't let them then withdraw any of that 
//money. 
// 
//Tips
//This is a classic example of class inheritance. Create an Account class which will serve as the 
//basis of both types of accounts. A checking and savings account are both accounts right? They 
//will inherit from the base Account class. Keep basic functionality in the base class like deposit() 
//and withdraw() and then override them in the specific account types. A savings account may 
//also have things like interest applied or a penalty for withdrawing any money. Take this into 
//account when you override those methods. The variable ​
//balance​
// would also be a protected 
//member of the base class. 
// 
//Phase 2
//Allow the checking account to go into negative and apply an overdraft fee of $10. Don't let the 
//user go into overdraft protection more than $100. You could also prevent the user from making 
//multiple withdraws if they are already overdrawn. 
public class BankAccountManager {

    private HashMap<String, CheckingAccount> checkingAcctMap = new HashMap<>();
    private HashMap<String, SavingsAccount> savingsAcctMap = new HashMap<>();

    private CheckingAccount checking;
    private SavingsAccount savings;

    private ConsoleIO io = new ConsoleIO();

    public static void main(String[] args) {
        BankAccountManager bankAcctMgr = new BankAccountManager();
        bankAcctMgr.run();
    }

    public void run() {

        try {
            loadAccounts();
            atmProcess();

        } catch (FileNotFoundException e) {
            System.out.println("ATM down. Please try again later");
        }

    }

    private void atmProcess() {
        String atmNumber = io.promptForString("Plase enter atm number : ");

        checking = searchForChecking(atmNumber);
        savings = searchForSavings(atmNumber);

        boolean isDone = false;

        int choice = -1;
        int option = -1;
        int numAcct = 0;
        String continueSW;

        if (checking == null && savings == null) {
            System.out.println("Account not found.");
        } else {
            if (checkPin()) {
                do {
                    choice = pickAccount();

                    option = displayAccountOptions();
                    switch (option) {
                        case 1:
                            if (choice == 1) {
                                displayBalance(checking);
                            } else {
                                displayBalance(savings);
                            }
                            break;
                        case 2:
                            withdrawMoneyProcess(choice);
                            break;
                        case 3:
                            makeADeposit(choice);
                            break;
                        case 4:
                            System.out.println("Thank you for banking with us. Goodbye!");

                    }
                    continueSW = io.promptForString("Do you want another transaction [y/n]? ");
                    if (continueSW.equalsIgnoreCase("n")) {
                        isDone = true;
                    }
                } while (!isDone);
            }

        }
    }

    private CheckingAccount searchForChecking(String atmNumber) {
        Set<String> keys = checkingAcctMap.keySet();
        Iterator<String> iter = keys.iterator();
        String[] nums;
        String currentKey;
        boolean acctFound = false;
        CheckingAccount checking = new CheckingAccount();

        while (iter.hasNext()) {
            currentKey = iter.next();
            nums = currentKey.split(" ");
//            System.out.println("currentkey " + currentKey);
//            System.out.println("atmnbr  = " + atmNumber);
//            System.out.println("nums[0] = " + nums[0] + " " + nums[1]);
            if (nums[0].equals(atmNumber)) {
                checking = checkingAcctMap.get(currentKey);
                break;
            }
        }
        return checking;
    }

    private SavingsAccount searchForSavings(String atmNumber) {
        Set<String> keys = savingsAcctMap.keySet();
        Iterator<String> iter = keys.iterator();
        String[] nums;
        String currentKey;
        boolean acctFound = false;
        SavingsAccount savings = new SavingsAccount();

        while (iter.hasNext()) {
            currentKey = iter.next();
            nums = currentKey.split(" ");
            if (nums[0].equals(atmNumber)) {
                savings = savingsAcctMap.get(currentKey);
                break;
            }
        }
        return savings;
    }

    private boolean checkPin() {
        String pin = io.promptForString("Please enter pin number : ");
        int attempt = 0;
        boolean pinVerified = false;

        while (attempt < 3) {
            if (checking != null) {
                if (pin.equals(checking.getPin())) {
                    pinVerified = true;
                    break;
                }
            } else {
                if (pin.equals(savings.getPin())) {
                    pinVerified = true;
                    break;
                }
            }

            attempt++;
        }
        if (attempt > 2 && !pinVerified) {
            System.out.println("Too many attempts. ATM Card locked. Please see bank manager.");
        }
        return pinVerified;
    }

    private int pickAccount() {
        int choice = 0;
        System.out.println("");
        if (checking != null && savings != null) {
            System.out.println("Hello, " + checking.getName());
            System.out.println("Please select an account:");
            System.out.println("1) Checking - " + checking.getAccountNbr());
            System.out.println("2} Savings  = " + savings.getAccountNbr());
            choice = io.promptForIntegerWithRange("Please select one ", 1, 2);
        } else if (checking != null) {
            System.out.println("Hello, " + checking.getName());
            System.out.println("Checking - " + checking.getAccountNbr());
            choice = 1;
        } else {
            System.out.println("Hello, " + savings.getName());
            System.out.println("Savings - " + savings.getAccountNbr());
            choice = 2;
        }
        return choice;
    }

    private int displayAccountOptions() {
        int choice = 0;

        System.out.println("");
        System.out.println("Account Menu ");
        System.out.println("1) Account Balance Inquiry");
        System.out.println("2) Account Withdrawal");
        System.out.println("3) Make a Deposit");
        System.out.println("4) Exit");

        choice = io.promptForIntegerWithRange("Please enter option ", 1, 4);
        return choice;
    }

    private void displayBalance(Account account) {
        System.out.println("");
        System.out.println("Your balance is           : " + account.getBalance());
        System.out.println("Your available balance is : " + account.getAvailableBalance());
    }

    private void withdrawMoneyProcess(int choice) {
        int result = 0;
        double money = io.promptForDouble("Amount : ");
        if (choice == 1) {
            result = withdrawMoney(checking, money);
            switch (result) {
                case 0:
                    System.out.println("Please take money.");
                    break;
                case -1:
                    System.out.println("Insufficent funds.");
                    break;
                case -2:
                    System.out.println("Insufficient funds. Overdraft applied.");
                    System.out.println("Please take money.");
            }
            displayBalance(checking);
        } else {
            result = withdrawMoney(savings, money);
            switch (result) {
                case 0:
                    System.out.println("Please take money.");
                    break;
                case -1:
                    System.out.println("Insufficient funds.");
            }
            displayBalance(savings);
        }

    }

    private int withdrawMoney(Account account, double money) {
        int result = account.withdraw(money);
        return result;
    }

    private void makeADeposit(int choice) {
        int result = 0;
        double money = io.promptForDouble("Amount : ");
        if (choice == 1) {
            result = depositMoney(checking, money);
        } else {
            result = depositMoney(savings, money);
        }
        switch (result) {
            case 0:
                System.out.println("Money deposited.");
                break;

            case -1:
                System.out.println("Please be adviced that deposit amount of $10,0000 or more "
                        + "will not be available for immediate withdrawal.");
                System.out.println("Transaction will be reported to bank manager to clear deposit.");
                break;
        }
    }

    private int depositMoney(Account account, double money) {
        int result = account.deposit(money);
        return result;
    }

    private void loadAccounts() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader("checking.txt")));
        String DELIMITER = "::";

        String currentRecord;
        String[] currentTokens;
        CheckingAccount checking;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);

            //John::ATM1000001:12345::1000000100::1000.00::900.00
            checking = new CheckingAccount();
            checking.setName(currentTokens[0]);
            checking.setAccountType("Checking");
            checking.setAtmNbr(currentTokens[1]);
            checking.setPin(currentTokens[2]);
            checking.setAccountNbr(currentTokens[3]);
            checking.setBalance(Double.parseDouble(currentTokens[4]));
            checking.setAvailableBalance(Double.parseDouble(currentTokens[5]));

            checkingAcctMap.put(currentTokens[1] + " " + currentTokens[3], checking);
//            System.out.println(currentTokens[0] + " " + currentTokens[1] + " " + currentTokens[2] + " "
//                    + currentTokens[3] + " " + currentTokens[4] + " " + currentTokens[5]);
//            System.out.println("checking " + checking.getAtmNbr() + " " + checking.getPin());
        }
        in.close();

        in = new Scanner(new BufferedReader(new FileReader("savings.txt")));

        SavingsAccount savings;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            savings = new SavingsAccount();
            savings.setName(currentTokens[0]);
            savings.setAccountType("Savings");
            savings.setAtmNbr(currentTokens[1]);
            savings.setPin(currentTokens[2]);
            savings.setAccountNbr(currentTokens[3]);
            savings.setBalance(Double.parseDouble(currentTokens[4]));
            savings.setAvailableBalance(Double.parseDouble(currentTokens[5]));
            savings.setInterestRate(2.00);
            savingsAcctMap.put(currentTokens[1] + " " + currentTokens[3], savings);
//            System.out.println(currentTokens[0] + " " + currentTokens[1] + " " + currentTokens[2] + " "
//                    + currentTokens[3] + " " + currentTokens[4] + " " + currentTokens[5]);
//            System.out.println("savings " + savings.getAtmNbr() + " " + savings.getPin());
        }
        in.close();
    }
}
