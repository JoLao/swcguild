package addressbook2.domain;

import java.util.Objects;

public class Address implements Comparable<Address>{
//need to be final?

    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Address(String lastName, String firstName, String address, String city, String state, String zipCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int compareTo(Address compareAddr) {           
        int cmp = this.lastName.compareTo(compareAddr.lastName);
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.firstName.compareTo(compareAddr.firstName);
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.address.compareTo(compareAddr.address);
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.city.compareTo(compareAddr.city);
        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.state.compareTo(compareAddr.state);
        
        if (cmp != 0) {
            return cmp;
        }
        
        return this.zipCode.compareTo(compareAddr.zipCode);
       
    }
  
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + Objects.hashCode(this.state);
        hash = 79 * hash + Objects.hashCode(this.zipCode);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        return true;
    }
    
    
}
