/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring.dao;

import com.swcguild.flooringmasteryspring.domain.Order;
import com.swcguild.flooringmasteryspring.domain.Product;
import com.swcguild.flooringmasteryspring.domain.StateTax;
import com.swcguild.flooringmasteryspring.domain.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public interface OrdersDao {
        public static final String USER_FILE = "users.txt";
    public static final String CONFIG_FILE = "config.txt";
    public static final String ORDERLIST_FILE = "allordersfiles.txt";
    public static final String PRODUCT_FILE = "products.txt";
    public static final String STATE_TAX_FILE = "taxes.txt";
    public static final String DELIMITER = ",";

    public Order[] getListOfOrdersByDate(String orderDate);

    public void addOrder(String orderDate, Order order);

    public void addOrderFromFile(String orderDate, Order order);
    
    public void removeOrder(String orderDate, int orderNumber);

    public boolean isOrderFileInArrayList(String fileName);

    public boolean isOrderListEmpty();

    public boolean isOrderByDateListEmpty(String orderDate);

    public boolean checkOrderDate(String orderDate);
    
    public Order getOrder(String orderDate, int orderNumber);

    public int getLastOrderNumber();

    public boolean isProductAvailable(String productType);

    public boolean isStateAvailable(String state);

    public void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot);

    public Product getProduct(String productType);

    public double getProductCostPerSquareFoot(String productType);

    public double getProductLaborCostPerSquareFoot(String productType);

    public void addStateTax(String state, double taxRate);

    public StateTax getStateTax(String stateName);

    public double getStateTaxRate(String stateName);

    public void removeProduct(String productType);

    public void removeStateTax(String state);

    public User checkIfUserExists(String userName, String password);

    public String getMode();

    public void loadConfig() throws FileNotFoundException;

    public void loadUsers() throws FileNotFoundException;

    public void loadProductMap() throws FileNotFoundException;
    
    public Product[] getAllProducts();
    
    public void saveProducts() throws IOException;

    public void loadStateTaxMap() throws FileNotFoundException;

    public void saveStateTax() throws IOException;

    public StateTax[] getAllStateTaxes();
    
    public String loadAllOrderFiles() throws FileNotFoundException;

    public boolean loadOrdersPerFile(String orderFileName) throws FileNotFoundException;

    public void saveAllOrders() throws IOException;
    
    public boolean savePerFile(String orderFileName) throws IOException;

    public void deleteEmptyOrderFile(String fileName);
}
