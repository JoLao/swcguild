/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Transaction implements Comparable<Transaction> {
    private int       accountNumber;
    private LocalDate checkOutDate;
    private int       dvdNumber;
    private LocalDate dateDue;
    private LocalDate dateReturned;
    private double    rentalFee;
    private double    lateFees;    
    private double    balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getDvdNumber() {
        return dvdNumber;
    }

    public void setDvdNumber(int dvdNumber) {
        this.dvdNumber = dvdNumber;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void setLateFees(double lateFees) {
        this.lateFees = lateFees;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
        
    @Override
    public int compareTo(Transaction cmpTxn) {
        int cmp = Integer.compare(this.accountNumber, cmpTxn.accountNumber);        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.checkOutDate.compareTo(cmpTxn.checkOutDate);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Integer.compare(this.dvdNumber, cmpTxn.dvdNumber);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.dateDue.compareTo(cmpTxn.dateDue);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.dateReturned.compareTo(cmpTxn.dateReturned);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Double.compare(this.rentalFee, cmpTxn.rentalFee);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Double.compare(this.lateFees, cmpTxn.lateFees);
        if (cmp != 0) {
            return cmp;
        }
        
        return Double.compare(this.balance, cmpTxn.balance);
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.accountNumber;
        hash = 59 * hash + Objects.hashCode(this.checkOutDate);
        hash = 59 * hash + this.dvdNumber;
        hash = 59 * hash + Objects.hashCode(this.dateDue);
        hash = 59 * hash + Objects.hashCode(this.dateReturned);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lateFees) ^ (Double.doubleToLongBits(this.lateFees) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.rentalFee) ^ (Double.doubleToLongBits(this.rentalFee) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (this.accountNumber != other.accountNumber) {
            return false;
        }
        if (!Objects.equals(this.checkOutDate, other.checkOutDate)) {
            return false;
        }
        if (this.dvdNumber != other.dvdNumber) {
            return false;
        }
        if (!Objects.equals(this.dateDue, other.dateDue)) {
            return false;
        }
        if (!Objects.equals(this.dateReturned, other.dateReturned)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lateFees) != Double.doubleToLongBits(other.lateFees)) {
            return false;
        }
        if (Double.doubleToLongBits(this.rentalFee) != Double.doubleToLongBits(other.rentalFee)) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return true;
    }    
    
}
