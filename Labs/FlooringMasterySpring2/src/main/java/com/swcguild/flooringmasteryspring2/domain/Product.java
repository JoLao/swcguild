/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring2.domain;

import java.util.Objects;


public class Product implements Comparable<Product> {

    private String productType;
    private double costPerSquareFoot;
    private double laborCostPerSquareFoot;
    
    
//ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
//Carpet,2.25,2.10
//Laminate,1.75,2.10
//Tile,3.50,4.15
//Wood,5.15,4.75

    
    public Product() {
    }

    public Product(String productType, double costPerSquareFoot, double laborCostPerSquareFoot) {
        this.productType            = productType.toUpperCase();
        this.costPerSquareFoot      = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType.toUpperCase();
    }

    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(double costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public int compareTo(Product comparePdt) {
        int cmp = this.productType.compareToIgnoreCase(comparePdt.productType);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Double.valueOf(this.costPerSquareFoot).compareTo(Double.valueOf(comparePdt.productType));
        if (cmp != 0) {
            return cmp;
        }
        
        return Double.valueOf(this.laborCostPerSquareFoot).compareTo(Double.valueOf(comparePdt.laborCostPerSquareFoot));        
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.productType);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.costPerSquareFoot) ^ (Double.doubleToLongBits(this.costPerSquareFoot) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.laborCostPerSquareFoot) ^ (Double.doubleToLongBits(this.laborCostPerSquareFoot) >>> 32));
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
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.costPerSquareFoot) != Double.doubleToLongBits(other.costPerSquareFoot)) {
            return false;
        }
        if (Double.doubleToLongBits(this.laborCostPerSquareFoot) != Double.doubleToLongBits(other.laborCostPerSquareFoot)) {
            return false;
        }
        return true;
    }
    
    
    
}
