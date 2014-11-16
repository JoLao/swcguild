/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.controller;

import com.swcguild.myscarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.myscarletexpo.model.Category;
import com.swcguild.myscarletexpo.model.Product;
import com.swcguild.myscarletexpo.model.ProductItem;
import com.swcguild.myscarletexpo.model.view.ProductItemCheckOut;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jlao
 */

@Controller
public class EventController {
    
    private ScarletExpoDao scarletExpoDao;

    @Inject
    public void setScarletExpoDao(ScarletExpoDao scarletExpoDao) {
        this.scarletExpoDao = scarletExpoDao;
    }
    
    @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
    public String checkOutForm(Model model) {
        List<Category> categories = scarletExpoDao.getAllCategories();
//        List<ProductAvailableView> pavList = scarletExpoDao.displayAvailableProducts();
        List<Product> productList = scarletExpoDao.getAllProducts();
        
        model.addAttribute("categories", categories);
        model.addAttribute("productList", productList);
        
        return "Portal/checkOut";
    }
    
    @RequestMapping(value ="/checkOutProduct", method = RequestMethod.POST)
    public String checkOut(@RequestParam("productId") int productId, Model model) {
        List<Category> categories = scarletExpoDao.getAllCategories();
        List<Product> productList = scarletExpoDao.getAllProducts();
        
        ProductItemCheckOut productItemCheckout = new ProductItemCheckOut();
        List<ProductItem> productItemList = scarletExpoDao.getProductItemByProductId(productId);
        productItemCheckout.setProductItemList(productItemList);
        
        model.addAttribute("categories", categories);
        model.addAttribute("productList", productList);
        model.addAttribute("productItemCheckout", productItemCheckout);
        
        return "Portal/checkOut";
    }
    
    @RequestMapping(value = "/processExpressCheckOut", method = RequestMethod.POST)
    public String processExpressCheckOut(@ModelAttribute("productItemCheckout") 
                                         ProductItemCheckOut productItemCheckout, 
                                         Model model) {
                        
        //create event, event_product_items, update product_items
        scarletExpoDao.createEvent(productItemCheckout);
                
        return "Portal/checkOut";
    }
   
}
