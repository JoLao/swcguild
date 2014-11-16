package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.Dvd;
import com.swcguild.dvdrentalstore.domain.Transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public interface TransactionDao {
        
    public static final String TRANSACTION_FILE      = "transactions.txt";
    public static final String TRANSACTION_FILE_TEST = "transactionstest.txt";
    public static final String DELIMITER             = "::";    
        
    public void loadTransactionFile() throws FileNotFoundException;    
    public void saveTransactionFile() throws IOException;
    
    public void setMode(String mode);
    
    public void addTransaction(Transaction txn);
 
    public int getAccountOfWhoRented(int dvdNumber);

}
