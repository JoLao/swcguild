/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productinventory.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import productinventory.domain.Pants;
import productinventory.domain.Product;
import productinventory.domain.Shirt;


//Create a program that manages multiple products such as shirts, pants, coats and other 
//products in inventory. Allow the user to add products to inventory, add/remove stock to an 
//existing product, calculate the total value of a product and the total value of the entire inventory. 
//When inventory levels for a product fall below a certain number (this should be configurable), the 
//system should warn the user that they need to restock. 

public class Inventory {
    HashMap<String, Product> inventoryMap = new HashMap<>();

    public static final String INVENTORY_FILE = "productinventory.txt";
    public static final String DELIMITER = "::";
    
    public double calculateTotalValueOfAProduct(String name) {
        double value;
        
        Product product = inventoryMap.get(name);
        
        return product.getPrice() * product.getInventory();
        
    }
    
    public void addProduct(Product product) {
        inventoryMap.put(product.getName(), product);
    }
    
    public Product removeProduct(String name) {
        Product pdt = inventoryMap.remove(name);
        return pdt;
    }
    
    public double calculateTotalValueOfInventory() {
        double total = 0;
        
        Collection<Product> values = inventoryMap.values();
        Iterator<Product>   iter   = values.iterator();
        
        while (iter.hasNext()) {
            total += ( iter.next().getPrice() * iter.next().getInventory() );
        }
        return total;
    }
    
    public boolean isProductInStock(String name) {
        
        return inventoryMap.containsKey(name);
        
    }
    public boolean isStockLow(Product product) {
        if (product.getInventory() < product.getThresholdCount()) {
            return true;
        }
        return false;
    }
    
    //File Layout
    //For Shirt:
    //name::price::inventory::threshold count::sleeves type::size::forWhom
    //Shirt(Shirt(String name, double price, int inventory, int thresholdCount, 
    //            String sleeveType, String size, String forWhom)
    //For Pants:
    //name::price::inventory::threshold count::type of pants::size::inseams:forWhom
    public void loadInventory(String inputFile) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        
        String   currentLine   = "";
        String[] currentTokens = {};

        Shirt    s;
        Pants    p;
        while (in.hasNext()) {
            currentTokens = currentLine.split(DELIMITER);
            switch (currentTokens[0]) {
                case "Shirt":
                    s = new Shirt(currentTokens[0], Double.parseDouble(currentTokens[1]), 
                              Integer.parseInt(currentTokens[2]), Integer.parseInt(currentTokens[3]),
                              currentTokens[4], currentTokens[5], currentTokens[6]);
                            
                    inventoryMap.put(currentTokens[0], s);
                    break;
                case "Pants":
                    p = new Pants(currentTokens[0], Double.parseDouble(currentTokens[1]), 
                              Integer.parseInt(currentTokens[2]), Integer.parseInt(currentTokens[3]),
                              currentTokens[4], Integer.parseInt(currentTokens[5]), 
                              Integer.parseInt(currentTokens[6]), currentTokens[7]);
                    inventoryMap.put(currentTokens[0], p);
            }
                                      
            
        }
        in.close();
    }
    
    public void saveInventory(String outputFile) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        
        Collection<Product> values = inventoryMap.values();
        Iterator<Product>   iter   = values.iterator();
        
        Shirt    s;
        Pants    p;
        while (iter.hasNext()) {
            
               
        }
    }
}
