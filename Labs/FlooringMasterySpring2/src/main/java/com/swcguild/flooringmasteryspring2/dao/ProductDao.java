/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.Product;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public interface ProductDao {
    String DELIMITER = ",";
    String PRODUCT_FILE = "products.txt";

    void addProduct(String productType, double costPerSquareFoot, double laborCostPerSquareFoot);

    Product[] getAllProducts();

    Product getProduct(String productType);

    double getProductCostPerSquareFoot(String productType);

    double getProductLaborCostPerSquareFoot(String productType);

    boolean isProductAvailable(String productType);

    void loadProductMap() throws FileNotFoundException;

    void removeProduct(String productType);

    void saveProducts() throws IOException;
    
}
