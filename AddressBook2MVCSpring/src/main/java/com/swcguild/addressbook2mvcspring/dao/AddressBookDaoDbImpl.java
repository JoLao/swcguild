/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2mvcspring.dao;

import com.swcguild.addressbook2mvcspring.model.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoDbImpl implements AddressBookDao {

    private static final String SQL_INSERT_ADDRESS
            = "INSERT INTO addresses (first_name, last_name, street, city, state, zip) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_ADDRESS
            = "UPDATE addresses SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, zip = ? "
            + "WHERE address_id = ?";

    private static final String SQL_DELETE_ADDRESS
            = "DELETE FROM addresses WHERE address_id = ?";

    private static final String SQL_COUNT_ADDRESSES
            = "SELECT count(*) FROM addresses";
    
    private static final String SQL_SELECT_ADDRESS_BY_ID
            = "SELECT * FROM addresses WHERE address_id = ?";
    
    private static final String SQL_SELECT_ALL_ADDRESS
            = "SELECT * FROM addresses";

    private static final String SQL_SELECT_ADDRESS_BY_LAST_NAME
            = "SELECT * FROM addresses WHERE last_name = ?";

    private static final String SQL_SELECT_ADDRESS_BY_CITY
            = "SELECT * FROM addresses WHERE city = ?";
    
    private static final String SQL_SELECT_ADDRESS_BY_STATE
            = "SELECT * FROM addresses WHERE state = ? ORDER BY city";
    
    private static final String SQL_SELECT_ADDRESS_BY_ZIP
            = "SELECT * FROM addresses WHERE zip = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly = false)
    public void addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                     address.getFirstName(),
                     address.getLastName(),
                     address.getStreet(),
                     address.getCity(),
                     address.getState(),
                     address.getZipCode());
        address.setAddressId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void editAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                     address.getFirstName(),
                     address.getLastName(),
                     address.getStreet(),
                     address.getCity(),
                     address.getState(),
                     address.getZipCode(),
                     address.getAddressId());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS_BY_ID, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException e) {
            return null;                        
        }
    }

    @Override
    public int getNumberOfAddresses() {
        return jdbcTemplate.queryForObject(SQL_COUNT_ADDRESSES, Integer.class);
    }

    @Override
    public List<Address> listAddressesByCity(String city) {
        return jdbcTemplate.query(SQL_SELECT_ADDRESS_BY_CITY, new AddressMapper(), city);
    }

    @Override
    public List<Address> listAddressesByLastName(String lastName) {
        return jdbcTemplate.query(SQL_SELECT_ADDRESS_BY_LAST_NAME, new AddressMapper(), lastName);
    }

    @Override
    public Map<String, List<Address>> listAddressesByState(String state) {
        return jdbcTemplate.query(SQL_SELECT_ADDRESS_BY_STATE, new AddressMapper(), state)
                .stream()
                .collect(Collectors.groupingBy(a -> a.getCity()));                
    }

    @Override
    public List<Address> listAddressesByZip(String zip) {
        return jdbcTemplate.query(SQL_SELECT_ADDRESS_BY_ZIP, new AddressMapper(), zip);
    }

    @Override
    public List<Address> listAllAddressesList() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESS, new AddressMapper());
    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    private static final class AddressMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int i) 
            throws SQLException{
            Address a = new Address();
            a.setAddressId(rs.getInt("address_id"));
            a.setFirstName(rs.getString("first_name"));
            a.setLastName(rs.getString("last_name"));
            a.setStreet(rs.getString("street"));
            a.setCity(rs.getString("city"));
            a.setState(rs.getString("state"));
            a.setZipCode(rs.getString("zip"));
            return a;
        }
    }
}
