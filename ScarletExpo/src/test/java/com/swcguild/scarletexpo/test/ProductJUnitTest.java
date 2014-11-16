package com.swcguild.scarletexpo.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductDao;
import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.model.Category;
import com.swcguild.scarletexpo.model.Product;
import com.swcguild.scarletexpo.model.ProductItem;
import java.util.ArrayList;
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
public class ProductJUnitTest {

    CategoryDao cdao;
    ProductDao dao;
    
    Product p1;
    Product p2;
    
    Category c1;
    Category c2;
    

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("DELETE FROM notes");
        cleaner.execute("DELETE FROM product_items");
        cleaner.execute("delete from products;");
        cleaner.execute("delete from categories;");

        dao = ctx.getBean("productDao", ProductDao.class);
        cdao = ctx.getBean("categoryDao", CategoryDao.class);
        
        

        c1 = new Category();
        c1.setCategoryName("Equipment");
        cdao.addCategory(c1);
        
        c2 = new Category();
        c2.setCategoryName("TEMP");
        cdao.addCategory(c2);
        
        

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
        //p2.setProductId(2);
        p2.setProductName("Football");
        
        //dao.addProduct(p2);

        
    }
    
    @Test
    public void addGetProductTest() {
        dao.addProduct(p1);
        //TESTS GET PRODUCT BY PRODUCTID
        assertEquals(p1, dao.getActiveProductById(p1.getProductId()));
        //TESTS GET PRODUCT BY PRODUCTNAME
        assertEquals(p1, dao.getProductByName(p1.getProductName()));
        //TESTS GET PRODUCT BY INVALID PRODUCTID/NAME
        assertNull(dao.getActiveProductById(p2.getProductId()));
        assertNull(dao.getProductByName(p2.getProductName()));
    }
    
    @Test
    public void updateProductTest() {
        dao.addProduct(p1);
        p1.setProductName("Test");
        p1.setProductDesc("Test");
        dao.updateProduct(p1);
        assertEquals(p1, dao.getActiveProductById(p1.getProductId()));
    }
    
    @Test
    public void deleteProductTest() {
        dao.addProduct(p1);
        dao.deleteProduct(p1.getProductId());
        Product temp = dao.getInactiveProductById(p1.getProductId());
        //need to clear up isActive
        assertTrue(p1.getActive());
        assertFalse(temp.getActive() == p1.getActive());
    }
    
    @Test
    public void getProductsTest() {
        dao.addProduct(p1);
        dao.addProduct(p2);
        List<Product> testList = new ArrayList<>();
        
        testList.add(p1);
        testList.add(p2);
        
        List<Product> catId = dao.getProductsByCategoryId(p1.getCategoryId());
        List<Product> all = dao.getAllProducts();
        
        assertEquals(testList, catId);
        assertEquals(testList, all);
        
        //CATEGORY C2 HAS NO PRODUCTS, GET PRODCTS BY C2 ID SHOULD RETURN AN EMPTY LIST
        catId.clear();
        catId = dao.getProductsByCategoryId(c2.getCategoryId());
        assertTrue(catId.isEmpty());
    }

    
 
}
