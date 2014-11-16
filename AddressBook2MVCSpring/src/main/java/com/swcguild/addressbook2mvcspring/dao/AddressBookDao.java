/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2mvcspring.dao;

import com.swcguild.addressbook2mvcspring.model.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao {

    void addAddress(Address address);

    void editAddress(Address address);
            
    Address getAddressById(int addressId);

    int getNumberOfAddresses();

    List<Address> listAddressesByCity(String city);

    List<Address> listAddressesByLastName(String lastName);

    Map<String, List<Address>> listAddressesByState(String state);

    List<Address> listAddressesByZip(String zip);

    List<Address> listAllAddressesList();

    void removeAddress(int addressId);
    
}
