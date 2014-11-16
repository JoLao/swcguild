/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistjstl.dao;

import com.swcguild.contactlistjstl.model.Contact;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ContactDao {
    
    public List<Contact> getContacts();
    
}
