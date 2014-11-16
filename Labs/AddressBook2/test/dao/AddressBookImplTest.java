/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import addressbook2.dao.AddressBookImpl;
import addressbook2.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class AddressBookImplTest {

    public AddressBookImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addressBookImpl() {
        AddressBookImpl test = new AddressBookImpl();

        Address add1 = new Address("Lao", "Jo", "401 S Main St", "Akron", "OH", "44311");
        Address add2 = new Address("Wheat", "Sam", "200 Central Ave", "Jersey City", "NJ", "07307");
        Address add3 = new Address("Smith", "Sally", "100 Oakland Ave", "Oakland", "CA", "93450");

        test.addAddress(add1.getLastName(), add1);
        test.addAddress(add2.getLastName(), add2);
        test.addAddress(add3.getLastName(), add3);

        List<Address> addr = new ArrayList<>();
        addr.add(add1);
        addr.add(add2);
        addr.add(add3);

        List<Address> addrByLN = new ArrayList<>();
        addrByLN.add(add1);

        List<Address> getAddr = test.listAddressesByLastName(add1.getLastName());
        assertEquals(getAddr.size(), 1);
        boolean result = addrByLN.equals(getAddr);
        assertTrue(result);

        getAddr = test.listAllAddressesList();
        Collections.sort(addr);
        Collections.sort(getAddr);
        result = addr.equals(getAddr);
        assertTrue(result);
        
        int count = test.getNumberOfAddresses();
        assertEquals(count, 3);

        addr.remove(add2);
        Address add4 = test.removeAddress(add2);
        result = addr.equals(getAddr);
        assertTrue(result);

        Address[] addrArray = test.listAllAddressesArray();
        Arrays.sort(addrArray);
        Address[] addrInput = new Address[2];
        addrInput[0] = add1;
        addrInput[1] = add3;

        boolean arrayTest = Arrays.equals(addrArray, addrInput);
        assertTrue(arrayTest);
        
        addrArray = test.findAddressArray(add1.getLastName());
        addrInput = new Address[1];
        addrInput[0] = add1;
        
        arrayTest = Arrays.equals(addrArray, addrInput);
        assertTrue(arrayTest);
        
        List<Address> addr1 = new ArrayList<>();
        addr1.add(add3);
        List<Address> getAddrCity = test.listAddressesByCity("Oakland") ;
        Collections.sort(addr1);
        Collections.sort(getAddrCity);
        result = addr1.equals(getAddrCity);
        assertTrue(result);
        
        List<Address> addr2 = new ArrayList<>();
        addr2.add(add1);
        List<Address> getAddrZip = test.listAddressesByZip("44311") ;
        Collections.sort(addr2);
        Collections.sort(getAddrZip);
        result = addr2.equals(getAddrZip);
        assertTrue(result);
        
        Map<String, List<Address>> addrState = test.listAddressesByState("OH");
        Map<String, List<Address>> addrState1 = new HashMap<>();
        List<Address> aList = new ArrayList<>();
        aList.add(add1);
        addrState1.put("Akron", aList);
        result = addrState.equals(addrState1);
        assertTrue(result);

        try {
            test.saveToFile("test.txt");
        } catch (IOException e) {
            System.out.println("Output Error : " + e.getMessage());
        }
        
        AddressBookImpl test2 = new AddressBookImpl();
        try {
            test2.loadFromFile("test.txt");
            List<Address> addrList2 = test2.listAllAddressesList();
            Collections.sort(addrList2);
            boolean listTest2 = addrList2.equals(getAddr);
            assertTrue(listTest2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e.getMessage());
        }
    }   
}
