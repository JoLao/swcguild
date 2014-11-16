/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.Book;
import com.swcguild.library.model.Publisher;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class LibraryDaoTest {

    LibraryDao dao;

    public LibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Ask Spring for my DAO
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (LibraryDao) ctx.getBean("libraryDao");

        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from books_authors");
        cleaner.execute("delete from books");
        cleaner.execute("delete from authors");
        cleaner.execute("delete from publishers");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUpdateDeleteAuthorTest() {

        // Create and Read tests
        Author au = new Author();
        au.setFirstName("James");
        au.setLastName("Joyce");
        au.setStreet("123 Main");
        au.setCity("Hometown");
        au.setState("OH");
        au.setZip("12345");
        au.setPhone("555-1212");

        dao.addAuthor(au);

        Author fromDb = dao.getAuthorById(au.getAuthorId());

        assertTrue(areEqual(au, fromDb));

        // Update Test
        au.setFirstName("JamesZZ");
        au.setLastName("JoyceZZ");
        au.setStreet("123 MainZZ");
        au.setCity("HometownZZ");
        au.setState("OHZZ");
        au.setZip("12345ZZ");
        au.setPhone("555-1212ZZ");

        dao.updateAuthor(au);
        fromDb = dao.getAuthorById(au.getAuthorId());

        assertTrue(areEqual(au, fromDb));

        // Delete Test
        dao.deleteAuthor(au.getAuthorId());

        fromDb = dao.getAuthorById(au.getAuthorId());

        assertNull(fromDb);

    }

    @Test
    public void getAllAuthorsTest() {
        Author au = new Author();
        au.setFirstName("James");
        au.setLastName("Joyce");
        au.setStreet("123 Main");
        au.setCity("Hometown");
        au.setState("OH");
        au.setZip("12345");
        au.setPhone("555-1212");
        dao.addAuthor(au);

        Author au1 = new Author();
        au1.setFirstName("JamesAA");
        au1.setLastName("JoyceAA");
        au1.setStreet("123 MainAA");
        au1.setCity("HometownAA");
        au1.setState("OHAA");
        au1.setZip("12345AA");
        au1.setPhone("555-1212AA");
        dao.addAuthor(au1);

        Author au2 = new Author();
        au2.setFirstName("JamesBB");
        au2.setLastName("JoyceBB");
        au2.setStreet("123 MainBB");
        au2.setCity("HometownBB");
        au2.setState("OHBB");
        au2.setZip("12345BB");
        au2.setPhone("555-1212BB");
        dao.addAuthor(au2);

        List<Author> list = dao.getAllAuthors();

        assertEquals(3, list.size());

        Author fromDb = dao.getAuthorById(au.getAuthorId());
        Author fromDb1 = dao.getAuthorById(au1.getAuthorId());
        Author fromDb2 = dao.getAuthorById(au2.getAuthorId());

        assertTrue(areEqual(au, fromDb));
        assertTrue(areEqual(au1, fromDb1));
        assertTrue(areEqual(au2, fromDb2));
    }
    
    @Test
    public void getAuthorsByBookIdTest() {
        Publisher p = new Publisher();
        p.setName("Little House");
        p.setStreet("23 Lane Street");
        p.setCity("Atown");
        p.setState("PA");
        p.setZip("34552");
        p.setPhone("555-0009");
        dao.addPublisher(p);

        Author a = new Author();
        a.setFirstName("Stephen");
        a.setLastName("King");
        a.setStreet("45 Hallow Drive");
        a.setCity("Anothertown");
        a.setState("NY");
        a.setZip("33122");
        a.setPhone("555.6767");
        dao.addAuthor(a);

        Author a1 = new Author();
        a1.setFirstName("George");
        a1.setLastName("Jones");
        a1.setStreet("22 M Drive");
        a1.setCity("Mytown");
        a1.setState("FL");
        a1.setZip("33555");
        a1.setPhone("555.5550");
        dao.addAuthor(a1);

        Book b = new Book();
        b.setIsbn("34345656");
        b.setTitle("Another Great Book!");
        b.setPublisherId(p.getPublisherId());
        b.setPrice(new BigDecimal("12.98"));
        b.setPublishDate(LocalDate.now());
        int[] authorIds = new int[2];
        authorIds[0] = a.getAuthorId();
        authorIds[1] = a1.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.addBook(b);
        
        List<Author> aList = dao.getAuthorsByBookId(b.getBookId());
        int[] fromDbAuthIds = new int[2];
        fromDbAuthIds[0] = aList.get(0).getAuthorId();
        fromDbAuthIds[1] = aList.get(1).getAuthorId();
        Arrays.sort(authorIds);
        Arrays.sort(fromDbAuthIds);
        assertTrue(Arrays.equals(authorIds, fromDbAuthIds));      
    }

    @Test
    public void addGetUpdateDeletePublisherTest() {

        // Create and Retrieve
        Publisher p = new Publisher();
        p.setName("Big House");
        p.setStreet("34 Elm");
        p.setCity("Anytown");
        p.setState("WA");
        p.setZip("23456");
        p.setPhone("345-9987");

        dao.addPublisher(p);

        Publisher fromDb = dao.getPublisherById(p.getPublisherId());

        assertTrue(areEqual(p, fromDb));

        // Update
        p.setName("Big HouseZZ");
        p.setStreet("34 ElmZZ");
        p.setCity("AnytownZZ");
        p.setState("WAZZ");
        p.setZip("23456ZZ");
        p.setPhone("345-9987ZZ");

        dao.updatePublisher(p);
        fromDb = dao.getPublisherById(p.getPublisherId());
        assertTrue(areEqual(p, fromDb));

        // Delete
        dao.deletePublisher(p.getPublisherId());
        fromDb = dao.getPublisherById(p.getPublisherId());
        assertNull(fromDb);

    }

    @Test
    public void getAllPublishersTest() {
        Publisher p = new Publisher();
        p.setName("Big House");
        p.setStreet("34 Elm");
        p.setCity("Anytown");
        p.setState("WA");
        p.setZip("23456");
        p.setPhone("345-9987");

        dao.addPublisher(p);

        Publisher p1 = new Publisher();
        p1.setName("Big House");
        p1.setStreet("34 Elm");
        p1.setCity("Anytown");
        p1.setState("WA");
        p1.setZip("23456");
        p1.setPhone("345-9987");

        dao.addPublisher(p1);

        Publisher p2 = new Publisher();
        p2.setName("Big House");
        p2.setStreet("34 Elm");
        p2.setCity("Anytown");
        p2.setState("WA");
        p2.setZip("23456");
        p2.setPhone("345-9987");

        dao.addPublisher(p2);

        List<Publisher> list = dao.getAllPublishers();
        assertEquals(3, list.size());

        Publisher fromDb = dao.getPublisherById(p.getPublisherId());
        Publisher fromDb1 = dao.getPublisherById(p1.getPublisherId());
        Publisher fromDb2 = dao.getPublisherById(p2.getPublisherId());
        assertTrue(areEqual(p, fromDb));
        assertTrue(areEqual(p1, fromDb1));
        assertTrue(areEqual(p2, fromDb2));
    }

    @Test
    public void addGetDeleteBookTest() {
        Publisher p = new Publisher();
        p.setName("Little House");
        p.setStreet("23 Lane Street");
        p.setCity("Atown");
        p.setState("PA");
        p.setZip("34552");
        p.setPhone("555-0009");
        dao.addPublisher(p);

        Author a = new Author();
        a.setFirstName("Stephen");
        a.setLastName("King");
        a.setStreet("45 Hallow Drive");
        a.setCity("Anothertown");
        a.setState("NY");
        a.setZip("33122");
        a.setPhone("555.6767");
        dao.addAuthor(a);

        Author a1 = new Author();
        a1.setFirstName("George");
        a1.setLastName("Jones");
        a1.setStreet("22 M Drive");
        a1.setCity("Mytown");
        a1.setState("FL");
        a1.setZip("33555");
        a1.setPhone("555.5550");
        dao.addAuthor(a1);

        Book b = new Book();
        b.setIsbn("34345656");
        b.setTitle("Another Great Book!");
        b.setPublisherId(p.getPublisherId());
        b.setPrice(new BigDecimal("12.98"));
        b.setPublishDate(LocalDate.now());
        int[] authorIds = new int[2];
        authorIds[0] = a.getAuthorId();
        authorIds[1] = a1.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.addBook(b);

        Book fromDb = dao.getBookById(b.getBookId());
        assertTrue(areEqual(b, fromDb));

        dao.deleteBook(b.getBookId());
        fromDb = dao.getBookById(b.getBookId());
        assertNull(fromDb);
    }

    @Test
    public void updateBookTest() {
        Publisher p = new Publisher();
        p.setName("Little House");
        p.setStreet("23 Lane Street");
        p.setCity("Atown");
        p.setState("PA");
        p.setZip("34552");
        p.setPhone("555-0009");
        dao.addPublisher(p);

        Publisher p1 = new Publisher();
        p1.setName("Super House");
        p1.setStreet("54 Lane Street");
        p1.setCity("Btown");
        p1.setState("NY");
        p1.setZip("44445");
        p1.setPhone("555-9999");
        dao.addPublisher(p1);

        Author a = new Author();
        a.setFirstName("Stephen");
        a.setLastName("King");
        a.setStreet("45 Hallow Drive");
        a.setCity("Anothertown");
        a.setState("NY");
        a.setZip("33122");
        a.setPhone("555.6767");
        dao.addAuthor(a);

        Author a1 = new Author();
        a1.setFirstName("George");
        a1.setLastName("Jones");
        a1.setStreet("22 M Drive");
        a1.setCity("Mytown");
        a1.setState("FL");
        a1.setZip("33555");
        a1.setPhone("555.5550");
        dao.addAuthor(a1);

        Author a2 = new Author();
        a2.setFirstName("George");
        a2.setLastName("Jones");
        a2.setStreet("22 M Drive");
        a2.setCity("Mytown");
        a2.setState("FL");
        a2.setZip("33555");
        a2.setPhone("555.5550");
        dao.addAuthor(a2);

        Book b = new Book();
        b.setIsbn("34345656");
        b.setTitle("Another Great Book!");
        b.setPublisherId(p.getPublisherId());
        b.setPrice(new BigDecimal("12.98"));
        b.setPublishDate(LocalDate.now());
        int[] authorIds = new int[2];
        authorIds[0] = a.getAuthorId();
        authorIds[1] = a1.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.addBook(b);
        
        // change all the fields and add an author
        b.setIsbn("34345656Z");
        b.setTitle("Another Great Book!Z");
        b.setPublisherId(p1.getPublisherId());
        b.setPrice(new BigDecimal("14.99"));
        b.setPublishDate(LocalDate.of(1999, Month.DECEMBER, 31));
        authorIds = new int[3];
        authorIds[0] = a.getAuthorId();
        authorIds[1] = a1.getAuthorId();
        authorIds[2] = a2.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.updateBook(b);
        
        Book fromDb = dao.getBookById(b.getBookId());
        assertTrue(areEqual(b, fromDb));
        
        // remove two authors
        authorIds = new int[1];
        authorIds[0] = a1.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.updateBook(b);
        
        fromDb = dao.getBookById(b.getBookId());
        assertTrue(areEqual(b, fromDb));
    }
    
    @Test
    public void getBooksByAuthorTest() {
        Publisher p = new Publisher();
        p.setName("Little House");
        p.setStreet("23 Lane Street");
        p.setCity("Atown");
        p.setState("PA");
        p.setZip("34552");
        p.setPhone("555-0009");
        dao.addPublisher(p);

        Author a = new Author();
        a.setFirstName("Stephen");
        a.setLastName("King");
        a.setStreet("45 Hallow Drive");
        a.setCity("Anothertown");
        a.setState("NY");
        a.setZip("33122");
        a.setPhone("555.6767");
        dao.addAuthor(a);

        Author a1 = new Author();
        a1.setFirstName("George");
        a1.setLastName("Jones");
        a1.setStreet("22 M Drive");
        a1.setCity("Mytown");
        a1.setState("FL");
        a1.setZip("33555");
        a1.setPhone("555.5550");
        dao.addAuthor(a1);

        Book b = new Book();
        b.setIsbn("34345656");
        b.setTitle("Another Great Book!");
        b.setPublisherId(p.getPublisherId());
        b.setPrice(new BigDecimal("12.98"));
        b.setPublishDate(LocalDate.now());
        int[] authorIds = new int[2];
        authorIds[0] = a.getAuthorId();
        authorIds[1] = a1.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.addBook(b);
        
        List<Book> bList = dao.getBooksByAuthorId(a.getAuthorId());
        assertEquals(bList.size(), 1);
        assertTrue(areEqual(bList.get(0), b));

        Book b1 = new Book();
        b1.setIsbn("34367777");
        b1.setTitle("Another OK Book!");
        b1.setPublisherId(p.getPublisherId());
        b1.setPrice(new BigDecimal("17.98"));
        b1.setPublishDate(LocalDate.now());
        authorIds = new int[1];
        authorIds[0] = a.getAuthorId();
        b1.setAuthorIds(authorIds);
        dao.addBook(b1);
        
        bList = dao.getBooksByAuthorId(a.getAuthorId());
        assertEquals(bList.size(), 2);
    }
    
    @Test
    public void getBooksByPublisherTest() {
        Publisher p = new Publisher();
        p.setName("Little House");
        p.setStreet("23 Lane Street");
        p.setCity("Atown");
        p.setState("PA");
        p.setZip("34552");
        p.setPhone("555-0009");
        dao.addPublisher(p);

        Author a = new Author();
        a.setFirstName("Stephen");
        a.setLastName("King");
        a.setStreet("45 Hallow Drive");
        a.setCity("Anothertown");
        a.setState("NY");
        a.setZip("33122");
        a.setPhone("555.6767");
        dao.addAuthor(a);
        
        Book b = new Book();
        b.setIsbn("34345656");
        b.setTitle("Another Great Book!");
        b.setPublisherId(p.getPublisherId());
        b.setPrice(new BigDecimal("12.98"));
        b.setPublishDate(LocalDate.now());
        int[] authorIds = new int[1];
        authorIds[0] = a.getAuthorId();
        b.setAuthorIds(authorIds);
        dao.addBook(b);
        
        List<Book> bList = dao.getBooksByPublisherId(p.getPublisherId());
        assertEquals(bList.size(), 1);
        assertTrue(areEqual(bList.get(0), b));

        Book b1 = new Book();
        b1.setIsbn("34367777");
        b1.setTitle("Another OK Book!");
        b1.setPublisherId(p.getPublisherId());
        b1.setPrice(new BigDecimal("17.98"));
        b1.setPublishDate(LocalDate.now());
        authorIds = new int[1];
        authorIds[0] = a.getAuthorId();
        b1.setAuthorIds(authorIds);
        dao.addBook(b1);
        
        bList = dao.getBooksByPublisherId(p.getPublisherId());
        assertEquals(bList.size(), 2);
    }

    private boolean areEqual(Author au1, Author au2) {
        return au1.getAuthorId() == au2.getAuthorId()
                && au1.getFirstName().equals(au2.getFirstName())
                && au1.getLastName().equals(au2.getLastName())
                && au1.getStreet().equals(au2.getStreet())
                && au1.getCity().equals(au2.getCity())
                && au1.getState().equals(au2.getState())
                && au1.getZip().equals(au2.getZip())
                && au1.getPhone().equals(au2.getPhone());
    }

    private boolean areEqual(Publisher p1, Publisher p2) {
        return p1.getPublisherId() == p2.getPublisherId()
                && p1.getName().equals(p2.getName())
                && p1.getStreet().equals(p2.getStreet())
                && p1.getCity().equals(p2.getCity())
                && p1.getState().equals(p2.getState())
                && p1.getZip().equals(p2.getZip())
                && p1.getPhone().equals(p2.getPhone());
    }

    private boolean areEqual(Book b1, Book b2) {
        Arrays.sort(b1.getAuthorIds());
        Arrays.sort(b2.getAuthorIds());

        return b1.getBookId() == b2.getBookId()
                && b1.getIsbn().equals(b2.getIsbn())
                && b1.getTitle().equals(b2.getTitle())
                && b1.getPublisherId() == b2.getPublisherId()
                && b1.getPrice().equals(b2.getPrice())
                && b1.getPublishDate().equals(b2.getPublishDate())
                && Arrays.equals(b1.getAuthorIds(), b2.getAuthorIds());
    }

}
