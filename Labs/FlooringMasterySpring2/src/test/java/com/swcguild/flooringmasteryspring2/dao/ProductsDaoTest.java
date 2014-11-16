/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Product;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
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
public class ProductsDaoTest {

    ApplicationContext ctx;
    ProductDao pdtDao;

    public ProductsDaoTest() {
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
        pdtDao = (ProductDao) ctx.getBean("productDao");
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
    public void productsDaoTest() {
        //load productMap
        try {
            pdtDao.loadProductMap();
        } catch (FileNotFoundException fnf) {
        }

        Product[] pdtFromMap = pdtDao.getAllProducts();
        Arrays.sort(pdtFromMap);

        Product[] pdt = new Product[4];
        pdt[0] = new Product("CARPET", 2.25, 2.10);
        pdt[1] = new Product("LAMINATE", 1.75, 2.10);
        pdt[2] = new Product("TILE", 3.50, 4.15);
        pdt[3] = new Product("WOOD", 5.15, 4.75);
        Arrays.sort(pdt);

        boolean pdtTest = Arrays.equals(pdtFromMap, pdt);

        assertTrue(pdtTest);

        //isProductAvailable        
        assertTrue(pdtDao.isProductAvailable("Wood"));

        Product addPdt = new Product("MARBLE", 8.00, 9.00);
        pdtDao.addProduct("Marble", 8.0, 9.0);
        Product getPdt = pdtDao.getProduct("Marble");
        assertTrue(addPdt.equals(getPdt));
        BigDecimal cost = new BigDecimal(pdtDao.getProductCostPerSquareFoot("Marble")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal myCost = new BigDecimal(8.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(cost, myCost);

        BigDecimal laborCost = new BigDecimal(pdtDao.getProductLaborCostPerSquareFoot("Marble")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal mylaborCost = new BigDecimal(9.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(laborCost, mylaborCost);

        pdtDao.removeProduct("Marble");
        getPdt = pdtDao.getProduct("Marble");
        assertEquals(getPdt, null);

        pdtDao.addProduct("Marble", 8.0, 9.0);

        try {
            pdtDao.saveProducts();

        } catch (IOException e) {

        }

        ProductDao pdtDao2 = (ProductDao) ctx.getBean("productDao");
        try {
            pdtDao2.loadProductMap();
        } catch (FileNotFoundException fnf) {
        }
        
        pdtFromMap = pdtDao2.getAllProducts();
        Arrays.sort(pdtFromMap);
        pdt = new Product[5];
        pdt[0] = new Product("CARPET", 2.25, 2.10);
        pdt[1] = new Product("LAMINATE", 1.75, 2.10);
        pdt[2] = new Product("TILE", 3.50, 4.15);
        pdt[3] = new Product("WOOD", 5.15, 4.75);
        pdt[4] = new Product("MARBLE", 8.0, 9.0);

        Arrays.sort(pdt);
        pdtTest = Arrays.equals(pdtFromMap, pdt);
        assertTrue(pdtTest);

        pdtDao.removeProduct("Marble");        
        try {            
            pdtDao.saveProducts();            
        } catch (IOException e) {

        }
    }
}
