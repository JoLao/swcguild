/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.Dvd;
import com.swcguild.dvdrentalstore.domain.Transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdRentalServiceLayer {

    void addAccount(Account account);

    void addTransaction(Transaction txn);

    double calculateBalanceByAccount(int accountNumber);

    void calculateBalanceOfAllAccounts();

    boolean checkIfAccountExists(int accountNumber);

    int computeDaysElapsed(Dvd dvd);

    double computeFees(Dvd dvd);

    double computeLateFees(Dvd dvd);

    double determineFee(Dvd dvd);

    Account getAccount(int accountNumber);

    int getAccountOfWhoRented(int dvdNumber);

    double getBluRayAdditionalFee();

    int getDuration();

    Dvd getDvd(int dvdNumber);

    double getDvdFee();

    double getDvdFeeForNewRelease();

    double getLateFee();

    int getNewReleaseAge();

    boolean isDvdAvailable(int dvdNumber);

    boolean isNewRelease(Dvd dvd);

    List<Account> listAllAccounts();

    List<Dvd> listAllAvailableByTitle(String title);

    List<Dvd> listAllByTitle(String title);

    Map<String, List<Dvd>> listAllGroupByVideoType();

    List<Dvd> listBluRayByTitle(String title);

    List<Dvd> listDvdByTitle(String title);

    void loadAccountFile() throws FileNotFoundException;

    void loadCurrentFeesFile() throws FileNotFoundException;

    void loadInventoryFile() throws FileNotFoundException;

    void loadTransactionFile() throws FileNotFoundException;

    void saveAccountFile() throws IOException;

    void saveInventoryFile() throws IOException;

    void saveTransactionFile() throws IOException;

    void setAccountDao(AccountDaoImpl accountDao);

    void setComputeFeeUtil(ComputeFeeUtilityImpl computeFeeUtil);

    void setDvdRentalDao(DvdRentalDaoImpl dvdRentalDao);

    void setMode(String mode);

    void setTxnDao(TransactionDaoImpl txnDao);
    
}
