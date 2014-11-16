/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.model.view;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class ProductView {
    private int productId;   
    private String productName;    
    private String productDesc;
    private String categoryName;  
    private boolean isActive;
    private int quantity;
    private List<ProductItemView> productItemView;

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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
        
    public List<ProductItemView> getProductItemView() {
        return productItemView;
    }

    public void setProductItemView(List<ProductItemView> productItemView) {
        this.productItemView = productItemView;
    }
}
