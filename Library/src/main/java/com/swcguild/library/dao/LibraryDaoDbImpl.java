/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.Book;
import com.swcguild.library.model.Publisher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LibraryDaoDbImpl implements LibraryDao {

    //AUTHORS SQL STATEMENTS
    private static final String SQL_INSERT_AUTHOR
            = "INSERT INTO authors (first_name, last_name, street, city, state, zip, phone) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_AUTHOR
            = "DELETE FROM authors WHERE author_id = ?";

    private static final String SQL_UPDATE_AUTHOR
            = "UPDATE authors SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, zip = ?, phone = ? "
            + "WHERE author_id = ?";

    private static final String SQL_AUTHORS_BY_ID
            = "SELECT * FROM authors WHERE author_id = ?";

    private static final String SQL_AUTHORS_BY_BOOK_ID
            = "SELECT au.* FROM "
            + "authors au INNER JOIN books_authors ba "
            + "ON au.author_id = ba.author_id "
            + "WHERE ba.book_id = ?";

    private static final String SQL_SELECT_ALL_AUTHORS
            = "SELECT * FROM authors";

    //BOOKS SQL STATEMENTS
    private static final String SQL_INSERT_BOOKS
            = "INSERT INTO books (isbn, title, publisher_id, price, publish_date) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_BOOKS_AUTHORS
            = "INSERT INTO books_authors (book_id, author_id) "
            + "VALUES(?, ?)";

    private static final String SQL_DELETE_BOOKS
            = "DELETE FROM books WHERE book_id = ?";

    private static final String SQL_DELETE_BOOKS_AUTHORS
            = "DELETE FROM books_authors WHERE book_id = ?";

    private static final String SQL_UPDATE_BOOKS
            = "UPDATE books SET isbn = ?, title = ?, publisher_id = ?, price = ?, publish_date = ? "
            + "WHERE book_id = ?";

    private static final String SQL_BOOKS_BY_ID
            = "SELECT * FROM books WHERE book_id = ?";

    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID
            = "SELECT author_id FROM books_authors WHERE book_id = ?";

    //getBooksByAuthorId
    private static final String SQL_BOOKS_BY_AUTHOR_ID
            = "SELECT b.* FROM "
            + "books b INNER JOIN books_authors ba "
            + "ON b.book_id = ba.book_id "
            + "WHERE ba.author_id = ?";

    //getBooksByPublisherId
    private static final String SQL_BOOKS_BY_PUBLISHER_ID
            = "SELECT * FROM books "
            + "WHERE publisher_id = ?";

    private static final String SQL_SELECT_ALL_BOOKS
            = "SELECT * FROM books";

    //PUBLISHER SQL STATEMENTS
    private static final String SQL_INSERT_PUBLISHER
            = "INSERT INTO publishers (name, street, city, state, zip, phone) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_PUBLISHER
            = "DELETE FROM publishers WHHERE publisher_id = ?";

    private static final String SQL_UPDATE_PUBLISHER
            = "UPDATE publishers SET name = ?, street = ?, city = ?, state = ?, zip = ?, phone = ? "
            + "WHERE publisher_id = ?";

    private static final String SQL_PUBLISHER_BY_ID
            = "SELECT * FROM publishers WHERE publisher_id = ?";

    private static final String SQL_PUBLISHER_BY_BOOK_ID    
            = "SELECT p.* FROM "
            + "publishers p INNER JOIN books b "
            + "ON p.publisher_id = b.publisher_id "
            + "WHERE b.book_id = ?";
    
    private static final String SQL_SELECT_ALL_PUBLISHERS
            = "SELECT * FROM publishers";

    private JdbcTemplate jdbcTemplate;

    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAuthor(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getState(),
                author.getZip(),
                author.getPhone());
        author.setAuthorId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void deleteAuthor(int authorId) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getState(),
                author.getZip(),
                author.getPhone(),
                author.getAuthorId());
    }

    @Override
    public Author getAuthorById(int authorId) {
        try {
            return jdbcTemplate.queryForObject(SQL_AUTHORS_BY_ID, new AuthorMapper(), authorId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Author> getAuthorsByBookId(int bookId) {
        return jdbcTemplate.query(SQL_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS, new AuthorMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBook(Book book) {
        //first insert into books table
        jdbcTemplate.update(SQL_INSERT_BOOKS,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString());
        book.setBookId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        //now insert into books_authors table
        insertBooksAuthors(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(int bookId) {
        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, bookId);
        jdbcTemplate.update(SQL_DELETE_BOOKS, bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(Book book) {
        jdbcTemplate.update(SQL_UPDATE_BOOKS,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate(),
                book.getBookId());
        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, book.getBookId());
        insertBooksAuthors(book);
    }

    @Override
    public Book getBookById(int bookId) {
        Book b;
        int[] idArray;
        try {
            b = jdbcTemplate.queryForObject(SQL_BOOKS_BY_ID, new BookMapper(), bookId);
            idArray = getAuthorIdsForBook(b);
            b.setAuthorIds(idArray);
            return b;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {
        return jdbcTemplate.query(SQL_BOOKS_BY_AUTHOR_ID, new BookMapper(), authorId);
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        return jdbcTemplate.query(SQL_BOOKS_BY_PUBLISHER_ID, new BookMapper(), publisherId);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bList = jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper());
        for (Book b : bList) {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }
        return bList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPublisher(Publisher publisher) {
        //name, street, city, state, zip, phone
        jdbcTemplate.update(SQL_INSERT_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone());
        publisher.setPublisherId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(SQL_DELETE_PUBLISHER, publisherId);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_UPDATE_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone(),
                publisher.getPublisherId());
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        try {
            return jdbcTemplate.queryForObject(SQL_PUBLISHER_BY_ID, new PublisherMapper(), publisherId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Publisher getPublisherByBookId(int bookId) {
        try {
            return jdbcTemplate.queryForObject(SQL_PUBLISHER_BY_BOOK_ID, new PublisherMapper(), bookId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHERS, new PublisherMapper());
    }

    //HELPER METHODS
    private void insertBooksAuthors(Book book) {
        final int bookId = book.getBookId();
        final int[] authorIds = book.getAuthorIds();
        //use batch update so we can send everything in one request
        jdbcTemplate.batchUpdate(SQL_INSERT_BOOKS_AUTHORS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, bookId);
                ps.setInt(2, authorIds[i]);
            }

            @Override
            public int getBatchSize() {
                return authorIds.length;
            }
        });
    }

    private int[] getAuthorIdsForBook(Book book) {
        // get a list of author ids from the books_authors table
        List<Integer> authorIds = jdbcTemplate.queryForList(SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID,
                new Integer[]{book.getBookId()}, Integer.class);

        int[] idArray = new int[authorIds.size()];

        for (int i = 0; i < authorIds.size(); i++) {
            idArray[i] = authorIds.get(i);
        }
//        idArray = authorIds.toArray(new Integer[0]);
        return idArray;
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author a = new Author();
            a.setAuthorId(rs.getInt("author_id"));
            a.setFirstName(rs.getString("first_name"));
            a.setLastName(rs.getString("last_name"));
            a.setStreet(rs.getString("street"));
            a.setCity(rs.getString("city"));
            a.setState(rs.getString("state"));
            a.setZip(rs.getString("zip"));
            a.setPhone(rs.getString("phone"));
            return a;
        }

    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book b = new Book();
            b.setBookId(rs.getInt("book_id"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
            b.setPublisherId(rs.getInt("publisher_id"));
            b.setPrice(rs.getBigDecimal("price"));
            b.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
            return b;
        }

    }

    private static class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int i) throws SQLException {
            //name, street, city, state, zip, phone
            Publisher p = new Publisher();
            p.setPublisherId(rs.getInt("publisher_id"));
            p.setName(rs.getString("name"));
            p.setStreet(rs.getString("street"));
            p.setCity(rs.getString("city"));
            p.setState(rs.getString("state"));
            p.setZip(rs.getString("zip"));
            p.setPhone(rs.getString("phone"));
            return p;
        }

    }
}
