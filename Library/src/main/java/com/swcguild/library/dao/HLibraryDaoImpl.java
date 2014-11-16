/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.HBook;
import com.swcguild.library.model.Publisher;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HLibraryDaoImpl implements HLibraryDao {

    private SessionFactory sessionFactory;

    @Inject
    public HLibraryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
        
    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void addAuthor(Author author) {
        currentSession().save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        currentSession().delete(author);
    }

    @Override
    public void updateAuthor(Author author) {
        currentSession().update(author);
    }

    @Override
    public Author getAuthorById(int authorId) {
        return (Author) currentSession().get(Author.class, authorId);
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) currentSession().createCriteria(Author.class).list();
    }

    @Override
    public void addBook(HBook book) {
        currentSession().save(book);
    }

    @Override
    public void deleteBook(HBook book) {
        currentSession().delete(book);
    }

    @Override
    public void updateBook(HBook book) {
        currentSession().update(book);
    }

    @Override
    public HBook getBookById(int bookId) {
        return (HBook) currentSession().get(HBook.class, bookId);
    }

    @Override
    public List<HBook> getAllBooks() {
        return (List<HBook>) currentSession().createCriteria(HBook.class).list();
    }

    @Override
    public void addPublisher(Publisher publisher) {
        currentSession().save(publisher);
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        currentSession().delete(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        currentSession().update(publisher);
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        return (Publisher) currentSession().get(Publisher.class, publisherId);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) currentSession().createCriteria(Publisher.class).list();
    }
    
}
