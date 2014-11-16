package com.swcguild.library.model;

import java.math.BigDecimal;
import java.util.Date;   //should be java.util.Date not java.sql.Date
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class HBook {
    
    @Id
    @GeneratedValue
    @Column(name="book_id")
    private int bookId;
    
    @Column(name="isbn")
    private String isbn;
    
    @Column(name="title")
    private String title;
    
    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinTable(name="books_authors", 
               joinColumns = {@JoinColumn(name="book_id")},
               inverseJoinColumns = {@JoinColumn(name="author_id")})
    private List<Author> authors;
    
    @Column(name="price")
    private BigDecimal price;
    
    @Column(name="publishdate")
    private Date publishDate;  //Using Date instead of LocalDate because of the Hibernate version we're using

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    
    

}
