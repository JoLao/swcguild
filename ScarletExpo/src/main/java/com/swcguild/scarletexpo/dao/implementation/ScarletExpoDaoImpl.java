/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.EventViewDao;
import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.dao.interfaces.ChartsDao;
import com.swcguild.scarletexpo.dao.interfaces.EventDao;
import com.swcguild.scarletexpo.dao.interfaces.NoteDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductItemDao;
import com.swcguild.scarletexpo.dao.interfaces.ProductViewDao;
import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.dao.interfaces.UserDao;
import com.swcguild.scarletexpo.dao.interfaces.UserViewDao;
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
import java.time.LocalDate;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author klove
 */
public class ScarletExpoDaoImpl implements ScarletExpoDao {

    private CategoryDao categoryDao;
    private ChartsDao chartsDao;
    private EventDao eventDao;
    private NoteDao noteDao;
    private ProductDao productDao;
    private ProductItemDao productItemDao;
    private UserDao userDao;

    private ProductViewDao productViewDao;
    private UserViewDao userViewDao;
    private EventViewDao eventViewDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setChartsDao(ChartsDao chartsDao) {
        this.chartsDao = chartsDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setProductItemDao(ProductItemDao productItemDao) {
        this.productItemDao = productItemDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setProductViewDao(ProductViewDao productViewDao) {
        this.productViewDao = productViewDao;
    }

    public void setUserViewDao(UserViewDao userViewDao) {
        this.userViewDao = userViewDao;
    }

    public EventViewDao getEventViewDao() {
        return eventViewDao;
    }

    public void setEventViewDao(EventViewDao eventViewDao) {
        this.eventViewDao = eventViewDao;
    }

    @Override
    public List<ProductItem> getProductItemByProductId(int productId) {
        return productItemDao.getProductItemsByProductId(productId);
    }

    //products
    @Override
    public void addNewProduct(Product product) {
        //entering product 
        productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
        //generating product items
        //addNewProductItem(product);
    }

    @Override
    public Product getProductById(int productId) {
        return productDao.getActiveProductById(productId);
    }

    @Override
    public Product getProductByName(String productName) {
        return productDao.getProductByName(productName);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return productDao.getProductsByCategoryId(categoryId);
    }

    //product item
    @Override
    public void addProductItems(ProductItem pItem) {
        productItemDao.addProductItem(pItem);
    }

    @Override
    public ProductItem getProductItemById(int prodItemId) {
        return productItemDao.getProductItemById(prodItemId);
    }

    //product itmes
    @Override
    public void updateProductItem(ProductItem pItem) {
        productItemDao.updateProductItem(pItem);
    }

    //product view
    @Override
    public List<ProductView> displayAllProducts() {
        return productViewDao.displayAllProducts();
    }

    //product item view
    @Override
    public List<ProductItemView> displayProductItemsByProductId(int productId) {
        return productViewDao.displayProductItemsByProductId(productId);
    }

    @Override
    public List<ProductView> displayAvailableProducts() {
        return productViewDao.displayAvailableProducts();
    }

    //user
    @Override
    public void addNewUser(User user) {
        userDao.addUser(user);
    }

    //User
    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    //User
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    //user
    @Override
    public void updaterUserProfile(User user) {
        userDao.updateProfile(user);
    }

    //user
    @Override
    public List<User> getUsersByProfileId(int profileId) {
        return userDao.getUsersByProfileId(profileId);
    }

    //user
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public List<Note> getNotesByUserId(int userId) {
        return noteDao.getNotesByUserId(userId);
    }

    //User View
    @Override
    public List<UserView> displayAllUsers() {
        return userViewDao.displayAllUsers();
    }

    //category
    @Override
    public void addNewCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    public void removeCategory(int categoryId) {
        categoryDao.removeCategory(categoryId);
    }

    @Override
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    //Events
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createEventsAndReserveProductItems(Event event) {

        eventDao.createEvent(event);
        int[] productItemIds = event.getProductItemIds();
        ProductItem pi;

        for (int i = 0; i < productItemIds.length; i++) {
            eventDao.createEventProductItem(event.getEventId(), productItemIds[i]);
            pi = productItemDao.getProductItemById(productItemIds[i]);
            pi.setCheckedOut(true);
            updateProductItem(pi);
        }

    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void checkInEventsAndPrductITems(Event event) {
        
        int[] productItemIds = event.getProductItemIds();
        ProductItem pi;

        for (int i = 0; i < productItemIds.length; i++) {            
            pi = productItemDao.getProductItemById(productItemIds[i]);
            pi.setCheckedOut(false);
            updateProductItem(pi);
        }
       
        eventDao.updateEventReturnDate(event);
    }
    
    @Override
    public List<ProductItem> getProductItemByEventId(int eventId) {
        return productItemDao.getProductItemByEventId(eventId);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createEvent(Event event) {
        eventDao.createEvent(event);        
    }
    
    @Override
    public void updateEvent(Event event) {
        eventDao.updateEvent(event);
    }
        
    @Override
    public Event getEventsByEventId(int eventId) {
        return eventDao.getEventsByEventId(eventId);
    }
    
    @Override
    public List<EventView> displayAllEvents() {
        return eventViewDao.displayAllEvents();
    }
    
}
