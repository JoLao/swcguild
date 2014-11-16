/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;


import com.swcguild.scarletexpo.dao.interfaces.CategoryDao;
import com.swcguild.scarletexpo.model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author klove
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public static final String SQL_INSERT_CATEGORY
            ="insert into categories (categoryName)"
            + " values (?)";
    
    public static final String SQL_DELETE_CATEGORY
            ="delete from categories where categoryId = ?";
    
    public static final String SQL_SELECT_CATEGORY_BY_ID
            ="select * from categories"
            + " where categoryId = ?";
    
    public static final String SQL_SELECT_CATEGORY_BY_NAME
            ="select * from categories"
            + " where categoryName = ?";
    
    public static final String SQL_SELECT_ALL_CATEGORIES
            ="select * from categories"
            + " order by categoryName asc";
    
    public static final String SQL_UPDATE_CATEGORY
            ="update categories set categoryName = ?"
            + " where categoryId = ?";

    @Override
    public void addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
        category.setCategoryId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Category getCategoryById(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_ID, new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public Category getCategoryByName(String categoryName) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_NAME, new CategoryMapper(), categoryName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public void removeCategory(int categoryId) {
       jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new CategoryMapper());
    }

    @Override
    public void updateCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryName(),
                category.getCategoryId());
    }
    
    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category c = new Category();
            c.setCategoryName(rs.getString("categoryName"));
            c.setCategoryId(rs.getInt("categoryId"));
            return c;
        }

    }

}