/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;


import com.swcguild.scarletexpo.model.Category;
import com.swcguild.scarletexpo.model.Event;
import com.swcguild.scarletexpo.model.Note;
import com.swcguild.scarletexpo.model.Product;
import com.swcguild.scarletexpo.model.ProductItem;
import com.swcguild.scarletexpo.model.User;
import com.swcguild.scarletexpo.model.view.EventView;
import com.swcguild.scarletexpo.model.view.ProductCheckOutView;
import com.swcguild.scarletexpo.model.view.ProductItemCheckOut;
import com.swcguild.scarletexpo.model.view.ProductItemView;
import com.swcguild.scarletexpo.model.view.ProductView;
import com.swcguild.scarletexpo.model.view.UserView;
import java.util.List;

/**
 *
 * @author klove
 */
public interface ScarletExpoDao {

    //products
    public void addNewProduct(Product product);

    public void updateProduct(Product product);
    
    public void deleteProduct(int productId);

    public Product getProductById(int productId);
    
    public Product getProductByName(String productName);
    
    public List<Product> getAllProducts();
    
    //products
    public List<ProductItem> getProductItemByProductId(int productId);
    
    //product items
    public void addProductItems(ProductItem pItem);
    
    //product items
    public ProductItem getProductItemById(int prodItemId);
    
    //product items
    public void updateProductItem(ProductItem pItem);
    
    //products view
    public List<ProductView> displayAllProducts();
    
    //product items view
    public List<ProductItemView> displayProductItemsByProductId(int productId);
    
    //product items view for checkout
    public List<ProductView> displayAvailableProducts();
    
    //user
    public void addNewUser(User user);
    
    //user
    public User getUserByUserName(String userName);
    
    //user
    public void updateUser(User user);
    
    //user
    public void updaterUserProfile(User user);
    
    //user
    public List<User> getUsersByProfileId(int profileId);
    
    //user
    public List<User> getAllUsers();
    
    //user
    public User getUserByUserId(int userId);
    
    //user notes
    public List<Note> getNotesByUserId(int userId);

    //usre view
    public List<UserView> displayAllUsers();
    
    //category
    public void addNewCategory(Category category);
    
    //category
    public void updateCategory(Category category);
    
    //category
    public void removeCategory(int categoryId);
    
    //category
    public Category getCategoryById(int categoryId);
            
    //category
    public List<Category> getAllCategories();
    
    //category
    public Category getCategoryByName(String categoryName);
    
    //category
    public List<Product> getProductsByCategoryId(int categoryId);

    //Event
    public void createEvent(Event event);
    
    public void createEventsAndReserveProductItems(Event event);
    
    public void checkInEventsAndPrductITems(Event event);
    
    public void updateEvent(Event event);
    
    //Event
    public Event getEventsByEventId(int eventId);
    
    public List<ProductItem> getProductItemByEventId(int eventId);
    
    //Events
    public List<EventView> displayAllEvents();       
}
