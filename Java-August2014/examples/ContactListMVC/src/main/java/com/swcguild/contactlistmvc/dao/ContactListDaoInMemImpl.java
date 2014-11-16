/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ContactListDaoInMemImpl implements ContactListDao {
    
    private Map<Integer, Contact> contactMap = new HashMap<>();
    private static int contactIdCounter = 0;

    @Override
    public void addContact(Contact contact) {
        contact.setContactId(contactIdCounter++);
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);
     }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        Collection<Contact> c = contactMap.values();
        return new ArrayList(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContactsByLastName(String lastName) {
        return contactMap.values().stream()
                .filter(c -> c.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> searchContactsByCompany(String company) {
        return contactMap.values().stream()
                .filter(c -> c.getCompany().equals(company))
                .collect(Collectors.toList());
    }
    
}
