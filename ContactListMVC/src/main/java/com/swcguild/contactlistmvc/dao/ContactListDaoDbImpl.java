/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class ContactListDaoDbImpl implements ContactListDao {

    private static final String SQL_INSERT_CONTACT
            = "insert into contacts (first_name, last_name, company, phone, email) "
            + "values (?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where contact_id = ?";
    
    private static final String SQL_UPDATE_CONTACT
            = "update contacts set first_name = ?, last_name = ?, company = ?, "
            + "phone = ?, email = ? where contact_id = ?";
    
    private static final String SQL_SELECT_ALL_CONTACTS
            = "select * from contacts";
    
    private static final String SQL_SELECT_BY_ID
            = "select * from contacts where contact_id = ?";
            
    private static final String SQL_SELECT_CONTACTS_BY_LAST_NAME
            = "select * from contacts where last_name = ?";
    
    private static final String SQL_SELECT_CONTACTS_BY_COMPANY
            = "select * from contacts where company = ?";
    
    private JdbcTemplate jdbcTemplate;

    //@Inject --> doesn't work in test as test is outside of spring container
    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
        
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addContact(Contact contact) {
        
        jdbcTemplate.update(SQL_INSERT_CONTACT, 
                            contact.getFirstName(),
                            contact.getLastName(),
                            contact.getCompany(),
                            contact.getPhone(),
                            contact.getEmail());
        contact.setContactId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void removeContact(int contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT, 
                            contact.getFirstName(),
                            contact.getLastName(),
                            contact.getCompany(),
                            contact.getPhone(),
                            contact.getEmail(),
                            contact.getContactId());
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper());
    }

    @Override
    public Contact getContactById(int contactId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Contact> searchContactsByLastName(String lastName) {        
        return jdbcTemplate.query(SQL_SELECT_CONTACTS_BY_LAST_NAME, new ContactMapper(), lastName);        
    }

    @Override
    public List<Contact> searchContactsByCompany(String company) {
        return jdbcTemplate.query(SQL_SELECT_CONTACTS_BY_COMPANY, new ContactMapper(), company);
    }
    
    private static final class ContactMapper implements ParameterizedRowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            return contact;
        }
        
    }
}
