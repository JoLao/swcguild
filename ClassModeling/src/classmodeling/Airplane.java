/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;

/**
 *
 * @author apprentice
 */
public class Airplane {
    private String  modelName;
    private String  carrier;   //United, NorthWest, etc.
    private String  type;      //commercial, private, etc
    private int     capacity;
    private boolean isInGoodCondition;
    
    
    public Airplane() {
    }

    public Airplane(String modelName) {
        this.modelName = modelName;
    }   
    
    public String getModelName() {
        return modelName;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isIsInGoodCondition() {
        return isInGoodCondition;
    }

    public void setIsInGoodCondition(boolean isInGoodCondition) {
        this.isInGoodCondition = isInGoodCondition;
    }
 
    
    
    public void checkEngine() {
        
    }
}
