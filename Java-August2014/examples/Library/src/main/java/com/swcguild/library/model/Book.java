/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.library.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class Book {
    
    private int bookId;
    private String isbn;
    private String title;
    private int publisherId;
    private int[] authorIds;
    private BigDecimal price;
    private LocalDate publishDate;

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

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int[] getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(int[] authorIds) {
        this.authorIds = authorIds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    
    
    
}
