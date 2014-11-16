/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmasteryproject2.domain;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class StateTax implements Comparable<StateTax> {
    private String state;
    private double taxRate;

//State,TaxRate
//OH,6.25
//PA,6.75
//MI,5.75
//IN,6.00
    public StateTax() {
    }
    
    
    
    public StateTax(String state, double taxRate) {
        this.state   = state.toUpperCase();
        this.taxRate = taxRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state.toUpperCase();
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int compareTo(StateTax compareState) {
        int cmp = this.state.compareToIgnoreCase(compareState.state);
        if (cmp != 0) {
            return cmp;
        }
        
        return Double.valueOf(this.taxRate).compareTo(Double.valueOf(compareState.taxRate));
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.state);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.taxRate) ^ (Double.doubleToLongBits(this.taxRate) >>> 32));
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
        final StateTax other = (StateTax) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (Double.doubleToLongBits(this.taxRate) != Double.doubleToLongBits(other.taxRate)) {
            return false;
        }
        return true;
    }
    
    
    
}
