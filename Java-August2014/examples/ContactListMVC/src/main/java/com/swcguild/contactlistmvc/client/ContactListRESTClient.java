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
        
        Contact c = new Contact();
        c.setFirstName("John");
        c.setLastName("Doe");
        c.setCompany("Oracle");
        c.setEmail("jdoe@oracle.com");
        c.setPhone("555.1212");
        client.createContact(c);
        
        System.out.println("New ID = " + c.getContactId());
        
    }
    
    public Contact createContact(Contact contact) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());
        rt.setMessageConverters(converters);
        return rt.postForObject("http://localhost:8080/ContactListMVC/spring/rest/contact", contact, Contact.class);        
    }
    
}
