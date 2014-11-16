/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.model.view;

/**
 *
 * @author apprentice
 */
public class ProductAvailableView {

    private int productId;
    private String productName;
    private int numberOfAvailableProductItems;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfAvailableProductItems() {
        return numberOfAvailableProductItems;
    }

    public void setNumberOfAvailableProductItems(int numberOfAvailableProductItems) {
        this.numberOfAvailableProductItems = numberOfAvailableProductItems;
    }
    
    

}
