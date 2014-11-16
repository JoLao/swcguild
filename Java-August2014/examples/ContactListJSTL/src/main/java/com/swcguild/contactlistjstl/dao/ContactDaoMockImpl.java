/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistjstl.dao;

import com.swcguild.contactlistjstl.model.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ContactDaoMockImpl implements ContactDao {

    @Override
    public List<Contact> getContacts() {
        Contact c1 = new Contact();
        c1.setName("John Doe");
        c1.setPhone("555-1212");
        c1.setEmail("jdoe@doe.com");
        
        Contact c2 = new Contact();
        c2.setName("Jane Smith");
        c2.setPhone("444-1234");
        c2.setEmail("jsmith@smith.com");
        
        List<Contact> myList = new ArrayList<>();
        myList.add(c1);
        myList.add(c2);
        return myList;
    }
    
}
