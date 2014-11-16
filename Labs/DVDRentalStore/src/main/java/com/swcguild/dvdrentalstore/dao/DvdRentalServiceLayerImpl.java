package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.Dvd;
import com.swcguild.dvdrentalstore.domain.Transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DvdRentalServiceLayerImpl implements DvdRentalServiceLayer {
    
    private String mode;
    
    private DvdRentalDaoImpl   dvdRentalDao;    
    private AccountDaoImpl     accountDao;
    private TransactionDaoImpl txnDao;
    
    private ComputeFeeUtilityImpl computeFeeUtil;

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void setDvdRentalDao(DvdRentalDaoImpl dvdRentalDao) {
        this.dvdRentalDao = dvdRentalDao;
    }

    @Override
    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void setTxnDao(TransactionDaoImpl txnDao) {
        this.txnDao = txnDao;
    }

    @Override
    public void setComputeFeeUtil(ComputeFeeUtilityImpl computeFeeUtil) {
        this.computeFeeUtil = computeFeeUtil;
    }
    
    @Override
    public double getDvdFee() {
        return computeFeeUtil.getDvdFee();
    }
    
    @Override
    public int getNewReleaseAge() {
        return computeFeeUtil.getNewReleaseAge();
    }
    
    @Override
    public double getDvdFeeForNewRelease() {
        return computeFeeUtil.getDvdFeeForNewRelease();
    }
    
    @Override
    public double getBluRayAdditionalFee() {
        return computeFeeUtil.getBluRayAdditionalFee();
    }
    
    @Override
    public double getLateFee() {
        return computeFeeUtil.getLateFee();
    }
    
    @Override
    public int getDuration() {
        return computeFeeUtil.getDuration();
    }
        
    @Override
    public void loadCurrentFeesFile() throws FileNotFoundException {
        computeFeeUtil.loadCurrentFeesFile();
    }
    @Override
    public void loadInventoryFile() throws FileNotFoundException {
        dvdRentalDao.loadInventoryFile();
    }  
    
    @Override
    public void saveInventoryFile() throws IOException {
        dvdRentalDao.saveInventoryFile();
    }
    
    @Override
    public List<Dvd> listDvdByTitle(String title) {
        return dvdRentalDao.listDvdByTitle(title);
    }
    
    @Override
    public List<Dvd> listBluRayByTitle(String title) {
        return dvdRentalDao.listBluRayByTitle(title);
    }
    
    @Override
    public Map<String, List<Dvd>> listAllGroupByVideoType() {
        return dvdRentalDao.listAllGroupByVideoType();
    }
    
    @Override
    public List<Dvd> listAllAvailableByTitle(String title) {
        return dvdRentalDao.listAllAvailableByTitle(title);
    }
    
    @Override
    public List<Dvd> listAllByTitle(String title) {
        return dvdRentalDao.listAllByTitle(title);
    }
    
    @Override
    public boolean isNewRelease(Dvd dvd) {
        return computeFeeUtil.isNewRelease(dvd);
    }
    @Override
    public double computeFees(Dvd dvd) {
        return computeFeeUtil.computeFees(dvd);
    }
    
    @Override
    public double determineFee(Dvd dvd) {
        return computeFeeUtil.determineFee(dvd);
    }
    
    @Override
    public int computeDaysElapsed(Dvd dvd) {
        return computeFeeUtil.computeDaysElapsed(dvd);
    }
    
    @Override
    public double computeLateFees(Dvd dvd) {
        return computeFeeUtil.computeLateFees(dvd);
    }
    
    @Override
    public Dvd    getDvd(int dvdNumber) {
        return dvdRentalDao.getDvd(dvdNumber);
    }
    
    @Override
    public boolean isDvdAvailable(int dvdNumber) {
        return dvdRentalDao.isDvdAvailable(dvdNumber);
    }
    
    @Override
    public void loadAccountFile() throws FileNotFoundException {
        accountDao.loadAccountFile();
    }    
    
    @Override
    public void saveAccountFile() throws IOException {
        accountDao.saveAccountFile();
    }
    
    @Override
    public List<Account> listAllAccounts() {
        return accountDao.listAllAccounts();
    }
    
    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }
    
    @Override
    public Account getAccount(int accountNumber) {
        return accountDao.getAccount(accountNumber);
    }
    
    @Override
    public boolean checkIfAccountExists(int accountNumber) {
        return accountDao.checkIfAccountExists(accountNumber);
    }
    
    @Override
    public void loadTransactionFile() throws FileNotFoundException {
        txnDao.loadTransactionFile();
    }   
    @Override
    public void saveTransactionFile() throws IOException {
        txnDao.saveTransactionFile();
    }        
    
    @Override
    public void addTransaction(Transaction txn) {
        txnDao.addTransaction(txn);
    }
    
    @Override
    public void calculateBalanceOfAllAccounts() {
        
    }
    
    @Override
    public int getAccountOfWhoRented(int dvdNumber) {
        return txnDao.getAccountOfWhoRented(dvdNumber);
    }
    
    @Override
    public double calculateBalanceByAccount(int accountNumber) {
        return 0;
    }
}
