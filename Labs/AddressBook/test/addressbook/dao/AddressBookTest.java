/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
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
public class AddressBookTest {

    public AddressBook test;

    public AddressBookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new AddressBook();
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
    public void addressBookTest() {
        Address add1 = new Address("Lao", "Jo", "401 S Main St", "Akron", "OH", "44311");
        Address add2 = new Address("Wheat", "Sam", "200 Central Ave", "Jersey City", "NJ", "07307");
        Address add3 = new Address("Smith", "Sally", "100 Oakland Ave", "Oakland", "CA", "93450");

        test.addAddress(add1.getLastName(), add1);
        Address getAddr = test.findAddress(add1.getLastName());

        //assertEquals(add1, getAddr);
        boolean result = add1.equals(getAddr);
        assertTrue(result);

        int count = test.getNumberOfAddresses();
        assertEquals(count, 1);

        test.addAddress(add2.getLastName(), add2);
        test.addAddress(add3.getLastName(), add3);

        getAddr = test.removeAddress("Smith");
        assertEquals(add3, getAddr);

        Address[] addrArray = test.listAllAddresses();
        Arrays.sort(addrArray);
        Address[] addrInput = new Address[2];
        addrInput[0] = add1;
        addrInput[1] = add2;

        boolean arrayTest = Arrays.equals(addrArray, addrInput);
        assertTrue(arrayTest);

        try {
            test.saveToFile("test.txt");
        } catch (IOException e) {
            System.out.println("Output Error : " + e.getMessage());
        }
        
        AddressBook test2 = new AddressBook();
        try {
            test2.loadFromFile("test.txt");
            Address[] addrArray2 = test2.listAllAddresses();
            Arrays.sort(addrArray2);
            boolean arrayTest2 = Arrays.equals(addrArray, addrInput);
            assertTrue(arrayTest2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+e.getMessage());
        }
    }
}
