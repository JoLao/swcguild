/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.implementation;


import com.swcguild.myscarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.myscarletexpo.dao.interfaces.ChartsDao;
import com.swcguild.myscarletexpo.dao.interfaces.EventDao;
import com.swcguild.myscarletexpo.dao.interfaces.NoteDao;
import com.swcguild.myscarletexpo.dao.interfaces.ProductDao;
import com.swcguild.myscarletexpo.dao.interfaces.ProductItemDao;
import com.swcguild.myscarletexpo.dao.interfaces.ProductViewDao;
import com.swcguild.myscarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.myscarletexpo.dao.interfaces.UserDao;
import com.swcguild.myscarletexpo.dao.interfaces.UserViewDao;
import com.swcguild.myscarletexpo.model.Category;
import com.swcguild.myscarletexpo.model.Event;
import com.swcguild.myscarletexpo.model.Note;
import com.swcguild.myscarletexpo.model.Product;
import com.swcguild.myscarletexpo.model.ProductItem;
import com.swcguild.myscarletexpo.model.User;
import com.swcguild.myscarletexpo.model.view.ProductAvailableView;
import com.swcguild.myscarletexpo.model.view.ProductItemCheckOut;
import com.swcguild.myscarletexpo.model.view.ProductItemView;
import com.swcguild.myscarletexpo.model.view.ProductView;
import com.swcguild.myscarletexpo.model.view.UserView;
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
        return productDao.getProductById(productId);
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

    //product available & count
    @Override
    public List<ProductAvailableView> displayAvailableProducts() {
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createEvent(ProductItemCheckOut productItemCheckout) {
        Event event = new Event();
        event.setEventStart(LocalDate.now().toString());
        event.setEventDesc(productItemCheckout.getEventDesc());
        eventDao.createEvent(event);

        List<ProductItem> piList = productItemCheckout.getProductItemList();
        for (ProductItem pi : piList) {
            eventDao.createEventProductItem(event.getEventId(), pi.getProductItemId());
            if (pi.isCheckedOut()) {
                updateProductItem(pi);
            }
        }

    }
}
