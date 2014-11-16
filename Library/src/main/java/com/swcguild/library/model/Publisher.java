package com.swcguild.library.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publishers")
public class Publisher {
    
    @Id
    @GeneratedValue
    @Column(name="publisher_id")
    private int publisherId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="street")
    private String street;
    
    @Column(name="city")
    private String city;
    
    @Column(name="state")
    private String state;
    
    @Column(name="zip")
    private String zip;
    
    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy = "publisher")
    private List<HBook> books;
    
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<HBook> getBooks() {
        return books;
    }

    public void setBooks(List<HBook> books) {
        this.books = books;
    }
        
}
