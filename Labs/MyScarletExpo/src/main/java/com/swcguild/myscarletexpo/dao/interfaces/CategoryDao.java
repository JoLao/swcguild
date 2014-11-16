/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;



import com.swcguild.myscarletexpo.model.Category;
import java.util.List;

/**
 *
 * @author klove
 */
public interface CategoryDao {

    public void addCategory(Category category);

    public void removeCategory(int categoryId);

    public Category getCategoryById(int categoryId);
            
    public Category getCategoryByName(String categoryName);
            
    public List<Category> getAllCategories();

    public void updateCategory(Category category);
}
