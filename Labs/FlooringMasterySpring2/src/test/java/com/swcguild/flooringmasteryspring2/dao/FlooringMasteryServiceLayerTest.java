/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Order;
import com.swcguild.flooringmasteryspring2.domain.Product;
import com.swcguild.flooringmasteryspring2.domain.StateTax;
import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
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
public class FlooringMasteryServiceLayerTest {

    //FlooringMasteryDaoImpl daoTest = new FlooringMasteryDaoImpl();
    ApplicationContext ctx;
    FlooringMasteryServiceLayer svcLayer;

    public FlooringMasteryServiceLayerTest() {
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
        svcLayer = (FlooringMasteryServiceLayerImpl) ctx.getBean("flooringMasteryServiceLayer");

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

        svcLayer.setMode("test");
        boolean result = svcLayer.getMode().equalsIgnoreCase("test");
        assertTrue(result);

//load config
        svcLayer.loadConfig();
//load productMap
        svcLayer.loadProductMap();
//load stateMap
        svcLayer.loadStateTaxMap();
//load users file
        svcLayer.loadUsers();

        User user = svcLayer.checkIfUserExists("jolao", "hello");
        User myUser = new User("jolao", "Jo", "hello", "manager", 10);
        assertTrue(user.equals(myUser));

        User user1 = svcLayer.checkIfUserExists("samkeen", "world");
        User myUser1 = new User("samkeen", "Sam", "world", "employee", 05);
        assertTrue(user1.equals(myUser1));

        assertTrue(svcLayer.isOrderListEmpty());

        result = svcLayer.getMode().equalsIgnoreCase("prod");
        assertTrue(result);

        Product[] pdtFromMap = svcLayer.getAllProducts();
        Arrays.sort(pdtFromMap);

        Product[] pdt = new Product[4];
        pdt[0] = new Product("CARPET", 2.25, 2.10);
        pdt[1] = new Product("LAMINATE", 1.75, 2.10);
        pdt[2] = new Product("TILE", 3.50, 4.15);
        pdt[3] = new Product("WOOD", 5.15, 4.75);
        Arrays.sort(pdt);

        boolean pdtTest = Arrays.equals(pdtFromMap, pdt);
        
        assertTrue(pdtTest);

        StateTax[] stateTaxFromMap = svcLayer.getAllStateTaxes();
        Arrays.sort(stateTaxFromMap);

        StateTax[] stTax = new StateTax[4];
        stTax[0] = new StateTax("OH", 6.25);
        stTax[1] = new StateTax("PA", 6.75);
        stTax[2] = new StateTax("MI", 5.75);
        stTax[3] = new StateTax("IN", 6.00);
        Arrays.sort(stTax);

        boolean stateTaxTest = Arrays.equals(stateTaxFromMap, stTax);
        assertTrue(stateTaxTest);

//isProductAvailable        
        assertTrue(svcLayer.isProductAvailable("Wood"));
//isStateAvailable        
        assertTrue(svcLayer.isStateAvailable("OH"));

        Product addPdt = new Product("MARBLE", 8.00, 9.00);
        svcLayer.addProduct("Marble", 8.0, 9.0);
        Product getPdt = svcLayer.getProduct("Marble");
        assertTrue(addPdt.equals(getPdt));
        BigDecimal cost = new BigDecimal(svcLayer.getProductCostPerSquareFoot("Marble")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal myCost = new BigDecimal(8.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(cost, myCost);

        BigDecimal laborCost = new BigDecimal(svcLayer.getProductLaborCostPerSquareFoot("Marble")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal mylaborCost = new BigDecimal(9.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(laborCost, mylaborCost);

        svcLayer.removeProduct("Marble");
        getPdt = svcLayer.getProduct("Marble");
        assertEquals(getPdt, null);

        StateTax addState = new StateTax("NJ", 7.00);
        svcLayer.addStateTax("NJ", 7.00);
        StateTax getState = svcLayer.getStateTax("NJ");
        assertTrue(addState.equals(getState));

        BigDecimal taxRate = new BigDecimal(svcLayer.getStateTaxRate("NJ")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal myTaxRate = new BigDecimal(7.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(taxRate, myTaxRate);

        svcLayer.removeStateTax("NJ");
        getState = svcLayer.getStateTax("NJ");
        assertEquals(getState, null);

        //addOrder, getOrder
        Order orderDTOTest = new Order("Nat", "OH", "WOOD", 200);

        orderDTOTest.setOrderNumber(1);
        orderDTOTest.setTaxRate(6.25);
        orderDTOTest.setCostPerSquareFoot(5.15);
        orderDTOTest.setLaborCostPerSquareFoot(4.75);
        orderDTOTest.calculate();

        //addOrder(String orderDate,  String customerName, String stateName, 
        //                 String productType, double area)
        svcLayer.addOrder("09162014", "Nat", "OH", "WOOD", 200);
        Order orderTest2 = svcLayer.getOrder("09162014", 1);
        result = orderTest2.equals(orderDTOTest);
        assertTrue(result);

        assertFalse(svcLayer.isOrderListEmpty());
        assertTrue(svcLayer.isOrderByDateListEmpty("09012014"));
        assertFalse(svcLayer.isOrderByDateListEmpty("09162014"));

        svcLayer.removeOrder("09162014", 1);
        Order orderTest3 = svcLayer.getOrder("09162014", 1);
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

        svcLayer.loadAllOrderFiles();
        Order[] order2 = svcLayer.getListOfOrdersByDate("09172014");
        assertTrue(order2[0].equals(orderDTOTest3));
        assertTrue(order2[1].equals(orderDTOTest4));

//        svcLayer.addOrder("09172014", "Ann", "PA", "Tile", 150);
//        svcLayer.addOrder("09172014", "Bill", "MI", "Laminate", 120);
        svcLayer.addProduct("Marble", 8.0, 9.0);        
        svcLayer.addStateTax("NJ", 7.00);
        
        try {
            svcLayer.saveAllOrders();
            svcLayer.saveProducts();
            svcLayer.saveStateTax();
        } catch (IOException e) {

        }

        FlooringMasteryServiceLayer svcLayer2 = (FlooringMasteryServiceLayerImpl) ctx.getBean("flooringMasteryServiceLayer");
        svcLayer2.loadAllOrderFiles();
        svcLayer2.loadProductMap();

        boolean result1 = svcLayer.getOrder("09172014", 1).equals(svcLayer2.getOrder("09172014", 1));
        assertTrue(result1);

        result1 = svcLayer.getOrder("09172014", 2).equals(svcLayer2.getOrder("09172014", 2));
        assertTrue(result1);

        pdtFromMap = svcLayer2.getAllProducts();
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

        
        stateTaxFromMap = svcLayer.getAllStateTaxes();
        Arrays.sort(stateTaxFromMap);
        stTax = new StateTax[5];
        stTax[0] = new StateTax("OH", 6.25);
        stTax[1] = new StateTax("PA", 6.75);
        stTax[2] = new StateTax("MI", 5.75);
        stTax[3] = new StateTax("IN", 6.00);
        stTax[4] = new StateTax("NJ", 7.00);
        Arrays.sort(stTax);

        stateTaxTest = Arrays.equals(stateTaxFromMap, stTax);
        assertTrue(stateTaxTest);
        
        svcLayer.removeProduct("Marble");
        svcLayer.removeStateTax("NJ");
        try {            
            svcLayer.saveProducts();
            svcLayer.saveStateTax();
        } catch (IOException e) {

        }
    }

}
