package com.swcguild.scarletexpo.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductDao;
import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.dao.interfaces.UserDao;
import com.swcguild.scarletexpo.model.Category;
import com.swcguild.scarletexpo.model.Product;
import com.swcguild.scarletexpo.model.User;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class ServiceLayerJUnitTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    JdbcTemplate dbCall;
    JdbcTemplate cleaner;

    //DAO
    CategoryDao cdao;
    ProductDao dao;
    ScarletExpoDao sDao;


    //Products
    Product p1;
    Product p2;
    Product p3;
    Product p4;

    //Categories
    Category c1;
    Category c2;
    Category c3;

    //User
    User u1;
    User u2;
    User u3;
    User u4;

    //SQL
    public static String SQL_SELECT_AUTHORITY_NUM;

    @Before
    public void setUp() {

        dbCall = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("DELETE FROM events");
        cleaner.execute("DELETE FROM authorities");
        cleaner.execute("DELETE FROM users");
        cleaner.execute("DELETE FROM notes");
        cleaner.execute("DELETE FROM product_items");
        cleaner.execute("delete from products;");
        cleaner.execute("delete from categories;");

        dao = ctx.getBean("productDao", ProductDao.class);
        cdao = ctx.getBean("categoryDao", CategoryDao.class);
        sDao = ctx.getBean("serviceLayer", ScarletExpoDao.class);

        //categories
        c1 = new Category();

        c1.setCategoryName("Equipment");
        cdao.addCategory(c1);

        c2 = new Category();
        c2.setCategoryName("Venue");

        c3 = new Category();
        c3.setCategoryName("Basketball");

        //products
        p1 = new Product();
        p1.setCategoryId(c1.getCategoryId());
        p1.setProductDesc("Basketball for games");
        p1.setActive(true);
        //p1.setProductId(1);
        p1.setProductName("Basketball");

        //dao.addProduct(p1);
        p2 = new Product();
        p2.setCategoryId(c1.getCategoryId());
        p2.setProductDesc("Football for games");
        p2.setActive(true);
        //p2.setProductId(2);
        p2.setProductName("Football");

        //dao.addProduct(p2);
        p3 = new Product();
        p3.setCategoryId(c1.getCategoryId());
        p3.setProductDesc("Soccer ball for games");
        p3.setActive(true);
        p3.setProductName("Soccer");

        //dao.addProduct(p3);   
        p4 = new Product();

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

    }

    //products
    @Test
    public void addProduct() {
        sDao.addNewProduct(p1);

        Product fromDb = sDao.getProductById(p1.getProductId());

        assertEquals(p1, fromDb);

        fromDb = sDao.getProductById(p2.getProductId());
        assertNull(fromDb);
    }

    @Test
    public void updateProduct() {
        sDao.addNewProduct(p3);

        Product fromDb = sDao.getProductById(p3.getProductId());
        fromDb.setProductName("Rugby");
        fromDb.setProductDesc("Rugby Ball");
        fromDb.setActive(true);

        //update product
        sDao.updateProduct(fromDb);

        //testing changes
        Product updatedFromDb = sDao.getProductById(p3.getProductId());
        assertEquals(updatedFromDb.getProductName(), fromDb.getProductName());
        assertEquals(updatedFromDb.getProductDesc(), fromDb.getProductDesc());
    }

    //categories
    @Test
    public void addCategories() {
        sDao.addNewCategory(c2);
        sDao.addNewCategory(c3);

        //testing to ensure that we can retrieve category by name
        Category fromDB = sDao.getCategoryByName("Venue");
        boolean result = c2.equals(fromDB);
        assertTrue(result);

        fromDB = sDao.getCategoryByName("Rugby");
        result = c3.equals(fromDB);
        assertFalse(result);
    }

    @Test
    public void listCategories() {
        //adding categories
        sDao.addNewCategory(c2);
        sDao.addNewCategory(c3);

        //creating category list
        List<Category> cList = sDao.getAllCategories();

        int listSize = cList.size();
        assertEquals(listSize, 3);

        Category cFromList = cList.get(1);
        boolean result = cFromList.equals(c1);
        assertTrue(result);

        cFromList = cList.get(2);
        result = cFromList.equals(c2);
        assertTrue(result);
    }

    @Test
    public void updateCategory() {
        //adding categories
        sDao.addNewCategory(c2);
        sDao.addNewCategory(c3);

        String c2Name = "Venue";
        assertEquals(c2Name, c2.getCategoryName());

        //changing category name
        c2.setCategoryName("Venu2");

        //updating category
        sDao.updateCategory(c2);

        //asserting that the old category name does not match the current category name after update
        assertThat(c2.getCategoryName(), not(equalTo(c2Name)));
    }

    @Test
    public void removeCategory() {
        //adding categories
        sDao.addNewCategory(c2);
        sDao.addNewCategory(c3);

        //creating category list
        List<Category> cList = sDao.getAllCategories();

        int listSize = cList.size();
        assertEquals(listSize, 3);

        //remove category
        sDao.removeCategory(c2.getCategoryId());

        //clearing out the list
        cList.clear();

        //refilling the list
        cList = sDao.getAllCategories();

        listSize = cList.size();
        assertEquals(listSize, 2);

        Category cFromDb = sDao.getCategoryByName("Venue");
        assertNull(cFromDb);
    }

    @Test
    public void addNewUser_Test() {
        //add users
        sDao.addNewUser(u1);
        sDao.addNewUser(u2);
        sDao.addNewUser(u3);
        sDao.addNewUser(u4);

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
    public void getUserByUserName() {
        //add users
        sDao.addNewUser(u1);
        sDao.addNewUser(u2);
        sDao.addNewUser(u3);
        sDao.addNewUser(u4);

        User fromDb = sDao.getUserByUserName(u1.getUserName());

        //testing individual parts of the user object
        assertEquals(fromDb.getUserName(), u1.getUserName());
        assertEquals(fromDb.getFirstName(), u1.getFirstName());
        assertEquals(fromDb.getLastName(), u1.getLastName());
        assertEquals(fromDb.getProfileId(), u1.getProfileId());
    }

    @Test
    public void getByProfileId_updateProfile_Test() {
        //add users
        sDao.addNewUser(u1);
        sDao.addNewUser(u2);
        sDao.addNewUser(u3);
        sDao.addNewUser(u4);
        
        //getting list of users by profile id
        List<User> uList = sDao.getUsersByProfileId(2);
        
        //testing number returned
        assertEquals(uList.size(), 2);
        
        //resetting a profile id
        u2.setProfileId(3);
        
        //updating the profile of the user
        sDao.updaterUserProfile(u2);
        
        //refilling the list
        uList.clear();
        uList = sDao.getUsersByProfileId(2);
        
        //testing the list size
        assertEquals(uList.size(), 1);
        
        //refilling the list for the updated profile
        uList.clear();
        uList = sDao.getUsersByProfileId(3);
        
        //testing the list size
        assertEquals(uList.size(), 2);
    }
    
    @Test
     public void get_UserById_UpdateUser_Test() {
        //add user
         sDao.addNewUser(u1);
        
        User fromDB = sDao.getUserByUserId(u1.getUserId());
        
        fromDB.setFirstName("Abraham");
        fromDB.setLastName("Lincoln");
        fromDB.setAuthority("ADMIN_USER");
        
        sDao.updateUser(fromDB);
        
        User updateFromDB = sDao.getUserByUserId(u1.getUserId());
        
        assertThat(fromDB, not(equalTo(updateFromDB)));   
    }
     
     @Test
    public void getAllUsers_Test() {
        //add users
        sDao.addNewUser(u1);
        sDao.addNewUser(u2);
        sDao.addNewUser(u3);
        sDao.addNewUser(u4);
        
        //getting list of users
        List<User> uList = sDao.getAllUsers();
        
        //testing list size
        assertEquals(uList.size(), 4);
    }
}
