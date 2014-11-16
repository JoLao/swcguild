package com.swcguild.myscarletexpo.dao.implementation;


import com.swcguild.myscarletexpo.dao.interfaces.ProductViewDao;
import com.swcguild.myscarletexpo.model.Note;
import com.swcguild.myscarletexpo.model.view.ProductAvailableView;
import com.swcguild.myscarletexpo.model.view.ProductItemView;
import com.swcguild.myscarletexpo.model.view.ProductView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//import org.joda.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ProductViewDaoImpl implements ProductViewDao {

    private static final String SQL_PRODUCT_VIEW
            = "select p.productId, productName, productDesc, categoryName, IFNULL(qty, 0) as quantity " 
            + "from products p inner join categories c " 
            + "on p.categoryId = c.categoryId " 
            + "left outer join " 
            + "(select productId, count(*) as qty " 
            + "from product_items " 
            + "where isActive = 1 " 
            + "and isCheckedOut = 0 " 
            + "and isDamaged = 0 " 
            + "and isLost = 0 " 
            + "group by productId) as pi " 
            + "on p.productId = pi.productId " 
            + "order by c.categoryName, p.productName, categoryName";
   
    public static final String SQL_GET_PRODUCT_ITEM_BY_PRODUCT_ID
            = "SELECT * FROM product_items"
            + " WHERE productId = ?";

    private static final String SQL_SELECT_NOTES_BY_PRODUCTITEMID
            = "select n.notesId, DATE_FORMAT(DATE(dateEntered), '%m-%d-%Y') as dateEntered, n.notes from notes n"
            + " join product_items_notes pin"
            + " on n.notesId = pin.notesId"
            + " where productItemId = ?"
            + " order by dateEntered desc";

    private static final String SQL_SELECT_AVAILABLE_PRODUCTITEMS_PER_PRODUCTID
            = "SELECT p.productId, p.productName, COUNT(*) AS numOfProducts "
            + "FROM products p "
            + "INNER JOIN product_items pi "
            + "ON p.productId = pi.productId "
            + "WHERE p.productId = ? "
            + "AND pi.isActive = 1 "
            + "AND pi.isCheckedOut = 0 "
            + "AND pi.isDamaged = 0 "
            + "AND pi.isLost = 0 "
            + "GROUP BY p.productId, p.productName";

    private static final String SQL_SELECT_AVAILABLE_PRODUCTSITEMS
            = "SELECT pi.* "
            + "FROM products p "
            + "INNER JOIN product_items pi "
            + "ON p.productId = pi.productId "
            + "WHERE pi.isActive = 1 "
            + "AND pi.isCheckedOut = 0 "
            + "AND pi.isDamaged = 0 "
            + "AND pi.isLost = 0 "
            + "ORDER BY pi.productId, pi.productItemId";
    
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
    public List<ProductAvailableView> displayAvailableProducts() {
        return jdbcTemplate.query(SQL_SELECT_AVAILABLE_PRODUCTITEMS_PER_PRODUCTID, 
                                  new ProductAvailableMapper());
    }

    private static final class ProductAvailableMapper implements ParameterizedRowMapper<ProductAvailableView> {

        @Override
        public ProductAvailableView mapRow(ResultSet rs, int i) throws SQLException {
            ProductAvailableView pav = new ProductAvailableView();
            pav.setProductId(rs.getInt("p.productId"));
            pav.setProductName(rs.getString("productName"));
            pav.setNumberOfAvailableProductItems(rs.getInt("numOfProducts"));
            return pav;
        }
        
    }
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
            return pv;
        }

    }
}
