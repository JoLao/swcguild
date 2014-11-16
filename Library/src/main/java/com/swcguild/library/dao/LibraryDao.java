package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.Book;
import com.swcguild.library.model.Publisher;
import java.util.List;

public interface LibraryDao {
   
    public void addAuthor(Author author);
    public void deleteAuthor(int authorId);
    public void updateAuthor(Author author);
    public Author getAuthorById(int authorId);
    public List<Author> getAuthorsByBookId(int bookId);
    public List<Author> getAllAuthors();
    
    public void addBook(Book book);
    public void deleteBook(int bookId);
    public void updateBook(Book book);
    public Book getBookById(int bookId);
    public List<Book> getBooksByAuthorId(int authorId);
    public List<Book> getBooksByPublisherId(int publisherID);   
    public List<Book> getAllBooks();
    
    public void addPublisher(Publisher publisher);
    public void deletePublisher(int publisherId);
    public void updatePublisher(Publisher publisher);
    public Publisher getPublisherById(int publisherId);
    public Publisher getPublisherByBookId(int bookId);
    public List<Publisher> getAllPublishers();
    
}
