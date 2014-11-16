/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.test;

import com.swcguild.scarletexpo.dao.interfaces.UserDao;
import com.swcguild.scarletexpo.model.User;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author klove
 */
public class UserTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    JdbcTemplate dbCall;
    JdbcTemplate cleaner;
    
    //User
    User u1;
    User u2;
    User u3;
    User u4;
    
    //Dao
    UserDao uDao;
    
    //prepared sql
    public static String SQL_SELECT_AUTHORITY_NUM;
    public static String SQL_INSERT_PROFILENAME;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbCall = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("DELETE FROM events");
        cleaner.execute("DELETE FROM authorities");
        cleaner.execute("DELETE FROM users");
        
        
        uDao = ctx.getBean("userDao", UserDao.class);
        
         //users
        u1 = new User();
        u1.setFirstName("John");
        u1.setLastName("Doe");
        u1.setProfileId(3);
        u1.setUserPass("bubba");
        u1.setUserName("jdoe");
        u1.setAuthority("CUSTOMER_USER");
        
        u2 = new User();
        u2.setFirstName("Sally");
        u2.setLastName("Smith");
        u2.setProfileId(2);
        u2.setUserPass("sister");
        u2.setUserName("ssmith");
        u2.setAuthority("EMPLOYEE_USER");
        
        u3 = new User();
        u3.setFirstName("Forrest");
        u3.setLastName("Gump");
        u3.setProfileId(2);
        u3.setUserPass("shrimp");
        u3.setUserName("bgump");
        u3.setAuthority("MANAGER_USER");
        
        u4 = new User();
        u4.setFirstName("Ben");
        u4.setLastName("Blue");
        u4.setProfileId(1);
        u4.setUserPass("boat");
        u4.setUserName("bblue");
        u4.setAuthority("ADMIN_USER");
        
        //prepared sql
        SQL_SELECT_AUTHORITY_NUM = "SELECT COUNT(*) FROM authorities WHERE username = ?";
        SQL_INSERT_PROFILENAME = "INSERT INTO profiles (profileName) VALUES (?)";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addUser_Test() {
        //add users
        uDao.addUser(u1);
        uDao.addUser(u2);
        uDao.addUser(u3);
        uDao.addUser(u4);
        
        
        //retrieving number of records per user
        int result1 = dbCall.queryForObject(SQL_SELECT_AUTHORITY_NUM, Integer.class, u1.getUserName());
        int result2 = dbCall.queryForObject(SQL_SELECT_AUTHORITY_NUM, Integer.class, u2.getUserName());
        int result3 = dbCall.queryForObject(SQL_SELECT_AUTHORITY_NUM, Integer.class, u3.getUserName());
        int result4 = dbCall.queryForObject(SQL_SELECT_AUTHORITY_NUM, Integer.class, u4.getUserName());
        
        assertEquals(result1, 1);
        assertEquals(result2, 2);
        assertEquals(result3, 3);
        assertEquals(result4, 4);     
    }
    
    @Test
    public void get_UserById_UpdateUser_Test() {
        //add user
        uDao.addUser(u1);
        
        User fromDB = uDao.getUserByUserId(u1.getUserId());
        
        fromDB.setFirstName("Abraham");
        fromDB.setLastName("Lincoln");
        fromDB.setAuthority("ADMIN_USER");
        
        uDao.updateUser(fromDB);
        
        User updateFromDB = uDao.getUserByUserId(u1.getUserId());
        
        assertThat(fromDB, not(equalTo(updateFromDB)));   
    }
    
    @Test
    public void getByProfileId_updateProfile_Test() {
        //add users
        uDao.addUser(u1);
        uDao.addUser(u2);
        uDao.addUser(u3);
        uDao.addUser(u4);
        
        //getting list of users by profile id
        List<User> uList = uDao.getUsersByProfileId(2);
        
        //testing number returned
        assertEquals(uList.size(), 2);
        
        //resetting a profile id
        u2.setProfileId(3);
        
        //updating the profile of the user
        uDao.updateProfile(u2);
        
        //refilling the list
        uList.clear();
        uList = uDao.getUsersByProfileId(2);
        
        //testing the list size
        assertEquals(uList.size(), 1);
        
        //refilling the list for the updated profile
        uList.clear();
        uList = uDao.getUsersByProfileId(3);
        
        //testing the list size
        assertEquals(uList.size(), 2);
    }
    
    @Test
    public void getAllUsers_Test() {
        //add users
        uDao.addUser(u1);
        uDao.addUser(u2);
        uDao.addUser(u3);
        uDao.addUser(u4);
        
        //getting list of users
        List<User> uList = uDao.getAllUsers();
        
        //testing list size
        assertEquals(uList.size(), 4);
    }
    
    @Test
    public void getUserByUserName() {
        //add users
        uDao.addUser(u1);
        uDao.addUser(u2);
        uDao.addUser(u3);
        uDao.addUser(u4);
        
        User fromDb = uDao.getUserByUserName(u1.getUserName());
        
        //testing individual parts of the user object
        assertEquals(fromDb.getUserName(), u1.getUserName());
        assertEquals(fromDb.getFirstName(), u1.getFirstName());
        assertEquals(fromDb.getLastName(), u1.getLastName());
        assertEquals(fromDb.getProfileId(), u1.getProfileId());   
    }
}
