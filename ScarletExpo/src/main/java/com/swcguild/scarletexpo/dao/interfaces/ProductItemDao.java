/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;


import com.swcguild.scarletexpo.model.ProductItem;
import java.util.List;

/**
 *
 * @author klove
 */
public interface ProductItemDao {

    public void addProductItem(ProductItem pItem);

    public void updateProductItem(ProductItem pItem);
    
    public ProductItem getProductItemById(int prodItemId);
    
    public List<ProductItem> getProductItemByUserId(int userId);
    
    public List<ProductItem> getProductItemByEventId(int eventId);
    
    public List<ProductItem> getProductItemsByProductId(int productId);
    
    public int[] getNotesByProductItemId(ProductItem productItem);
}
