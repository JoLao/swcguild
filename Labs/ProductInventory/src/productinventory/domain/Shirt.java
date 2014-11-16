

package productinventory.domain;

import java.util.Objects;


public class Shirt extends Product {   

    private String sleeveType;   //sleeveless, short sleeves, long sleeves
    private String size;         //S/M/L/XL/XXL
    private String forWhom;      //Male, Female, Unisex, Boy, Girl, Toddler, Infant

    public Shirt() {
        super();
    }

    public Shirt(String name, double price, int inventory, int thresholdCount, 
                 String sleeveType, String size, String forWhom) {
        super(name, price, inventory, thresholdCount);
        this.sleeveType = sleeveType;
        this.size = size;
        this.forWhom = forWhom;
    }

    
    
    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        hash = 67 * hash + Objects.hashCode(this.sleeveType);
        hash = 67 * hash + Objects.hashCode(this.size);
        hash = 67 * hash + Objects.hashCode(this.forWhom);
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
        final Shirt other = (Shirt) obj;
        if (!Objects.equals(this.sleeveType, other.sleeveType)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.forWhom, other.forWhom)) {
            return false;
        }
        return true;
    }

   
    
}
