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
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryServiceLayer {
    String CONFIG_FILE = "config.txt";
    String DELIMITER = ",";

    void addOrder(String orderDate, String customerName, String stateName, String productType, double area);

    void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot);

    void addStateTax(String stateName, double taxRate);

    User checkIfUserExists(String userName, String password);

    Product[] getAllProducts();    

    StateTax[] getAllStateTaxes();
    
    HashMap<String, User> getAllUsers();
    
    Order[] getListOfOrdersByDate(String orderDate);

    String getMode();

    Order getOrder(String orderDate, int orderNumber);

    Product getProduct(String productType);

    double getProductCostPerSquareFoot(String productType);

    double getProductLaborCostPerSquareFoot(String productType);

    StateTax getStateTax(String stateName);

    double getStateTaxRate(String stateName);

    boolean isOrderByDateListEmpty(String orderDate);

    boolean isOrderListEmpty();

    boolean isProductAvailable(String productType);

    boolean isStateAvailable(String stateName);    

    void loadAllOrderFiles() throws FileNotFoundException;

    void loadConfig() throws FileNotFoundException;

    void loadProductMap() throws FileNotFoundException;

    void loadStateTaxMap() throws FileNotFoundException;
    
    void loadUsers() throws FileNotFoundException;

    void removeOrder(String orderDate, int orderNumber);

    void removeProduct(String productType);

    void removeStateTax(String stateName);

    void saveAllOrders() throws IOException;

    void saveProducts() throws IOException;

    void saveStateTax() throws IOException;

    void setMode(String mode);

    void setOrders(OrderDao orders);

    void setProducts(ProductDao products);

    void setStateTaxes(StateTaxDao stateTaxes);

    void setUsers(UserDao users);
    
}
