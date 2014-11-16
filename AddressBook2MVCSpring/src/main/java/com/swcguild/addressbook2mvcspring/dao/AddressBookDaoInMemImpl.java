package com.swcguild.addressbook2mvcspring.dao;

import com.swcguild.addressbook2mvcspring.model.Address;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookDaoInMemImpl implements AddressBookDao {

    private Map<Integer, Address> addressMap = new HashMap<>();
    private static int addressIdCounter = 0; 

  
    @Override
    public void addAddress(Address address) {
        address.setAddressId(addressIdCounter++);
        addressMap.put(address.getAddressId(), address); 
    }

    @Override
    public void editAddress(Address address) {
        addressMap.put(address.getAddressId(), address);
    }
  
    @Override
    public void removeAddress(int addressId) {       
        addressMap.remove(addressId);        
    }

   
    @Override
    public int getNumberOfAddresses() {
        
        return addressMap.values().size();
    }
    
    @Override
    public Address getAddressById(int addressId) {
        return addressMap.get(addressId);
    }   

   
    @Override
    public List<Address> listAllAddressesList() {
        List<Address> addressList = Arrays.asList(addressMap.values().toArray(new Address[0]));
        
        Collections.sort(addressList);
        
        return addressList;
    }
       

    @Override
    public List<Address> listAddressesByLastName(String lastName) {
        
        return addressMap.values().stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        
    }


    @Override
    public List<Address> listAddressesByCity(String city) {
        return addressMap.values().stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

 
    @Override
    public Map<String, List<Address>>  listAddressesByState(String state) {
        return addressMap.values().stream()
                .filter(a -> a.getState().equalsIgnoreCase(state))
                .collect(Collectors.groupingBy(a -> a.getCity()));
    }


    @Override
    public List<Address> listAddressesByZip(String zip) {
        return addressMap.values().stream()
                .filter(a -> a.getZipCode().equalsIgnoreCase(zip))
                .collect(Collectors.toList());
    }
      
}
