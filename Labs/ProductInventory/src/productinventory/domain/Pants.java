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
public class Pants extends Product {
   
    private String typeOfPants;  //Khakis, jeans, slacks, formal pants, cropped, etc.
    private int    size;         //25, 26, 27, 28... etc.
    private int    inseams;
    private String forWhom;      //Male, Female

    public Pants() {
        super();
    }

    public Pants(String name, double price, int inventory, int thresholdCount,
                 String typeOfPants, int size, int inseams, String forWhom) {
        super(name, price, inventory, thresholdCount);
        this.typeOfPants = typeOfPants;
        this.size = size;
        this.inseams = inseams;
        this.forWhom = forWhom;
    }

    

   

    public String getTypeOfPants() {
        return typeOfPants;
    }

    public void setTypeOfPants(String typeOfPants) {
        this.typeOfPants = typeOfPants;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getInseams() {
        return inseams;
    }

    public void setInseams(int inseams) {
        this.inseams = inseams;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.typeOfPants);
        hash = 97 * hash + this.size;
        hash = 97 * hash + this.inseams;
        hash = 97 * hash + Objects.hashCode(this.forWhom);
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
        final Pants other = (Pants) obj;
        if (!Objects.equals(this.typeOfPants, other.typeOfPants)) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (this.inseams != other.inseams) {
            return false;
        }
        if (!Objects.equals(this.forWhom, other.forWhom)) {
            return false;
        }
        return true;
    }
    
    
    
}
