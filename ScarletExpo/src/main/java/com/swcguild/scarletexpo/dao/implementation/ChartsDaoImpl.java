package com.swcguild.scarletexpo.dao.implementation;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.swcguild.scarletexpo.dao.interfaces.ChartsDao;
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

    //Report A - working/ done
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
            = "Select pr.productName AS productName, count(epi.eventId) AS numUses "
            + "FROM products AS pr "
            + "INNER JOIN product_items AS pi "
            + "ON pi.productId=pr.productId "
            + "INNER JOIN event_product_items AS epi "
            + "ON pi.productItemId= epi.productItemId "
            + "GROUP BY pr.productName";

    //Report C
    private static final String SQL_GET_LOSSES_BY_PRODUCT
            = "Select pr.productName AS productName, count(pi.productItemId) AS numLosses "
            + "FROM products AS pr "
            + "INNER JOIN product_items AS pi "
            + "ON pr.productId=pi.productId "
            + "WHERE pi.isLost=1 "
            + "GROUP BY pr.productName";

//Report D 
    private static final String SQL_GET_LATE_RETURNS_BY_PRODUCT
            = "Select pr.productName AS productName, count(pi.productId) AS numLate "
            + "FROM products AS pr "
            + "INNER JOIN product_items AS pi "
            + "ON pi.productId=pr.productId "
            + "Inner Join event_product_items AS epi "
            + "ON epi.productItemId=pi.productItemId "
            + "Inner Join events e "
            + "ON e.eventId=epi.eventId "
            + "WHERE returnDate>eventEnd "
            + "GROUP BY pr.productName";

//Report E
    private static final String SQL_GET_LATE_RETURNS_BY_USER
            = "Select u.username AS userName, count(eventId) AS numLate "
            + "FROM users AS u "
            + "INNER JOIN events AS e "
            + "ON u.userId=e.userId "
            + "WHERE returnDate>eventEnd "
            + "GROUP BY u.username";

    //Report F
    private static final String SQL_GET_LOSSES_BY_USER
            = "Select u.username AS userName, count(pi.productItemId) AS numLosses "
            + "FROM users AS u "
            + "INNER JOIN events AS e "
            + "ON u.userId=e.userId "
            + "Inner Join event_product_items AS epi "
            + "ON epi.eventId=e.eventId "
            + "INNER JOIN product_items AS pi "
            + "ON pi.productItemId=epi.productItemId"
            + "WHERE pi.isLost=1 "
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

    //-------------------------------------------------------------------------------------------------------------
    public DataTable getReportB() {
        // Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("productName", ValueType.TEXT, "productName"));
        cd.add(new ColumnDescription("numUses", ValueType.NUMBER, "numUses"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_PRODUCT_USAGE, new ReportRowMapperB());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;

    }

    private static final class ReportRowMapperB implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("productName"));
            tr.addCell(rs.getLong("numUses"));

            return tr;
        }
    }

    //------------------------------------------------------------------------------------------------------------------------
    public DataTable getReportC() {
        // Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("productName", ValueType.TEXT, "productName"));
        cd.add(new ColumnDescription("numLosses", ValueType.NUMBER, "numLosses"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_LOSSES_BY_PRODUCT, new ReportRowMapperC());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;
    }

    private static final class ReportRowMapperC implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("productName"));
            tr.addCell(rs.getLong("numLosses"));

            return tr;
        }
    }

    //------------------------------------------------------------------------------------------------
    public DataTable getReportD() {
        // Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("productName", ValueType.TEXT, "productName"));
        cd.add(new ColumnDescription("numLate", ValueType.NUMBER, "numLate"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_LATE_RETURNS_BY_PRODUCT, new ReportRowMapperD());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;
    }

    private static final class ReportRowMapperD implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("productName"));
            tr.addCell(rs.getLong("numLate"));

            return tr;
        }
    }

    //----------------------------------------------------------------------------------------
    public DataTable getReportE() {

        // Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("userName", ValueType.TEXT, "userName"));
        cd.add(new ColumnDescription("numLate", ValueType.NUMBER, "numLate"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_LATE_RETURNS_BY_USER, new ReportRowMapperE());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;

    }

    private static final class ReportRowMapperE implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("userName"));
            tr.addCell(rs.getLong("numLate"));

            return tr;
        }
    }

    //-----------------------------------------------------------------------------------------------
    public DataTable getReportF() {
       
    // Create a data table.
        DataTable t = new DataTable();

        ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
        cd.add(new ColumnDescription("userName", ValueType.TEXT, "userName"));
        cd.add(new ColumnDescription("numLosses", ValueType.NUMBER, "numLosses"));

        t.addColumns(cd);

        try {
            List<TableRow> trList = jdbcTemplate.query(SQL_GET_LOSSES_BY_USER, new ReportRowMapperF());
            t.addRows(trList);
        } catch (Exception e) {
            //can't do anything about it----return empty table
            System.out.println(e.getMessage());
        }

        return t;
    
    }
    
    private static final class ReportRowMapperF implements RowMapper<TableRow> {

        @Override
        public TableRow mapRow(ResultSet rs, int i) throws SQLException {
            //convert ResultSet values to TableRow values
            TableRow tr = new TableRow();
            tr.addCell(rs.getString("userName"));
            tr.addCell(rs.getLong("numLosses"));

            return tr;
        }
    }

}
  

