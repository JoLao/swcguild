/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Account;
import com.swcguild.dvdrentalstore.domain.AccountStatus;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class AccountDaoTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountDao accountDao1;
    AccountDao accountDao2;
    
    List<Account> acctList = new ArrayList<>();
    Account acct1, acct2, acct3, acct4, acct5, acct6, acct7;

    HashMap<Integer, Account> acctMap = new HashMap<>();
    
    boolean result;

    public AccountDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        accountDao1 = (AccountDaoImpl) ctx.getBean("accountDao");
        accountDao2 = (AccountDaoImpl) ctx.getBean("accountDao");

        // 1::atkinson::Sally Mae Atkinson::384 Palisades Ave::Jersey City::NJ::07307::201-364-3847::smae@gmail.com::GOOD
        acct1 = new Account();
        acct1.setAccountNumber(1);
        acct1.setUserId("atkinson");
        acct1.setName("Sally Mae Atkinson");
        acct1.setAddress("384 Palisades Ave");
        acct1.setCity("Jersey City");
        acct1.setState("NJ");
        acct1.setZipCode("07307");
        acct1.setPhone("201-364-3847");
        acct1.setEmail("smae@gmail.com");
        acct1.setStatus(AccountStatus.GOOD);

        //2::mklum::Klum Max::1928 Park Ave::New York::NY::10293::212-374-3847::mklum@msn.com::GOOD
        acct2 = new Account();
        acct2.setAccountNumber(2);
        acct2.setUserId("mklum");
        acct2.setName("Klum Max");
        acct2.setAddress("1928 Park Ave");
        acct2.setCity("New York");
        acct2.setState("NY");
        acct2.setZipCode("10293");
        acct2.setPhone("212-374-3847");
        acct2.setEmail("mklum@msn.com");
        acct2.setStatus(AccountStatus.GOOD);

        //3::jklum::Jake Klum::902 Park Ave::New York::NY::10394::212-384-2837::jklum123@yahoo.com::GOOD
        acct3 = new Account();
        acct3.setAccountNumber(3);
        acct3.setUserId("jklum");
        acct3.setName("Jake Klum");
        acct3.setAddress("902 Park Ave");
        acct3.setCity("New York");
        acct3.setState("NY");
        acct3.setZipCode("10394");
        acct3.setPhone("212-384-2837");
        acct3.setEmail("jklum123@yahoo.com");
        acct3.setStatus(AccountStatus.GOOD);

        //4::hklum::Heidi Klum::145 Central Park West::New York::NY::12948::212-374-4847::hklum@gmail.com::GOOD
        acct4 = new Account();
        acct4.setAccountNumber(4);
        acct4.setUserId("hklum");
        acct4.setName("Heidi Klum");
        acct4.setAddress("145 Central Park West");
        acct4.setCity("New York");
        acct4.setState("NY");
        acct4.setZipCode("12948");
        acct4.setPhone("212-374-4847");
        acct4.setEmail("hklum@gmail.com");
        acct4.setStatus(AccountStatus.GOOD);

        //5::jlao::Jo Lao::401 S Main St::Akron::OH::44311::201-374-3823::jolao123@msn.com::GOOD
        acct5 = new Account();
        acct5.setAccountNumber(5);
        acct5.setUserId("jlao");
        acct5.setName("Jo Lao");
        acct5.setAddress("401 S Main St");
        acct5.setCity("Akron");
        acct5.setState("OH");
        acct5.setZipCode("44311");
        acct5.setPhone("201-374-3823");
        acct5.setEmail("jolao123@msn.com");
        acct5.setStatus(AccountStatus.GOOD);

        //6::swheat1::Sam Wheat::300 Malibu Drive::Los Angeles::CA::90383::928-487-1837::swheat@gmail.com::GOOD
        acct6 = new Account();
        acct6.setAccountNumber(6);
        acct6.setUserId("swheat1");
        acct6.setName("Sam Wheat");
        acct6.setAddress("300 Malibu Drive");
        acct6.setCity("Los Angeles");
        acct6.setState("CA");
        acct6.setZipCode("90383");
        acct6.setPhone("928-487-1837");
        acct6.setEmail("swheat@gmail.com");
        acct6.setStatus(AccountStatus.GOOD);

        //7::swheat2::Sheila Wheat::100 Main St::Rochester::NY::10283::917-283-2938::sheilaw@comcast.net::GOOD
        acct7 = new Account();
        acct7.setAccountNumber(7);
        acct7.setUserId("swheat2");
        acct7.setName("Sheila Wheat");
        acct7.setAddress("100 Main St");
        acct7.setCity("Rochester");
        acct7.setState("NY");
        acct7.setZipCode("10283");
        acct7.setPhone("917-283-2938");
        acct7.setEmail("sheilaw@comcast.net");
        acct7.setStatus(AccountStatus.GOOD);

        acctList.add(acct1);
        acctList.add(acct2);
        acctList.add(acct3);
        acctList.add(acct4);
        acctList.add(acct5);
        acctList.add(acct6);
        acctList.add(acct7);
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
    public void accountDaoTest() {
        accountDao1.setMode("TEST");
        accountDao2.setMode("TEST");
        
        try {
            accountDao1.loadAccountFile();
        } catch (FileNotFoundException fnf) {

        }
        
        List<Account> acctListFrDao = accountDao1.listAllAccounts();
        Collections.sort(acctListFrDao);
        Collections.sort(acctList);
        result = acctListFrDao.equals(acctList);
        
//        for (int i=0; i < acctList.size(); i++) {
//            System.out.println(i+") "+acctList.get(i).getAccountNumber()+" "+acctList.get(i).getUserId()+" "+
//                               acctList.get(i).getName()+" "+acctList.get(i).getAddress()+" "+
//                               acctList.get(i).getCity()+" "+acctList.get(i).getState()+acctList.get(i).getZipCode()+" "+
//                               acctList.get(i).getPhone()+" "+acctList.get(i).getStatus());
//        }
//        
//        for (int i=0; i < acctListFrDao.size(); i++) {
//            System.out.println(i+") "+acctListFrDao.get(i).getAccountNumber()+" "+acctListFrDao.get(i).getUserId()+" "+
//                               acctListFrDao.get(i).getName()+" "+acctListFrDao.get(i).getAddress()+" "+
//                               acctListFrDao.get(i).getCity()+" "+acctListFrDao.get(i).getState()+acctListFrDao.get(i).getZipCode()+" "+
//                               acctListFrDao.get(i).getPhone()+" "+acctListFrDao.get(i).getStatus());
//        }
        assertTrue(result);
        
        Account acctFrDao = accountDao1.getAccount(1);
        result = acctFrDao.equals(acct1);
        assertTrue(result);
                
        int lastAcctNumFrDao = accountDao1.getLastAccountNumber();
        int lastAcctNum = acctList.size();
        assertEquals (lastAcctNumFrDao, lastAcctNum);
        
        result = accountDao1.checkIfAccountExists(1);
        assertTrue(result);
        acct1.setStatus(AccountStatus.DELINQUENT);
        accountDao1.getAccount(1).setStatus(AccountStatus.DELINQUENT);
        try {
            accountDao1.saveAccountFile();
            accountDao2.loadAccountFile();
        } catch (Exception e) {}
        
        
        acctListFrDao = accountDao2.listAllAccounts();
        Collections.sort(acctListFrDao);
        Collections.sort(acctList);
        result = accountDao2.listAllAccounts().equals(accountDao1.listAllAccounts());
//        result = acctListFrDao.equals(acctList);
        assertTrue(result);
        
    }
}
