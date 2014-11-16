/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;


import com.swcguild.myscarletexpo.model.view.ProductAvailableView;
import com.swcguild.myscarletexpo.model.view.ProductItemView;
import com.swcguild.myscarletexpo.model.view.ProductView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ProductViewDao {

    List<ProductView> displayAllProducts();
    
    public List<ProductItemView> displayProductItemsByProductId(int productId);
    
    public List<ProductAvailableView> displayAvailableProducts();
    
}
