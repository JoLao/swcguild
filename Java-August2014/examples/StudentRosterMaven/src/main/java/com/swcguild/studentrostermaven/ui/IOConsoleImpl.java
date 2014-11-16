/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class IOConsoleImpl implements IO {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        Scanner mySc = new Scanner(System.in);
        System.out.println(prompt);
        return mySc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean badInput;
        int result = 0;
        do {
            try {
                System.out.println(prompt);
                result = Integer.parseInt(sc.nextLine());
                badInput = false;
            } catch (NumberFormatException nfe) {
                badInput = true;
            }
        } while (badInput);
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public long readLong(String prompt) {
        boolean badInput;
        long result = 0;
        do {
            try {
                System.out.println(prompt);
                result = Long.parseLong(sc.nextLine());
                badInput = false;
            } catch (NumberFormatException nfe) {
                badInput = true;
            }
        } while (badInput);

        return result;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public float readFloat(String prompt) {
        boolean badInput;
        float result = 0;
        do {
            try {
                System.out.println(prompt);
                result = Float.parseFloat(sc.nextLine());
                badInput = false;
            } catch (NumberFormatException nfe) {
                badInput = true;
            }
        } while (badInput);

        return result;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public double readDouble(String prompt) {
        boolean badInput;
        double result = 0;
        do {
            try {
                System.out.println(prompt);
                result = Double.parseDouble(sc.nextLine());
                badInput = false;
            } catch (NumberFormatException nfe) {
                badInput = true;
            }
        } while (badInput);

        return result;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public LocalDate readDate(String prompt) {
        boolean badInput;
        LocalDate result = null;
        do {
            try {
                System.out.println(prompt);
                result = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ISO_DATE);
                badInput = false;
            } catch (DateTimeParseException e) {
                badInput = true;
            }
        } while (badInput);
        return result;
    }

}
