/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;


import com.swcguild.myscarletexpo.model.Product;
import java.util.List;

/**
 *
 * @author klove
 */
public interface ProductDao {

    public void addProduct(Product product);

    public Product getProductById(int productId);
    
    public Product getProductByName(String productName);

    public void updateProduct(Product product);
    
    public void deleteProduct(int productId);

    public List<Product> getProductsByCategoryId(int categoryId);
    
    public List<Product> getAllProducts();
}
