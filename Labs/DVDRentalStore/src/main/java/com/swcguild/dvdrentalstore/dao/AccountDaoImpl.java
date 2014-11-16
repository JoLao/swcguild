/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.AccountStatus;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AccountDaoImpl implements AccountDao {
    private String mode = "PROD";
    
    private HashMap<Integer, Account>           accountMap     = new HashMap<>();

    @Override
    public void loadAccountFile() throws FileNotFoundException {
        String inputFile = mode.equalsIgnoreCase("PROD") ? ACCOUNT_FILE  : ACCOUNT_FILE_TEST;
        
        Scanner in = new Scanner(new FileReader(inputFile));
        
        String   currentRecord;
        String[] currentTokens;
        Account  currentAccount;
        while (in.hasNext()) {
            currentRecord  = in.nextLine();
            currentTokens  = currentRecord.split(DELIMITER);
            currentAccount = new Account();
            
            currentAccount.setAccountNumber(Integer.parseInt(currentTokens[0]));
            currentAccount.setUserId(currentTokens[1]);
            currentAccount.setName(currentTokens[2]);
            currentAccount.setAddress(currentTokens[3]);
            currentAccount.setCity(currentTokens[4]);
            currentAccount.setState(currentTokens[5]);            
            currentAccount.setZipCode(currentTokens[6]);
            currentAccount.setPhone(currentTokens[7]);
            currentAccount.setEmail(currentTokens[8]);
            currentAccount.setStatus(AccountStatus.valueOf(currentTokens[9]));
            addAccount(currentAccount);
        }
        in.close();
    }


    public List<Account> listAllAccounts() {        
        return Arrays.asList(accountMap.values().toArray(new Account[0]));
    }
    
    @Override
    public void addAccount(Account account) {
        account.setAccountNumber((getLastAccountNumber() + 1));
        account.setStatus(AccountStatus.GOOD);
        accountMap.put(account.getAccountNumber(), account);
    }

    @Override
    public int getLastAccountNumber() {
        return (!accountMap.isEmpty() ? Collections.max(accountMap.keySet()) : 0);
    }    
    
    
    @Override
    public Account getAccount(int accountNumber) {
        return accountMap.get(accountNumber);
    }
 
    @Override
    public boolean checkIfAccountExists(int accountNumber) {
        return accountMap.containsKey(accountNumber);
    }
    
    @Override
    public void saveAccountFile() throws IOException {
        String outputFile = mode.equalsIgnoreCase("PROD") ? ACCOUNT_FILE : ACCOUNT_FILE_TEST;
                
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        
        Collection<Account> values = accountMap.values();
        Iterator<Account>    iter   = values.iterator();
        Account currentAccount;
        while(iter.hasNext()) {
            currentAccount = iter.next();
            out.println(currentAccount.getAccountNumber() + DELIMITER
                      + currentAccount.getUserId() + DELIMITER
                      + currentAccount.getName() + DELIMITER
                      + currentAccount.getAddress() + DELIMITER
                      + currentAccount.getCity() + DELIMITER
                      + currentAccount.getState() + DELIMITER
                      + currentAccount.getZipCode() + DELIMITER
                      + currentAccount.getPhone() + DELIMITER
                      + currentAccount.getEmail() + DELIMITER
                      + currentAccount.getStatus());
            out.flush();
        }
       out.close();
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }
 
    
}
