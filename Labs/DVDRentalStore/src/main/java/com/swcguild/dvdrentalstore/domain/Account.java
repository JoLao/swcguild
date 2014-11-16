package com.swcguild.dvdrentalstore.domain;

import java.util.Objects;

public class Account implements Comparable<Account> {

    private int    accountNumber;
    private String userId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private AccountStatus status;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

         @Override
    public int compareTo(Account cmpAccount) {
        int cmp = Integer.compare(this.accountNumber, cmpAccount.accountNumber);        
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.userId.compareToIgnoreCase(cmpAccount.userId);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.name.compareToIgnoreCase(cmpAccount.name);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.address.compareToIgnoreCase(cmpAccount.address);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.city.compareToIgnoreCase(cmpAccount.city);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.state.compareToIgnoreCase(cmpAccount.state);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.zipCode.compareToIgnoreCase(cmpAccount.zipCode);
        if (cmp > 0) {
            return cmp;
        }
        
        cmp = this.phone.compareToIgnoreCase(cmpAccount.phone);
        if (cmp > 0) {
            return cmp;
        }
        
        return this.status.compareTo(cmpAccount.status);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.accountNumber != other.accountNumber) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
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
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
          
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.accountNumber;
        hash = 41 * hash + Objects.hashCode(this.userId);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.address);
        hash = 41 * hash + Objects.hashCode(this.city);
        hash = 41 * hash + Objects.hashCode(this.state);
        hash = 41 * hash + Objects.hashCode(this.zipCode);
        hash = 41 * hash + Objects.hashCode(this.phone);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.status);
        return hash;
    }
}
