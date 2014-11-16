package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Order;
import com.swcguild.flooringmasteryspring2.domain.Product;
import com.swcguild.flooringmasteryspring2.domain.StateTax;
import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer  {

    private String mode;
    
    private OrderDao   orders;
    private ProductDao  products;
    private StateTaxDao stateTaxes;
    private UserDao     users;
    

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void setOrders(OrderDao orders) {
        this.orders = orders;
    }

    @Override
    public void setProducts(ProductDao products) {
        this.products = products;
    }

    @Override
    public void setStateTaxes(StateTaxDao stateTaxes) {
        this.stateTaxes = stateTaxes;
    }

    @Override
    public void setUsers(UserDao users) {
        this.users = users;
    }

    
//Start === User Related Methods =====    
    @Override
    public User checkIfUserExists(String userName, String password) {
        return users.checkIfUserExists(userName, password);
    }
    
    @Override
    public HashMap<String, User> getAllUsers() {
        return users.listAllUsers();
    }
//End  === User Related Methods =====
    
    @Override
    public String getMode() {
        return this.mode;
    }

//Start === Order Related Methods =====  
    
    @Override
    public Order[] getListOfOrdersByDate(String orderDate) {
        return orders.getListOfOrdersByDate(orderDate);
    }
    
    @Override
    public void addOrder(String orderDate,  String customerName, String stateName, 
                         String productType, double area) {    
        
        double taxRate          = getStateTaxRate(stateName);
        double costPerSqFt      = getProductCostPerSquareFoot(productType);
        double laborCostPerSqFt = getProductLaborCostPerSquareFoot(productType);
        
        orders.addOrder(orderDate, customerName, stateName, productType, area, taxRate, 
                        costPerSqFt, laborCostPerSqFt);
    }
    
    @Override
    public void removeOrder(String orderDate, int orderNumber) {
        orders.removeOrder(orderDate, orderNumber);
    }
    
    @Override
    public Order getOrder(String orderDate, int orderNumber) {
        return orders.getOrder(orderDate, orderNumber);
    }
    
    @Override
    public boolean isOrderListEmpty() {
        return orders.isOrderListEmpty();
    }
    
    @Override
    public boolean isOrderByDateListEmpty(String orderDate) {
        return orders.isOrderByDateListEmpty(orderDate);
    }
    
//End   === Order Related Methods =====      
    
    
//Start === State Related Methods =====   
    @Override
    public void addStateTax(String stateName, double taxRate) {
        stateTaxes.addStateTax(stateName, taxRate);
    }
    
    @Override
    public void removeStateTax(String stateName) {
        stateTaxes.removeStateTax(stateName);
    }
    @Override
    public double getStateTaxRate(String stateName) {
        return stateTaxes.getStateTaxRate(stateName);
    }
    
    @Override
    public StateTax getStateTax(String stateName) {
        return stateTaxes.getStateTax(stateName);
    }
    
    @Override
    public StateTax[] getAllStateTaxes() {
        return stateTaxes.getAllStateTaxes();
    }
    
    @Override
    public boolean isStateAvailable(String stateName) {
        return stateTaxes.isStateAvailable(stateName);
    }
//End   === Order Related Methods =====      
    
//Start === Product Related Methods =====   
    @Override
    public void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot) {  
        products.addProduct(productType, costPerSquareFoot, laborCostPerSquareFoot);
    }
    
    @Override
    public void removeProduct(String productType) {
        products.removeProduct(productType);
    }
    
    @Override
    public boolean isProductAvailable(String productType) {
        return products.isProductAvailable(productType);
    }
    
    @Override
    public Product getProduct(String productType) {
        return products.getProduct(productType);
    }
    
    @Override
    public double getProductCostPerSquareFoot(String productType) {
        return products.getProductCostPerSquareFoot(productType);
    }
    
    @Override
    public double getProductLaborCostPerSquareFoot(String productType) {
        return products.getProductLaborCostPerSquareFoot(productType);
    }
    
    @Override
    public Product[] getAllProducts() {
        return products.getAllProducts();
    }
//End   === Product Related Methods =====              
    
    
//======> Methods for Loading from & Saving to Files <==========    
    @Override
    public void loadUsers() throws FileNotFoundException {
        users.loadUsers();
    }      

    @Override
    public void loadConfig() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));

        mode = in.nextLine();
    }    

    @Override
    public void loadProductMap() throws FileNotFoundException {
        products.loadProductMap();
    }

    @Override
    public void loadStateTaxMap() throws FileNotFoundException {
        stateTaxes.loadStateTaxMap();
    }
    
    @Override
    public void loadAllOrderFiles() throws FileNotFoundException {
        orders.loadAllOrderFiles();
    }
    
    @Override
    public void saveProducts() throws IOException {
        products.saveProducts();
    }
    
    @Override
    public void saveStateTax() throws IOException {
        stateTaxes.saveStateTax();
    }
    
    @Override
     public void saveAllOrders() throws IOException {
         orders.saveAllOrders();
     }
}
