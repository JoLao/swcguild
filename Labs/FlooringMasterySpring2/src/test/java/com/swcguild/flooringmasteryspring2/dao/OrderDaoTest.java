/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
public class OrderDaoTest {

    ApplicationContext ctx;
    OrderDao orderDao;

    public OrderDaoTest() {
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
        orderDao = (OrderDao) ctx.getBean("orderDao");
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
    public void orderDaoTest() {
        //addOrder, getOrder
        Order orderDTOTest = new Order("Nat", "OH", "WOOD", 200);

        orderDTOTest.setOrderNumber(1);
        orderDTOTest.setTaxRate(6.25);
        orderDTOTest.setCostPerSquareFoot(5.15);
        orderDTOTest.setLaborCostPerSquareFoot(4.75);
        orderDTOTest.calculate();

//        addOrder(String orderDate, String customerName, String stateName, String productType, double area, 
//                double taxRate, double costPerSqFt, double laborCostPerSqFt);
        orderDao.addOrder("09162014", "Nat", "OH", "WOOD", 200, 6.25, 5.15, 4.75);
        Order orderTest2 = orderDao.getOrder("09162014", 1);
        boolean result = orderTest2.equals(orderDTOTest);
        assertTrue(result);

        assertFalse(orderDao.isOrderListEmpty());
        assertTrue(orderDao.isOrderByDateListEmpty("09012014"));
        assertFalse(orderDao.isOrderByDateListEmpty("09162014"));

        orderDao.removeOrder("09162014", 1);
        Order orderTest3 = orderDao.getOrder("09162014", 1);
        assertEquals(orderTest3, null);

//1,Ann,PA,6.75,TILE,150.0,3.5,4.15,525.0,622.5,77.46,1224.96
//2,Bill,MI,5.75,LAMINATE,120.0,1.75,2.1,210.0,252.0,26.57,488.57
        Order orderDTOTest3 = new Order("Ann", "PA", "Tile", 150);
        orderDTOTest3.setOrderNumber(1);
        orderDTOTest3.setTaxRate(6.75);
        orderDTOTest3.setCostPerSquareFoot(3.50);
        orderDTOTest3.setLaborCostPerSquareFoot(4.15);
        orderDTOTest3.calculate();

        Order orderDTOTest4 = new Order("Bill", "MI", "Laminate", 120);
        orderDTOTest4.setOrderNumber(2);
        orderDTOTest4.setTaxRate(5.75);
        orderDTOTest4.setCostPerSquareFoot(1.75);
        orderDTOTest4.setLaborCostPerSquareFoot(2.10);
        orderDTOTest4.calculate();

        try {
            orderDao.loadAllOrderFiles();
        } catch (FileNotFoundException fnf) {
        }

        Order[] order2 = orderDao.getListOfOrdersByDate("09172014");
        assertTrue(order2[0].equals(orderDTOTest3));
        assertTrue(order2[1].equals(orderDTOTest4));
        try {
            orderDao.saveAllOrders();

        } catch (IOException e) {

        }

        OrderDao orderDao2 = (OrderDao) ctx.getBean("orderDao");
        try {
            orderDao2.loadAllOrderFiles();
        } catch (FileNotFoundException fnf) {
        }

        boolean result1 = orderDao.getOrder("09172014", 1).equals(orderDao2.getOrder("09172014", 1));
        assertTrue(result1);

        result1 = orderDao.getOrder("09172014", 2).equals(orderDao2.getOrder("09172014", 2));
        assertTrue(result1);
    }
}
