/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class TransactionDaoTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    TransactionDao txnDao1;
    TransactionDao txnDao2;

    Transaction txn1, txn2, txn3, txn4;

    public TransactionDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        txn1 = new Transaction();
        
        //1::2014-10-02::11::2014-10-04::4.95::5::9.95
        //1::2014-10-04::5::2014-10-06::3.75::3::6.75
        txn1.setAccountNumber(1);
        txn1.setCheckOutDate(LocalDate.parse("2014-10-02", DateTimeFormatter.ISO_DATE));
        txn1.setDvdNumber(1);
        txn1.setDateDue(LocalDate.parse("2014-10-02", DateTimeFormatter.ISO_DATE).plusDays(2));
        txn1.setDateReturned(null);
        txn1.setRentalFee(4.95);
        txn1.setLateFees(5);
        txn1.setBalance(4.95 + 5);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
