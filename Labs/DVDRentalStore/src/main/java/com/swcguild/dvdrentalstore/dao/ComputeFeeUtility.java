/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public interface ComputeFeeUtility {

    int computeDaysElapsed(Dvd dvd);
    int computeDaysElapsed(LocalDate date);

    double computeFees(Dvd dvd);

    double computeLateFees(Dvd dvd);

    double determineFee(Dvd dvd);

    double getBluRayAdditionalFee();

    int getDuration();

    double getDvdFee();

    double getDvdFeeForNewRelease();

    double getLateFee();

    int getNewReleaseAge();

    boolean isNewRelease(Dvd dvd);

    void loadCurrentFeesFile() throws FileNotFoundException;

    void setBluRayAdditionalFee(double bluRayAdditionalFee);

    void setDuration(int duration);

    void setDvdFee(double dvdFee);

    void setDvdFeeForNewRelease(double dvdFeeForNewRelease);

    void setLateFee(double lateFee);

    void setMode(String mode);

    void setNewReleaseAge(int newReleaseAge);
    
}
