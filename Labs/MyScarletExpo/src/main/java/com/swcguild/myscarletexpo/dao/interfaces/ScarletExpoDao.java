/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;



import com.swcguild.myscarletexpo.model.Category;
import com.swcguild.myscarletexpo.model.Note;
import com.swcguild.myscarletexpo.model.Product;
import com.swcguild.myscarletexpo.model.ProductItem;
import com.swcguild.myscarletexpo.model.User;
import com.swcguild.myscarletexpo.model.view.ProductAvailableView;
import com.swcguild.myscarletexpo.model.view.ProductItemCheckOut;
import com.swcguild.myscarletexpo.model.view.ProductItemView;
import com.swcguild.myscarletexpo.model.view.ProductView;
import com.swcguild.myscarletexpo.model.view.UserView;
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
    
    //available products & count
    public List<ProductAvailableView> displayAvailableProducts();
    
    //user
    public void addNewUser(User user);
    
    //user
    public User getUserByUserName(String userName);
    
    //user
    public void updateUser(User user);
    
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
    public void createEvent(ProductItemCheckOut productItemCheckout);
}
