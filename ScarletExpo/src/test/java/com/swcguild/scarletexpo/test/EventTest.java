/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.test;

import com.swcguild.scarletexpo.dao.interfaces.EventDao;
import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.model.Category;
import com.swcguild.scarletexpo.model.Event;
import com.swcguild.scarletexpo.model.Product;
import com.swcguild.scarletexpo.model.ProductItem;
import com.swcguild.scarletexpo.model.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author klove
 */
public class EventTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    JdbcTemplate dbCall;
    JdbcTemplate cleaner;

    //user
    User u1;

    //dao
    ScarletExpoDao sDao;
    EventDao eDao;

    //products
    Product p1;
    Product p2;
    Product p3;

    //product items
    ProductItem item1;
    ProductItem item2;
    ProductItem item3;
    

    //categories
    Category c1;
    Category c2;
    Category c3;
    
    //event
    Event e1;
    Event e2;
    Event e3;

    public EventTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbCall = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("DELETE FROM events_notes");
        cleaner.execute("DELETE FROM authorities");
        cleaner.execute("DELETE FROM events");
        cleaner.execute("DELETE FROM users");
        cleaner.execute("DELETE FROM notes");
        cleaner.execute("DELETE FROM event_product_items");
        cleaner.execute("DELETE FROM product_items");
        cleaner.execute("delete from products;");
        cleaner.execute("delete from categories;");
        
        
        //dao
        sDao = ctx.getBean("serviceLayer", ScarletExpoDao.class);
        eDao = ctx.getBean("eventDao", EventDao.class);
        
        //user 
        u1 = new User();
        u1.setFirstName("John");
        u1.setLastName("Doe");
        u1.setProfileId(3);
        u1.setUserPass("bubba");
        u1.setUserName("jdoe");
        u1.setAuthority("CUSTOMER_USER");
        
        //adding user
        sDao.addNewUser(u1);
        
        //categories
        c1 = new Category();
        c1.setCategoryName("Equipment");
        
        c2 = new Category();
        c2.setCategoryName("Venue");

        c3 = new Category();
        c3.setCategoryName("Basketball");
        
        //adding categories
        sDao.addNewCategory(c1);
        sDao.addNewCategory(c2);
        sDao.addNewCategory(c3);
        
        //products
        p1 = new Product();
        p1.setCategoryId(c1.getCategoryId());
        p1.setProductDesc("Basketball for games");
        p1.setProductName("Basketball");

        p2 = new Product();
        p2.setCategoryId(c1.getCategoryId());
        p2.setProductDesc("Football for games");
        p2.setProductName("Football");

        p3 = new Product();
        p3.setCategoryId(c1.getCategoryId());
        p3.setProductDesc("Soccer ball for games");
        p3.setProductName("Soccer");
        
        //adding products
        sDao.addNewProduct(p1);
        sDao.addNewProduct(p2);
        sDao.addNewProduct(p3);

        //product items
        item1 = new ProductItem();
        item1.setProductId(p1.getProductId());
        item1.setProductItemName(p1.getProductName() + " - " + 1);
        
        item2 = new ProductItem();
        item2.setProductId(p2.getProductId());
        item2.setProductItemName(p2.getProductName() + " - " + 1);
        
        item3 = new ProductItem();
        item3.setProductId(p3.getProductId());
        item3.setProductItemName(p3.getProductName() + " - " + 1);
        
        //adding product items
        sDao.addProductItems(item1);
        sDao.addProductItems(item2);
        
        //event
        e1 = new Event();
        e1.setEventDesc("Basketball Tournament");
        e1.setEventStart("2014-11-01");
        e1.setEventEnd("2014-11-10");
        e1.setReturnDate("2014-11-10");
        e1.setUserId(u1.getUserId());
        
        e2 = new Event();
        e2.setEventDesc("Intramural Football Tournament");
        e2.setEventStart("2014-11-19");
        e2.setEventEnd("2014-11-14");
        e2.setReturnDate("2014-12-01");
        e2.setUserId(u1.getUserId());
        
        e3 = new Event();
        e3.setEventDesc("European Soccer Tournament");
        e3.setEventStart("2014-11-14");
        e3.setEventEnd("2014-11-16");
        e3.setReturnDate("2014-11-18");
        e3.setUserId(u1.getUserId());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertEvent_getAllEvents_Test() {
        //add event
        eDao.createEvent(e1);
        eDao.createEvent(e2);
        eDao.createEvent(e3);
        
        List<Event> eList = eDao.getAllEvents();
        
        assertEquals(eList.size(), 3);
        
    }
}
