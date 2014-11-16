/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productinventory.domain;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Product {

    protected String pdtNumber;
    protected String name;
    protected double price;
    protected int    inventory;
    protected int    thresholdCount;


    public Product() {

    }

    public Product(String pdtNumber, String name) {
        this.pdtNumber   = pdtNumber;
        this.name        = name;
    
    }

    public Product(String name, double price, int inventory, int thresholdCount) {
        this.name           = name;        
        this.price          = price;
        this.inventory      = inventory;
        this.thresholdCount = thresholdCount;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getThresholdCount() {
        return thresholdCount;
    }

    public void setThresholdCount(int thresholdCount) {
        this.thresholdCount = thresholdCount;
    }

    public int compareTo(Product compareProduct) {
        int cmp = this.name.compareTo(compareProduct.name);
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Double.valueOf(this.price).compareTo(Double.valueOf(compareProduct.price));
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Integer.valueOf(this.inventory).compareTo(Integer.valueOf(compareProduct.inventory));
        
        if (cmp != 0) {
            return cmp;
        }
        
        return Integer.valueOf(this.thresholdCount).compareTo(Integer.valueOf(compareProduct.thresholdCount));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 41 * hash + this.inventory;
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        return true;
    }
   

}
