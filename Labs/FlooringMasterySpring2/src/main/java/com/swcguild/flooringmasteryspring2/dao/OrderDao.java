/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Order;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public interface OrderDao {
    String DELIMITER = ",";
    String ORDERLIST_FILE = "allordersfiles.txt";

    void addOrder(String orderDate, String customerName, String stateName, String productType, double area, double taxRate, double costPerSqFt, double laborCostPerSqFt);

    Order[] getListOfOrdersByDate(String orderDate);

    Order getOrder(String orderDate, int orderNumber);

    boolean isOrderByDateListEmpty(String orderDate);

    boolean isOrderListEmpty();

    String loadAllOrderFiles() throws FileNotFoundException;

//    boolean loadOrdersPerFile(String orderFileName) throws FileNotFoundException;

    void removeOrder(String orderDate, int orderNumber);

    void saveAllOrders() throws IOException;

//    boolean savePerFile(String orderFileName) throws IOException;
    
}
