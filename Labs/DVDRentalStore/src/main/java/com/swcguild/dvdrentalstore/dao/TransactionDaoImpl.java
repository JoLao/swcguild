package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Transaction;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class TransactionDaoImpl implements TransactionDao {
    private String mode = "PROD";
        
    private HashMap<Integer, List<Transaction>> transactionMap = new HashMap<>();
     

    @Override
    public void loadTransactionFile() throws FileNotFoundException {
        String inputFile = this.mode.equalsIgnoreCase("PROD") ? TRANSACTION_FILE : TRANSACTION_FILE_TEST;
        
        Scanner in = new Scanner(new FileReader(inputFile));
        
        String   currentRecord;
        String[] currentTokens;
        Transaction currentTxn;
        ComputeFeeUtility cmpFeeUtil = new ComputeFeeUtilityImpl();
        LocalDate date;
        while (in.hasNext()) {
//            private int       accountNumber;
//    private LocalDate checkOutDate;
//    private int       dvdNumber;
//    private LocalDate dateDue;
//    private LocalDate dateReturned;
//    private double    rentalFee;
//    private double    lateFees;    
//    private double    balance;
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            currentTxn = new Transaction();
            currentTxn.setAccountNumber(Integer.parseInt(currentTokens[0]));
            
            date = LocalDate.parse(currentTokens[1], DateTimeFormatter.ISO_DATE);
            currentTxn.setCheckOutDate(date);
            currentTxn.setDvdNumber(Integer.parseInt(currentTokens[2]));
            
            date = date.plusDays(2);
            
//            LocalDate dueDate = currentTxn.plusDays(dvdRentalSvcLayer.getDuration());
            
            
            currentTxn.setDateDue(LocalDate.parse(currentTokens[3], DateTimeFormatter.ISO_DATE));
            currentTxn.setDateReturned(LocalDate.parse(currentTokens[4], DateTimeFormatter.ISO_DATE));
            currentTxn.setRentalFee(Double.parseDouble(currentTokens[5]));
            currentTxn.setLateFees(Double.parseDouble(currentTokens[6]));
            currentTxn.setBalance(Double.parseDouble(currentTokens[6]));
            addTransaction(currentTxn);
        }
        in.close();
    }


    @Override
    public void saveTransactionFile() throws IOException {
        String outputFile = this.mode.equalsIgnoreCase("PROD") ? TRANSACTION_FILE : TRANSACTION_FILE_TEST;
        
        PrintWriter out = new PrintWriter(outputFile);
        
        Collection<List<Transaction>> values = transactionMap.values();
        Iterator<List<Transaction>>    iter  = values.iterator();
        
        List<Transaction> txnList = new ArrayList<>();
        Transaction txn;
        while (iter.hasNext()) {
            txnList = iter.next();
            for (Transaction t : txnList) {
                out.println(t.getAccountNumber() + DELIMITER
                          + t.getCheckOutDate()  + DELIMITER
                          + t.getDvdNumber()  + DELIMITER
                          + t.getDateDue()  + DELIMITER
                          + t.getDateReturned()  + DELIMITER
                          + t.getRentalFee()  + DELIMITER
                          + t.getLateFees()  + DELIMITER
                          + t.getBalance() + DELIMITER);
                out.flush();
            }
        }
        out.close();
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void addTransaction(Transaction txn) {
        List<Transaction> txnList = new ArrayList<>();
        
        if (transactionMap.containsKey(txn.getAccountNumber())) {
            transactionMap.get(txn.getAccountNumber()).add(txn);
        } else {
            txnList.add(txn);
            transactionMap.put(txn.getAccountNumber(), txnList);
        }
    }

    @Override
    public int getAccountOfWhoRented(int dvdNumber) {
        Set<Integer>      keys = transactionMap.keySet();
        Iterator<Integer> iter = keys.iterator();
        List<Transaction> txnList = new ArrayList<>();
        
        int accountNumber;
        while (iter.hasNext()) {
            accountNumber = iter.next();
            txnList = transactionMap.get(accountNumber);
            for (Transaction t : txnList) {
                if (t.getDvdNumber() == dvdNumber) {
                    return accountNumber;
                }
            }
        }
        return 0;
    }
    
}
