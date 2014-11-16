/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;


public class House {
    private String modelName;
    private String style;
    private int    numGarage;
    private int    numOfBedrooms;
    private double salePrice; 
    private String color;
    private int    lotSize;

    public House() {
    }

    public House(String modelName, String style, int numGarage, int numOfBedrooms, double salePrice, String color, int lotSize) {
        this.modelName = modelName;
        this.style = style;
        this.numGarage = numGarage;
        this.numOfBedrooms = numOfBedrooms;
        this.salePrice = salePrice;
        this.color = color;
        this.lotSize = lotSize;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getNumGarage() {
        return numGarage;
    }

    public void setNumGarage(int numGarage) {
        this.numGarage = numGarage;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
   
    public double calculatePropertyTax() {
        return 1.0;
    }
    
    
}
