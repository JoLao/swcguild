/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;

import com.swcguild.scarletexpo.model.view.ProductCheckOutView;
import com.swcguild.scarletexpo.model.view.ProductItemView;
import com.swcguild.scarletexpo.model.view.ProductView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ProductViewDao {

    List<ProductView> displayAllProducts();
    
    public List<ProductItemView> displayProductItemsByProductId(int productId);
        
    public List<ProductView> displayAvailableProducts();
    
}
