/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.client;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author apprentice
 */
public class ContactListRESTClient {
    public static void main(String[] args) {
        ContactListRESTClient client = new ContactListRESTClient();
        
        Contact newContact = new Contact();
        newContact.setFirstName("John");
        newContact.setLastName("Doe");
        newContact.setCompany("Oracle");
        newContact.setEmail("jdoe@oracle.com");
        newContact.setPhone("555-1212");
        
        client.createContact(newContact);
        
        System.out.println("New ID = "+ newContact.getContactId());
    }
    
    public Contact createContact(Contact contact) {
        RestTemplate rt = new RestTemplate();
        
        //message converter
        List<HttpMessageConverter<?>>  converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());  //goes from java to json
        //set message converter on our rest template
        rt.setMessageConverters(converters);
        return rt.postForObject("http://localhost:8080/ContactListMVC/spring/rest/contact", contact, Contact.class);
    }
}
