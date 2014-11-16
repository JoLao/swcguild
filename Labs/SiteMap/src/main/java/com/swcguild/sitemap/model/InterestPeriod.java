/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.sitemap.model;

/**
 *
 * @author apprentice
 */
public class InterestPeriod {
    private int year;
    private double begPrincipal;
    private double interest;
    private double endPrincipal;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getBegPrincipal() {
        return begPrincipal;
    }

    public void setBegPrincipal(double begPrincipal) {
        this.begPrincipal = begPrincipal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getEndPrincipal() {
        return endPrincipal;
    }

    public void setEndPrincipal(double endPrincipal) {
        this.endPrincipal = endPrincipal;
    }
    
    
    
}
