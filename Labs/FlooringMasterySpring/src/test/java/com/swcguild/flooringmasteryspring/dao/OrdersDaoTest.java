/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring.dao;

import com.swcguild.flooringmasteryspring.domain.Order;
import com.swcguild.flooringmasteryspring.domain.Product;
import com.swcguild.flooringmasteryspring.domain.StateTax;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class OrdersDaoTest {

    public OrdersDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void FlooringMasteryProject() throws FileNotFoundException {                                     
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersDaoImpl daoTest = (OrdersDaoImpl) ctx.getBean("ordersDaoImpl");
//        OrdersDaoImpl daoTest = new OrdersDaoImpl();
//load productMap
        daoTest.loadProductMap();
//load stateMap
        daoTest.loadStateTaxMap();

        Product[] pdtFromMap = daoTest.getAllProducts();
        Arrays.sort(pdtFromMap);

        Product[] pdt = new Product[4];
        pdt[0] = new Product("CARPET", 2.25, 2.10);
        pdt[1] = new Product("LAMINATE", 1.75, 2.10);
        pdt[2] = new Product("TILE", 3.50, 4.15);
        pdt[3] = new Product("WOOD", 5.15, 4.75);
        Arrays.sort(pdt);

        boolean pdtTest = Arrays.equals(pdtFromMap, pdt);
        assertTrue(pdtTest);

        StateTax[] stateTaxFromMap = daoTest.getAllStateTaxes();
        Arrays.sort(stateTaxFromMap);

        StateTax[] stTax = new StateTax[4];
        stTax[0] = new StateTax("OH", 6.25);
        stTax[1] = new StateTax("PA", 6.75);
        stTax[2] = new StateTax("MI", 5.75);
        stTax[3] = new StateTax("IN", 6.00);
        Arrays.sort(stTax);

        boolean stateTaxTest = Arrays.equals(stateTaxFromMap, stTax);
        assertTrue(stateTaxTest);

        //addOrder, getOrder
        Order orderDTOTest = new Order("Nat", "OH", "WOOD", 200);
        Order orderDTOTest2 = new Order("Nat", "OH", "WOOD", 200);
        
        orderDTOTest2.setTaxRate(6.25);
        orderDTOTest2.setCostPerSquareFoot(5.15);
        orderDTOTest2.setLaborCostPerSquareFoot(4.75);
        orderDTOTest2.calculate();

//        Order orderTest2 = daoTest.getOrder("09162014", 1);

        daoTest.addOrder("09162014", orderDTOTest);
        boolean result = daoTest.getOrder("09162014", 1).equals(orderDTOTest);
        assertTrue(result);

//getLastOrderNumber
        int number = daoTest.getLastOrderNumber();
        assertEquals(number, 1);
//isProductAvailable
        boolean productTest = daoTest.isProductAvailable("Wood");
        assertTrue(productTest);
//isStateAvailable
        boolean stateTest = daoTest.isStateAvailable("OH");
        assertTrue(stateTest);

        daoTest.removeOrder("09162014", 1);
        Order orderTest3 = daoTest.getOrder("09162014", 1);
        assertEquals(orderTest3, null);

        //daoTest.loadAllOrderFiles();
        OrdersDaoImpl daoTest2 = new OrdersDaoImpl();
        daoTest2.loadAllOrderFiles();

        Order orderDTOTest3 = new Order("Ann", "PA", "Tile", 150);
        orderDTOTest3.setTaxRate(6.75);
        orderDTOTest3.setCostPerSquareFoot(3.50);
        orderDTOTest3.setLaborCostPerSquareFoot(4.15);
        orderDTOTest3.calculate();

        Order orderDTOTest4 = new Order("Bill", "MI", "Laminate", 120);
        orderDTOTest4.setTaxRate(5.75);
        orderDTOTest4.setCostPerSquareFoot(1.75);
        orderDTOTest4.setLaborCostPerSquareFoot(2.10);
        orderDTOTest4.calculate();

        daoTest.addOrder("09172014", orderDTOTest3);
        daoTest.addOrder("09172014", orderDTOTest4);

        try {
            daoTest.saveAllOrders();
        } catch (IOException e) {

        }

        OrdersDaoImpl daoOrder = new OrdersDaoImpl();
        daoOrder.loadAllOrderFiles();

        boolean result1 = daoTest.getOrder("09172014", 1).equals(daoOrder.getOrder("09172014", 1));
        assertTrue(result1);

        result1 = daoTest.getOrder("09172014", 2).equals(daoOrder.getOrder("09172014", 2));
        assertTrue(result1);
    }
}
