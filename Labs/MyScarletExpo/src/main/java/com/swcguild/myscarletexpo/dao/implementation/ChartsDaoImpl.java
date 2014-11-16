package com.swcguild.myscarletexpo.dao.implementation;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.swcguild.myscarletexpo.dao.interfaces.ChartsDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ChartsDaoImpl implements ChartsDao {

    private JdbcTemplate jdbcTemplate;

   
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Report A -
    private static final String SQL_GET_PRODUCT_ITEMS_DAMAGED_BY_PRODUCT
            = " Select pr.productName AS productName, count(pi.productId) AS damageCount " //aliases --need for every one
            + "FROM products AS pr "
            + "INNER JOIN product_items AS pi "
            + "ON pi.productId=pr.productId "
            + "WHERE pi.isDamaged=1 "
            + "AND pi.isLost=0 "
            + "AND pi.isActive=1 "
            + "GROUP BY pr.productName";

    //Report B
    private static final String SQL_GET_PRODUCT_USAGE
            = "Select pr.productName, count (eventId)"
            + "FROM products pr"
            + "INNER JOIN product_item pi"
            + "ON pi.productId=pr.productId"
            + "INNER JOIN events_product_items epi"
            + "ON pi.productItemId= epi.productItemId"
            + "GROUP BY pr.product_name";

    //Report C
    private static final String SQL_GET_LOSS_BY_PRODUCT
            = "Select pi.productName, count(productItemId)"
            + "FROM productItem pi"
            + "INNER JOIN product pr"
            + "ON pr.productId=pi.productId"
            + "WHERE pi.isLost=1"
            + "GROUP BY pr.product_name";

//Report D - need to put in dummy data and test if it's working
    private static final String SQL_GET_LATE_RETURNS_BY_PRODUCT
            = "Select pr.productName, count(pi.productId)"
            + "FROM products pr"
            + "INNER JOIN product_items pi"
            + "ON pi.productId=pr.productId"
            + "Inner Join event_product_items epi"
            + "ON epi.productItemId=pi.productItemId"
            + "Inner Join events e"
            + "ON e.eventId=epi.eventId"
            + "WHERE returnDate>eventEnd"
            + "GROUP BY pr.productName";

    private static final String SQL_GET_LATE_RETURNS_BY_USER
            = "Select u.username, count (eventId)"
            + "FROM users u"
            + "INNER JOIN events e"
            + "ON u.userId=e.userId"
            + "WHERE returnDate>eventEnd"
            + "GROUP BY u.username";

    public DataTable getReportA() {

// Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("productName", ValueType.TEXT, "productName"));
        cd.add(new ColumnDescription("damageCount", ValueType.NUMBER, "damageCount"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_PRODUCT_ITEMS_DAMAGED_BY_PRODUCT, new ReportRowMapperA());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;

    }

    private static final class ReportRowMapperA implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("productName"));
            tr.addCell(rs.getLong("damageCount"));

            return tr;
        }
    }

    public DataTable getReportB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataTable getReportC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataTable getReportD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataTable getReportE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataTable getReportF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//
//    

