/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.test;

import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductItemDao;
import com.swcguild.scarletexpo.dao.interfaces.UserDao;
import com.swcguild.scarletexpo.model.Category;
import com.swcguild.scarletexpo.model.Product;
import com.swcguild.scarletexpo.model.ProductItem;
import com.swcguild.scarletexpo.model.User;
import java.util.ArrayList;
import java.util.List;
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
 * @author apprentice
 */
public class ProductItemJUnitTest {
    
    CategoryDao cdao;
    ProductDao pdao;
    ProductItemDao dao;
    UserDao udao;
    
    Category c1;
    
    Product p1;
    Product p2;
    
    User u1;
    User u2;
    
    ProductItem pi1;
    ProductItem pi2;
    
    public ProductItemJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        cleaner.execute("DELETE FROM authorities");
        cleaner.execute("DELETE FROM users");
        cleaner.execute("DELETE FROM notes");
        cleaner.execute("DELETE FROM product_items");
        cleaner.execute("delete from products;");
        cleaner.execute("delete from categories;");
        

        pdao = ctx.getBean("productDao", ProductDao.class);
        cdao = ctx.getBean("categoryDao", CategoryDao.class);
        dao = ctx.getBean("productItemDao", ProductItemDao.class);
        udao = ctx.getBean("userDao", UserDao.class);

        c1 = new Category();
        c1.setCategoryName("Equipment");
        cdao.addCategory(c1);        

        p1 = new Product();
        p1.setCategoryId(c1.getCategoryId());
        p1.setProductDesc("Basketball for games");
        p1.setActive(true);
        //p1.setProductId(1);
        p1.setProductName("Basketball");
        
        pdao.addProduct(p1);

        p2 = new Product();
        p2.setCategoryId(c1.getCategoryId());
        p2.setProductDesc("Football for games");
        //p2.setProductId(2);
        p2.setProductName("Football");
        
        pdao.addProduct(p2);
        
        pi1 = new ProductItem();
        pi1.setProductItemName("Football-1");
        pi1.setProductId(p1.getProductId());
        pi1.setActive(true);
//        pi1.setCheckedOut(false);
//        pi1.setDamaged(false);
//        pi1.setLost(false);
        
        pi2 = new ProductItem();
        pi2.setProductItemName("Football-2");
        pi2.setProductId(p1.getProductId());
        pi2.setActive(true);
//        pi2.setCheckedOut(false);
//        pi2.setDamaged(false);
//        pi2.setLost(false);
        
        u1 = new User();
        u1.setFirstName("John");
        u1.setLastName("Doe");
        u1.setProfileId(3);
        u1.setUserPass("bubba");
        u1.setUserName("jdoe");
        u1.setAuthority("CUSTOMER_USER");
        
        udao.addUser(u1);
        
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetProductItemTest() {
        dao.addProductItem(pi1);
        dao.addProductItem(pi2);
        
        ProductItem temp = dao.getProductItemById(pi2.getProductItemId());
        pi2.setNoteIds(temp.getNoteIds());
        
        //TESTS GET PITEM BY ID
        temp = dao.getProductItemById(pi1.getProductItemId());
        pi1.setNoteIds(temp.getNoteIds());
        assertEquals(pi1, temp);
        
        //TESTS GET PITEM BY ID WITH INVALID ID - SHOULD RETURN NULL
        ProductItem nullItem = dao.getProductItemById(p2.getProductId());
        assertNull(nullItem);
        
        //TESTS GET PITEM BY PRODUCT ID
        List<ProductItem> temp2 = dao.getProductItemsByProductId(pi1.getProductId());
        List<ProductItem> piList = new ArrayList<>();
        piList.add(pi1);
        piList.add(pi2);
        assertEquals(piList, temp2);
        
        //TEST GET PITEM BY PRODUCT NAME WITH INVALID NAME - SHOULD RETURN AN EMPTY LIST
        temp2.clear();
        temp2 = dao.getProductItemsByProductId(p2.getProductId());
        assertTrue(temp2.isEmpty());
        
    }
    
    @Test
    public void updateProductItemTest() {
        dao.addProductItem(pi2);
        pi2.setProductItemName("TEST");
        pi2.setProductId(p2.getProductId());
        pi2.setLost(true);
        pi2.setDamaged(true);
        pi2.setCheckedOut(true);
        pi2.setActive(true);
        dao.updateProductItem(pi2);
        ProductItem temp3 = dao.getProductItemById(pi2.getProductItemId());
        pi2.setNoteIds(temp3.getNoteIds());
        assertEquals(pi2, temp3);
    }
    
}
