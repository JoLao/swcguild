/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ComputeFeeUtilityImpl implements ComputeFeeUtility {

    private String mode = "PROD";

    private double dvdFee = 0;
    private double dvdFeeForNewRelease = 0;
    private double bluRayAdditionalFee = 0;
    private double lateFee = 0;
    private int duration = 0;
    private int newReleaseAge = 0;

    public static final String CURRENT_FEES_FILE = "currentfees.txt";
    public static final String DELIMITER = "::";

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public double getDvdFee() {
        return dvdFee;
    }

    @Override
    public void setDvdFee(double dvdFee) {
        this.dvdFee = dvdFee;
    }

    @Override
    public double getDvdFeeForNewRelease() {
        return dvdFeeForNewRelease;
    }

    @Override
    public void setDvdFeeForNewRelease(double dvdFeeForNewRelease) {
        this.dvdFeeForNewRelease = dvdFeeForNewRelease;
    }

    @Override
    public double getBluRayAdditionalFee() {
        return bluRayAdditionalFee;
    }

    @Override
    public void setBluRayAdditionalFee(double bluRayAdditionalFee) {
        this.bluRayAdditionalFee = bluRayAdditionalFee;
    }

    @Override
    public double getLateFee() {
        return lateFee;
    }

    @Override
    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getNewReleaseAge() {
        return newReleaseAge;
    }

    @Override
    public void setNewReleaseAge(int newReleaseAge) {
        this.newReleaseAge = newReleaseAge;
    }
   
    
    @Override
    public double computeFees(Dvd dvd) {        
        return determineFee(dvd) + computeLateFees(dvd);
    }

    @Override
    public boolean isNewRelease(Dvd dvd) {
        return (dvd.getAge() > this.newReleaseAge ? false : true);
    }
    
    @Override
    public double determineFee(Dvd dvd ){
        return (!isNewRelease(dvd) ? dvdFee : this.dvdFeeForNewRelease) +
                    (dvd.getVideoType().equalsIgnoreCase("BluRay") ? this.bluRayAdditionalFee : 0);
    }
    
    @Override
    public int computeDaysElapsed(Dvd dvd) {
        Period p = dvd.getCheckOutDate().until(LocalDate.now());        
        return p.getDays();
    }
    
    @Override
    public int computeDaysElapsed(LocalDate date) {
        Period p = date.until(LocalDate.now());
        return p.getDays();
    }
    
    @Override
    public double computeLateFees(Dvd dvd) {
        int daysOverDue = computeDaysElapsed(dvd) - this.duration;
        return  (daysOverDue > 0) ? daysOverDue * this.lateFee : 0;
    }
    
    @Override
    public void loadCurrentFeesFile() throws FileNotFoundException {        
        Scanner in = new Scanner(new FileReader(CURRENT_FEES_FILE));

        String currentRecord = in.nextLine();
        String[] currentTokens = currentRecord.split(DELIMITER);

        dvdFee              = Double.parseDouble(currentTokens[0]);
        dvdFeeForNewRelease = Double.parseDouble(currentTokens[1]);
        bluRayAdditionalFee = Double.parseDouble(currentTokens[2]);
        lateFee             = Double.parseDouble(currentTokens[3]);
        duration            = Integer.parseInt(currentTokens[4]);
        newReleaseAge       = Integer.parseInt(currentTokens[5]);

//        System.out.println("dvd fee "+dvdFee);
//        System.out.println("dvd fee for new release "+dvdFeeForNewRelease);
//        System.out.println("blu ray addl fee "+bluRayAdditionalFee);
//        System.out.println("late fee "+lateFee);
        in.close();
    }

}
