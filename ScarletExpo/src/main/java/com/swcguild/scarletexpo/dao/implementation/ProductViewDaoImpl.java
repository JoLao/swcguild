package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.ProductViewDao;
import com.swcguild.scarletexpo.model.Note;
import com.swcguild.scarletexpo.model.view.ProductItemView;
import com.swcguild.scarletexpo.model.view.ProductView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import org.joda.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ProductViewDaoImpl implements ProductViewDao {

    private static final String SQL_PRODUCT_VIEW
            = "SELECT p.productId, productName, productDesc, categoryName, p.isActive, IFNULL(qty, 0) as quantity " 
            + "FROM products p inner join categories c " 
            + "ON p.categoryId = c.categoryId " 
            + "LEFT OUTER JOIN " 
            + "(SELECT productId, count(*) as qty " 
            + "FROM product_items " 
            + "WHERE isActive = 1 " 
            + "AND isCheckedOut = 0 " 
            + "AND isDamaged = 0 " 
            + "AND isLost = 0 " 
            + "GROUP BY productId) as pi " 
            + "ON p.productId = pi.productId " 
            + "WHERE p.isActive = 1 "
            + "ORDER BY c.categoryName, p.productName, categoryName, p.isActive";
       
    private static final String SQL_AVAILABLE_PRODUCT_VIEW
            = "SELECT p.productId, productName, productDesc, categoryName, p.isActive, IFNULL(qty, 0) as quantity " 
            + "FROM products p inner join categories c " 
            + "ON p.categoryId = c.categoryId " 
            + "LEFT OUTER JOIN " 
            + "(SELECT productId, count(*) as qty " 
            + "FROM product_items " 
            + "WHERE isActive = 1 " 
            + "AND isCheckedOut = 0 " 
            + "AND isDamaged = 0 " 
            + "AND isLost = 0 " 
            + "GROUP BY productId) as pi " 
            + "ON p.productId = pi.productId " 
            + "WHERE p.isActive = 1 "
            + "AND qty > 0 "
            + "ORDER BY c.categoryName, p.productName, categoryName, p.isActive";
    
    public static final String SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID
            = "SELECT * FROM product_items "
            + "WHERE productId = ? "
            + "AND isActive = 1";
    
    public static final String SQL_GET_AVAILABLE_PRODUCT_ITEM_BY_PRODUCT_ID
            = "SELECT * FROM product_items "
            + "WHERE productId = ? "
            + "AND isActive = 1 "
            + "AND isCheckedOut = 0 " 
            + "AND isDamaged = 0 " 
            + "AND isLost = 0 " ;

    private static final String SQL_SELECT_NOTES_BY_PRODUCTITEMID
            = "select n.notesId, DATE_FORMAT(DATE(dateEntered), '%m-%d-%Y') as dateEntered, n.notes from notes n"
            + " join product_items_notes pin"
            + " on n.notesId = pin.notesId"
            + " where productItemId = ?"
            + " order by dateEntered desc";

//    private static final String SQL_SELECT_AVAILABLE_PRODUCTITEMS_PER_PRODUCTID
//            = "SELECT p.productId, p.productName, COUNT(*) AS numOfProducts "
//            + "FROM products p "
//            + "INNER JOIN product_items pi "
//            + "ON p.productId = pi.productId "
//            + "WHERE p.productId = ? "
//            + "AND pi.isActive = 1 "
//            + "AND pi.isCheckedOut = 0 "
//            + "AND pi.isDamaged = 0 "
//            + "AND pi.isLost = 0 "
//            + "GROUP BY p.productId, p.productName";

//    private static final String SQL_SELECT_AVAILABLE_PRODUCTSITEMS
//            = "SELECT pi.* "
//            + "FROM products p "
//            + "INNER JOIN product_items pi "
//            + "ON p.productId = pi.productId "
//            + "WHERE pi.isActive = 1 "
//            + "AND pi.isCheckedOut = 0 "
//            + "AND pi.isDamaged = 0 "
//            + "AND pi.isLost = 0 "
//            + "ORDER BY pi.productId, pi.productItemId";
    
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductView> displayAllProducts() {
        List<ProductView> pvList = jdbcTemplate.query(SQL_PRODUCT_VIEW, new ProductViewMapper());
//        List<ProductItemView> pivList = new ArrayList<>();
//        
//        for (ProductView pv : pvList) {
//            pivList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID,
//                                        new ProductItemViewMapper(),
//                                        pv.getProductId());
//            pv.setProductItemView(pivList);
//            for (ProductItemView piv : pivList) {
//                piv.setNotes(jdbcTemplate.query(SQL_SELECT_NOTES_BY_PRODUCTITEMID, 
//                                                new NoteMapper(), 
//                                                piv.getProductItemId()));
//            }
//        }
        return pvList;
    }

    @Override
    public List<ProductItemView> displayProductItemsByProductId(int productId) {

        List<ProductItemView> pivList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID,
                new ProductItemViewMapper(),
                productId);

        for (ProductItemView piv : pivList) {
            piv.setNotes(jdbcTemplate.query(SQL_SELECT_NOTES_BY_PRODUCTITEMID,
                    new NoteMapper(),
                    piv.getProductItemId()));
        }
        return pivList;
    }
          
    @Override
    public List<ProductView> displayAvailableProducts() {
        List<ProductView> pvList = jdbcTemplate.query(SQL_AVAILABLE_PRODUCT_VIEW, new ProductViewMapper());
        List<ProductItemView> pivList = new ArrayList<>();
        
        for (ProductView pv : pvList) {
            pivList = jdbcTemplate.query(SQL_GET_AVAILABLE_PRODUCT_ITEM_BY_PRODUCT_ID, 
                                  new ProductItemViewMapper(),
                                  pv.getProductId());
            pv.setProductItemView(pivList);
        }
        return pvList;
    }

//    private static final class ProductAvailableMapper implements ParameterizedRowMapper<ProductAvailableView> {
//
//        @Override
//        public ProductAvailableView mapRow(ResultSet rs, int i) throws SQLException {
//            ProductAvailableView pav = new ProductAvailableView();
//            pav.setProductId(rs.getInt("p.productId"));
//            pav.setProductName(rs.getString("productName"));
//            pav.setNumberOfAvailableProductItems(rs.getInt("numOfProducts"));
//            return pav;
//        }
//        
//    }
    
    private static final class NoteMapper implements ParameterizedRowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {
            Note n = new Note();
            n.setNoteId(rs.getInt("notesId"));
            String dateParser = rs.getTimestamp("dateEntered").toString();
//            LocalDateTime dateEntered = rs.getTimestamp("dateEntered").toLocalDateTime();
            n.setDateEntered(rs.getString("dateEntered"));
            n.setNote(rs.getString("notes"));
            return n;
        }

    }

    private static final class ProductItemViewMapper implements RowMapper<ProductItemView> {

        @Override
        public ProductItemView mapRow(ResultSet rs, int i) throws SQLException {
            ProductItemView pItem = new ProductItemView();

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

    private static final class ProductViewMapper implements RowMapper<ProductView> {

        @Override
        public ProductView mapRow(ResultSet rs, int i) throws SQLException {
            ProductView pv = new ProductView();
            pv.setProductId(rs.getInt("productId"));
            pv.setProductName(rs.getString("productName"));
            pv.setProductDesc(rs.getString("productDesc"));
            pv.setCategoryName(rs.getString("categoryName"));
            pv.setQuantity(rs.getInt("quantity"));
            pv.setIsActive(rs.getBoolean("isActive"));
            return pv;
        }

    }
}
