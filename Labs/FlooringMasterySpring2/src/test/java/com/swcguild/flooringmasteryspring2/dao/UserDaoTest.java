/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
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
public class UserDaoTest {
    //UserDao daoTest = new UserDaoImpl();
    ApplicationContext ctx;
    UserDao userDao;
    
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = (UserDao) ctx.getBean("userDao");
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
    public void userDaoTest() {
        try {
            userDao.loadUsers();
        } catch (FileNotFoundException fnf) {}
        
        HashMap<String, User> userList = userDao.listAllUsers();
        User user = userDao.checkIfUserExists("jolao", "hello");
        User myUser = new User("jolao", "Jo", "hello", "manager", 10);
        assertTrue(user.equals(myUser));

        User user1 = userDao.checkIfUserExists("samkeen", "world");
        User myUser1 = new User("samkeen", "Sam", "world", "employee", 05);
        assertTrue(user1.equals(myUser1));
        
        HashMap<String, User> myList = new HashMap<>();
        myList.put(myUser.getUserId(), myUser);
        myList.put(myUser1.getUserId(), myUser1);
        boolean result = userList.equals(myList);
        assertTrue(result);
        
    }
}
