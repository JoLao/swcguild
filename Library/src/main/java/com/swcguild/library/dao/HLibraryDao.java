package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.HBook;
import com.swcguild.library.model.Publisher;
import java.util.List;

public interface HLibraryDao {
    public void addAuthor(Author author);    
    public void deleteAuthor(Author author);
    public void updateAuthor(Author author);
    public Author getAuthorById(int authorId);
    public List<Author> getAllAuthors();
    
    public void addBook(HBook book);
    public void deleteBook(HBook book);
    public void updateBook(HBook book);
    public HBook getBookById(int bookId);    
    public List<HBook> getAllBooks();
    
    public void addPublisher(Publisher publisher);
    public void deletePublisher(Publisher publisher);
    public void updatePublisher(Publisher publisher);
    public Publisher getPublisherById(int publisherId);
    public List<Publisher> getAllPublishers();
}
