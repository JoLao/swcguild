/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping("/rest")
public class ContactRESTController {
    
    private ContactListDao dao;

    @Inject
    public ContactRESTController(ContactListDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }
        
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public Contact createContact(@RequestBody Contact contact) {
        dao.addContact(contact);
        return contact;
    }
    
    @RequestMapping(value="contact/{id}", method=RequestMethod.GET)
    @ResponseBody public Contact getContact(@PathVariable("id") int id) {
        return dao.getContactById(id);
    }
    
    @RequestMapping(value="/contact/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //no need for response body annotation if you're not returning anything back
    public void putContact(@PathVariable("id") int id, @RequestBody Contact contact) {
        contact.setContactId(id);
        dao.updateContact(contact);
    }
    
    @RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
        dao.removeContact(id);
    }
}
