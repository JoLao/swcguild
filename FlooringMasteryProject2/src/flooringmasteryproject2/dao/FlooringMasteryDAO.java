package flooringmasteryproject2.dao;

import flooringmasteryproject2.domain.Order;
import flooringmasteryproject2.domain.Product;
import flooringmasteryproject2.domain.StateTax;
import flooringmasteryproject2.domain.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryDAO {

    private String mode;
    
    private OrdersDAO   orders     = new OrdersDAO();
    private ProductsDAO products   = new ProductsDAO();
    private StateTaxDAO stateTaxes = new StateTaxDAO();
    private UserDAO     users      = new UserDAO();

    public static final String CONFIG_FILE = "config.txt";
    public static final String DELIMITER      = ",";
    
//Start === User Related Methods =====    
    public User checkIfUserExists(String userName, String password) {
        return users.checkIfUserExists(userName, password);
    }
//End  === User Related Methods =====
    
    public String getMode() {
        return this.mode;
    }

//Start === Order Related Methods =====  
    
    public Order[] getListOfOrdersByDate(String orderDate) {
        return orders.getListOfOrdersByDate(orderDate);
    }
    
    public void addOrder(String orderDate,  String customerName, String stateName, 
                         String productType, double area) {    
        
        double taxRate          = getStateTaxRate(stateName);
        double costPerSqFt      = getProductCostPerSquareFoot(productType);
        double laborCostPerSqFt = getProductLaborCostPerSquareFoot(productType);
        
        orders.addOrder(orderDate, customerName, stateName, productType, area, taxRate, 
                        costPerSqFt, laborCostPerSqFt);
    }
    
    public void removeOrder(String orderDate, int orderNumber) {
        orders.removeOrder(orderDate, orderNumber);
    }
    
    public Order getOrder(String orderDate, int orderNumber) {
        return orders.getOrder(orderDate, orderNumber);
    }
    
    public boolean isOrderListEmpty() {
        return orders.isOrderListEmpty();
    }
    
    public boolean isOrderByDateListEmpty(String orderDate) {
        return orders.isOrderByDateListEmpty(orderDate);
    }
    
    public boolean checkOrderDate(String orderDate) {
        return orders.checkOrderDate(orderDate);
    }
//End   === Order Related Methods =====      
    
    
//Start === State Related Methods =====   
    public void addStateTax(String stateName, double taxRate) {
        stateTaxes.addStateTax(stateName, taxRate);
    }
    
    public void removeStateTax(String stateName) {
        stateTaxes.removeStateTax(stateName);
    }
    public double getStateTaxRate(String stateName) {
        return stateTaxes.getStateTaxRate(stateName);
    }
    
    public StateTax getStateTax(String stateName) {
        return stateTaxes.getStateTax(stateName);
    }
    
    public StateTax[] getAllStateTaxes() {
        return stateTaxes.getAllStateTaxes();
    }
    
    public boolean isStateAvailable(String stateName) {
        return stateTaxes.isStateAvailable(stateName);
    }
//End   === Order Related Methods =====      
    
//Start === Product Related Methods =====   
    public void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot) {  
        products.addProduct(productType, costPerSquareFoot, laborCostPerSquareFoot);
    }
    
    public void removeProduct(String productType) {
        products.removeProduct(productType);
    }
    
    public boolean isProductAvailable(String productType) {
        return products.isProductAvailable(productType);
    }
    
    public Product getProduct(String productType) {
        return products.getProduct(productType);
    }
    
    public double getProductCostPerSquareFoot(String productType) {
        return products.getProductCostPerSquareFoot(productType);
    }
    
    public double getProductLaborCostPerSquareFoot(String productType) {
        return products.getProductLaborCostPerSquareFoot(productType);
    }
    
    public Product[] getAllProducts() {
        return products.getAllProducts();
    }
//End   === Product Related Methods =====              
    
    
//======> Methods for Loading from & Saving to Files <==========    
    public void loadUsers() throws FileNotFoundException {
        users.loadUsers();
    }      

    public void loadConfig() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));

        mode = in.nextLine();
    }    

    public void loadProductMap() throws FileNotFoundException {
        products.loadProductMap();
    }

    public void loadStateTaxMap() throws FileNotFoundException {
        stateTaxes.loadStateTaxMap();
    }
    
    public void loadAllOrderFiles() throws FileNotFoundException {
        orders.loadAllOrderFiles();
    }
    
    public void saveProducts() throws IOException {
        products.saveProducts();
    }
    
    public void saveStateTax() throws IOException {
        stateTaxes.saveStateTax();
    }
    
     public void saveAllOrders() throws IOException {
         orders.saveAllOrders();
     }
}
