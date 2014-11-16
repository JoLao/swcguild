
package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ProductDaoImpl implements ProductDao {


    private HashMap<String,  Product>  productMap  = new HashMap<>();



    @Override
    public Product[] getAllProducts() {
        Product[] p = productMap.values().toArray(new Product[0]);
        Arrays.sort(p);
        return p;
    }
    
    @Override
    public boolean isProductAvailable(String productType) {

        return productMap.containsKey(productType.toUpperCase());
    }
    
    @Override
    public void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot) {      
        productMap.put(productType.toUpperCase(), 
                new Product(productType.toUpperCase(), costPerSquareFoot, laborCostPerSquareFoot));
    }
    
    @Override
    public Product getProduct(String productType) {
        return productMap.get(productType.toUpperCase());
    }
    
    @Override
    public double getProductCostPerSquareFoot(String productType) {
        return productMap.get(productType.toUpperCase()).getCostPerSquareFoot();
    }
    
    @Override
    public double getProductLaborCostPerSquareFoot(String productType) {
        return productMap.get(productType.toUpperCase()).getLaborCostPerSquareFoot();
    }    
    
    @Override
    public void removeProduct(String productType) {
        productMap.remove(productType.toUpperCase());
    }    

    @Override
    public void loadProductMap() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));

        String currentRecord = "";
        String[] currentTokens;
        Product p;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            p = new Product(currentTokens[0], Double.parseDouble(currentTokens[1]),
                    Double.parseDouble(currentTokens[2]));
            productMap.put(currentTokens[0].toUpperCase(), p);
        }
        in.close();

    }
    
    @Override
    public void saveProducts() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PRODUCT_FILE));
        
        Collection<Product> values = productMap.values();
        Iterator<Product>   iter   = values.iterator();
        Product p;
        while (iter.hasNext()) {
            p = iter.next();
            out.println(p.getProductType()+DELIMITER
                      + p.getCostPerSquareFoot()+DELIMITER
                      + p.getLaborCostPerSquareFoot());
            out.flush();
        }
        out.close();
    }
  
}
