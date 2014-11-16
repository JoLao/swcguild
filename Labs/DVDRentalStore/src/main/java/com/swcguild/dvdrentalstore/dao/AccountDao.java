package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AccountDao {
    
    public static final String ACCOUNT_FILE          = "accounts.txt";
    public static final String ACCOUNT_FILE_TEST     = "accountstest.txt";
    public static final String TRANSACTION_FILE      = "transactions.txt";
    public static final String TRANSACTION_FILE_TEST = "transactionstest.txt";
    public static final String DELIMITER             = "::";    
    
    public void loadAccountFile() throws FileNotFoundException;    
    public void saveAccountFile() throws IOException;    
    public List<Account> listAllAccounts();
    
    public void setMode(String mode);
    
    public void addAccount(Account account);
    public int  getLastAccountNumber();
    public Account getAccount(int accountNumber);
    public boolean checkIfAccountExists(int accountNumber);
}
