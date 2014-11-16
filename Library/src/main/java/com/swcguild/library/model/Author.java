package com.swcguild.library.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
    
    @Id
    @GeneratedValue
    @Column(name="author_id")
    private int authorId;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
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

    @ManyToMany(mappedBy="authors")  //authors is the field in HBook
    private List<HBook> books;
    
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
