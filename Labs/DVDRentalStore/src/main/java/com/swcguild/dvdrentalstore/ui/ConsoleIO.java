/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.dvdrentalstore.ui;

import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public interface ConsoleIO {

    void printString(String message);

    void printStringLn(String message);

    LocalDate promptForDate(String message);

    double promptForDouble(String message);

    double promptForDoubleWithRange(String message, double min, double max);

    float promptForFloat(String message);

    float promptForFloatWithRange(String message, float min, float max);

    int promptForInteger(String message);

    int promptForIntegerWithRange(String message, int min, int max);

    String promptForString(String message);
    
}
