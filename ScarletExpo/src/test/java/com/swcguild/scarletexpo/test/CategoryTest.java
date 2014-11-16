package com.swcguild.scarletexpo.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.model.Category;
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
public class CategoryTest {

    CategoryDao cdao;
    Category c1;
    Category c2;

    public CategoryTest() {
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
        cleaner.execute("DELETE FROM notes");
        cleaner.execute("DELETE FROM product_items");
        cleaner.execute("delete from products;");
        cleaner.execute("delete from categories;");

        cdao = ctx.getBean("categoryDao", CategoryDao.class);

        c1 = new Category();

        c1.setCategoryName("Equipment");

        c2 = new Category();
        c2.setCategoryName("Venue");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addCategory_Test() {
        //retriving the category id prior to adding the category
        int num = c1.getCategoryId();

        //testing to ensure that the id is equal to zero
        assertEquals(num, 0);

        //adding the category to the database
        cdao.addCategory(c1);

        //testing to ensure that the id value is no longer zero
        assertThat(c1.getCategoryId(), not(equalTo(0)));

    }

    @Test
    public void getCategoryById_Test() {
        //adding category to db
        cdao.addCategory(c1);

        //retrieving category from db
        Category fromDb = cdao.getCategoryById(c1.getCategoryId());

        //testing equality
        boolean result = fromDb.equals(c1);
        assertTrue(result);
    }

    @Test
    public void getCategoryByName_Test() {
        //add category to db
        cdao.addCategory(c1);
        cdao.addCategory(c2);

        String categoryName = "Venue";

        //retrieving category from db
        Category fromDb = cdao.getCategoryByName(categoryName);

        //testing equality
        boolean result = fromDb.equals(c2);
        assertTrue(result);

        //testing for a value not present
        categoryName = "Trainers";

        //with no category called 'trainers' 
        fromDb = cdao.getCategoryByName(categoryName);
        assertNull(fromDb);
    }

    @Test
    public void getAllCategory_removeCategory_Test() {
        //add category to db
        cdao.addCategory(c1);
        cdao.addCategory(c2);

        //obtain list of all categories
        List<Category> cList = cdao.getAllCategories();
        assertThat(cList.size(), equalTo(2));

        //remove category
        cdao.removeCategory(c1.getCategoryId());

        //obtain new list of all categories
        cList = cdao.getAllCategories();
        assertThat(cList.size(), equalTo(1));

    }

    @Test
    public void updateCategory_Test() {
        //add category to db
        cdao.addCategory(c1);
        cdao.addCategory(c2);
        
        //getting a category from database
        Category fromDb = cdao.getCategoryByName("Equipment");
        
        //testing equality
        boolean result = fromDb.equals(c1);
        assertTrue(result);
        
        //update category
        c1.setCategoryName("Game Equipment");
        cdao.updateCategory(c1);
        
        //attempt to grab non-existant category from database
        fromDb = cdao.getCategoryByName("Equipment");
        assertNull(fromDb);
        
        //attempt to grab updated category from database
        fromDb = cdao.getCategoryByName("Game Equipment");
        result = fromDb.equals(c1);
        assertTrue(result);
    }
}
