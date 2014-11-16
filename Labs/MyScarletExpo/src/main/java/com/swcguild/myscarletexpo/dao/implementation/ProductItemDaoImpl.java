/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.implementation;


import com.swcguild.myscarletexpo.dao.interfaces.ProductItemDao;
import com.swcguild.myscarletexpo.model.ProductItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author klove
 */
public class ProductItemDaoImpl implements ProductItemDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //sql statements
    public static final String SQL_INSERT_PRODUCT_ITEM 
            = "INSERT INTO product_items (productId, itemName)"
            + " VALUES (?, ?)";
    
    public static final String SQL_UPDATE_PRODUCT_ITEM
           = "UPDATE product_items SET"
            + " productId = ?, itemName = ?, isCheckedOut = ?, isDamaged = ?, isLost = ?, isActive = ?"
            + " WHERE productItemId = ?";
    
    public static final String SQL_GET_PRODUCT_ITEM_BY_ID
            = "SELECT * FROM product_items"
            + " WHERE productItemId = ?";
    
    public static final String SQL_GET_PRODUCT_ITEM_BY_USER_ID
            = "SELECT * FROM product_items pi"
            + " JOIN event_product_items epi ON pi.productItemId = epi.productItemId"
            + " JOIN events e ON epi.eventId = e.eventId"
            + " WHERE e.userId = ?";
    
    public static final String SQL_GET_PRODUCT_ITEM_BY_EVENT_ID
            = "SELECT * FROM product_items pi"
            + " JOIN event_product_items epi ON pi.productItemId = epi.productItemId"
            + " JOIN events e ON epi.eventId = e.eventId"
            + " WHERE e.eventId = ?";
    
    public static final String SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID
            = "SELECT * FROM product_items"
            + " WHERE productId = ?"
            + " AND isActive = 1"
            + " AND isCheckedOut = 0"
            + " AND isDamaged = 0"
            + " AND isLost = 0";
    
    private static final String SQL_SELECT_NOTES_BY_PRODUCTITEMID
            = "select n.notesId from notes n"
            + " join product_items_notes pin"
            + " on n.notesId = pin.notesId"
            + " where productItemId = ?"
            + " order by dateEntered desc";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addProductItem(ProductItem pItem) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT_ITEM,
                pItem.getProductId(),
                pItem.getProductItemName());
        
        pItem.setProductItemId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void updateProductItem(ProductItem pItem) {
        jdbcTemplate.update(SQL_UPDATE_PRODUCT_ITEM,
                pItem.getProductId(),
                pItem.getProductItemName(),
                pItem.isCheckedOut(),
                pItem.isDamaged(),
                pItem.isLost(),
                pItem.isActive(),
                pItem.getProductItemId());
    }

    @Override
    public ProductItem getProductItemById(int prodItemId) {
        ProductItem productItem;
        int[] idArray;
        try {
            productItem = jdbcTemplate.queryForObject(SQL_GET_PRODUCT_ITEM_BY_ID, new ProductItemMapper(), prodItemId);
            idArray = getNotesByProductItemId(productItem);
            productItem.setNoteIds(idArray);
            return productItem;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<ProductItem> getProductItemByUserId(int userId) {
        List<ProductItem> pList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEM_BY_USER_ID, new ProductItemMapper(), userId);
        int[] idArray;
        
        for (ProductItem pi : pList) {
            idArray = getNotesByProductItemId(pi);
            pi.setNoteIds(idArray);
        }
        return pList;
    }

    @Override
    public List<ProductItem> getProductItemByEventId(int eventId) {
        List<ProductItem> pList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEM_BY_EVENT_ID, new ProductItemMapper(), eventId);
        int[] idArray;
        
        for (ProductItem pi : pList) {
            idArray = getNotesByProductItemId(pi);
            pi.setNoteIds(idArray);
        }
        return pList;
    }

    @Override
    public List<ProductItem> getProductItemsByProductId(int productId) {
        List<ProductItem> pList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID, new ProductItemMapper(), productId);
        int[] idArray;
        
        for (ProductItem pi : pList) {
            idArray = getNotesByProductItemId(pi);
            pi.setNoteIds(idArray);
        }
        
        return pList;
    }
    
    @Override
    public int[] getNotesByProductItemId(ProductItem productItem) {
        List<Integer> notesIds = jdbcTemplate.queryForList(SQL_SELECT_NOTES_BY_PRODUCTITEMID, 
                                         new Integer[]{productItem.getProductItemId()}, Integer.class);
        
        int[] idArray = new int[notesIds.size()];
        
        for (int i = 0; i < notesIds.size(); i++) {
            idArray[i] = notesIds.get(i);
        }
        
        return idArray;
    }
    
    //mapper
    private static final class ProductItemMapper implements RowMapper<ProductItem> {

        @Override
        public ProductItem mapRow(ResultSet rs, int i) throws SQLException {
            ProductItem pItem = new ProductItem();
            
            pItem.setProductItemId(rs.getInt("productItemId"));
            pItem.setProductId(rs.getInt("productId"));
            pItem.setActive(rs.getBoolean("isActive"));
            pItem.setCheckedOut(rs.getBoolean("isCheckedOut"));
            pItem.setDamaged(rs.getBoolean("isDamaged"));
            pItem.setLost(rs.getBoolean("isLost"));
            pItem.setProductItemName(rs.getString("itemName"));
            
            return pItem;
        }
        
    }
}
