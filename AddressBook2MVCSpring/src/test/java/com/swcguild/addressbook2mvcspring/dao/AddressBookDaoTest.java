/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2mvcspring.dao;

import com.swcguild.addressbook2mvcspring.model.Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");    
    
    AddressBookDao test, test2 ;
    Address add1, add2, add3;
    
    public AddressBookDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("DELETE FROM addresses");
        
        test  = ctx.getBean("dao", AddressBookDao.class);
        test2 = ctx.getBean("dao", AddressBookDao.class);
        
        add1 = new Address("Lao", "Jo", "401 S Main St", "Akron", "OH", "44311");
        add2 = new Address("Wheat", "Sam", "200 Central Ave", "Jersey City", "NJ", "07307");
        add3 = new Address("Smith", "Sally", "100 Oakland Ave", "Oakland", "CA", "93450");

    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void addGetDeleteAddress() {
        //Add contact to dao
       test.addAddress(add1);
       
       Address fromDb = test.getAddressById(add1.getAddressId());
                
       assertEquals(add1, fromDb);
       
       test.removeAddress(add1.getAddressId());       
       
       assertNull(test.getAddressById(add1.getAddressId()));       
       
    }
    @Test
    public void addressBookImpl() {
                
        test.addAddress(add1);
        test.addAddress(add2);
        test.addAddress(add3);

        List<Address> addr = new ArrayList<>();
        addr.add(add1);
        addr.add(add2);
        addr.add(add3);

        List<Address> addrByLN = new ArrayList<>();
        addrByLN.add(add1);

        List<Address> getAddr = test.listAddressesByLastName(add1.getLastName());
        assertEquals(getAddr.size(), 1);
        boolean result = addrByLN.equals(getAddr);       
        assertTrue(result);

        getAddr = test.listAllAddressesList();
        Collections.sort(addr);
        Collections.sort(getAddr);
        result = addr.equals(getAddr);
        assertTrue(result);
        
        int count = test.getNumberOfAddresses();
        assertEquals(count, 3);

         
        List<Address> addr1 = new ArrayList<>();
        addr1.add(add3);
        List<Address> getAddrCity = test.listAddressesByCity("Oakland") ;
        Collections.sort(addr1);
        Collections.sort(getAddrCity);
        result = addr1.equals(getAddrCity);
        assertTrue(result);
        
        List<Address> addr2 = new ArrayList<>();
        addr2.add(add1);
        List<Address> getAddrZip = test.listAddressesByZip("44311") ;
        Collections.sort(addr2);
        Collections.sort(getAddrZip);
        result = addr2.equals(getAddrZip);
        assertTrue(result);
        
        Map<String, List<Address>> addrState = test.listAddressesByState("OH");
        Map<String, List<Address>> addrState1 = new HashMap<>();
        List<Address> aList = new ArrayList<>();
        aList.add(add1);
        addrState1.put("Akron", aList);
        result = addrState.equals(addrState1);
        assertTrue(result);
       
    }   
}
