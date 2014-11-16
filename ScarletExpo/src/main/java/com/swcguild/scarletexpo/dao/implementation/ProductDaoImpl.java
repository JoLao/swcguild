package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.ProductDao;
import com.swcguild.scarletexpo.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //SQL STATEMENTS
    private static final String SQL_INSERT_PRODUCT
            = "insert into products (productName, productDesc, isActive, categoryId) "
            + " values (?, ?, ?, ?)";

    private static final String SQL_SELECT_ACTIVE_PRODUCT
            = "select * from products where productId = ? AND isActive = 1";
    
    private static final String SQL_SELECT_INACTIVE_PRODUCT
            ="select * from products where productId = ? AND isActive =0";

    private static final String SQL_UPDATE_PRODUCT
            = "update products set productName = ?, productDesc = ?, categoryId = ?, isActive = ?"
            + " where productId = ?";

    private static final String SQL_DELETE_PRODUCT
            = "delete from products where productId = ?";

    private static final String SQL_SELECT_PRODUCTS_BY_CATEGORYID
            = "select * from products where categoryId = ?";

    private static final String SQL_SELECT_ALL_PRODUCTS
            = "SELECT * FROM products"
            + " ORDER BY productName ASC";

    private static final String SQL_SELECT_PRODUCTS_BY_NAME
            = "SELECT * FROM products"
            + " WHERE productName = ?";

    private static final String SQL_DEACTIVATE_PRODUCTITEMS_BY_PRODUCTID
            = "UPDATE product_items set isActive = 0 "
            + "WHERE productId = ?";

    private static final String SQL_DEACTIVATE_PRODUCTS_BY_PRODUCTID
            = "UPDATE products set isActive = 0 "
            + "WHERE productId = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addProduct(Product product) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT,
                product.getProductName(),
                product.getProductDesc(),
                product.getActive(),
                product.getCategoryId());

        product.setProductId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Product getActiveProductById(int productId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ACTIVE_PRODUCT, new ProductMapper(), productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public Product getInactiveProductById(int productId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_INACTIVE_PRODUCT, new ProductMapper(), productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update(SQL_UPDATE_PRODUCT,
                product.getProductName(),
                product.getProductDesc(),
                product.getCategoryId(),
                product.getActive(),
                product.getProductId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteProduct(int productId) {
        jdbcTemplate.update(SQL_DEACTIVATE_PRODUCTITEMS_BY_PRODUCTID, productId);
        jdbcTemplate.update(SQL_DEACTIVATE_PRODUCTS_BY_PRODUCTID, productId);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> pList = jdbcTemplate.query(SQL_SELECT_PRODUCTS_BY_CATEGORYID, new ProductMapper(), categoryId);
        return pList;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> pList = jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, new ProductMapper());

        return pList;
    }

    @Override
    public Product getProductByName(String productName) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PRODUCTS_BY_NAME, new ProductMapper(), productName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //HELPER CLASSES
    private static final class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int i) throws SQLException {

            Product p = new Product();

            p.setProductName(rs.getString("productName"));
            p.setProductDesc(rs.getString("productDesc"));
            p.setCategoryId(rs.getInt("categoryId"));
            p.setActive((rs.getBoolean("isActive")));
            p.setProductId(rs.getInt("productId"));

            return p;
        }

    }

}
