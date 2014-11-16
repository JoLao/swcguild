/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
public class ContactListDaoTest {
    
    ContactListDao dao;
    Contact c1;
    Contact c2;
    
    public ContactListDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
       
        JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("delete from contacts");
        
        dao = ctx.getBean("contactListDao", ContactListDao.class);
        // This line does the same thing as the line above
        //dao = (ContactListDao) ctx.getBean("contactListDao");
        
        c1 = new Contact();
        c1.setFirstName("John");
        c1.setLastName("Doe");
        c1.setCompany("Oracle");
        c1.setEmail("jdoe@oracle.com");
        c1.setPhone("555-1212");
        
        c2 = new Contact();
        c2.setFirstName("Sally");
        c2.setLastName("Smith");
        c2.setCompany("Apple");
        c2.setEmail("ssmith@apple.com");
        c2.setPhone("555-5678");
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetDeleteContact() {
        // Add contact to dao
        dao.addContact(c1);
        
        Contact fromDb = dao.getContactById(c1.getContactId());
        
        assertEquals(c1, fromDb);
        
        dao.removeContact(c1.getContactId());
        
        assertNull(dao.getContactById(c1.getContactId()));
    }
    
    @Test
    public void getAllContacts() {
        dao.addContact(c1);
        dao.addContact(c2);
        
        List<Contact> cList = dao.getAllContacts();
        assertEquals(cList.size(), 2);
    }
    
}
