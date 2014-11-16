/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.EventViewDao;
import com.swcguild.scarletexpo.model.Event;
import com.swcguild.scarletexpo.model.Note;
import com.swcguild.scarletexpo.model.ProductItem;
import com.swcguild.scarletexpo.model.view.EventView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author apprentice
 */
public class EventViewDaoImpl implements EventViewDao {

    private static final String SQL_GET_ALL_EVENTS
            = "SELECT e.eventId, e.eventDesc, DATE_FORMAT(DATE(e.eventStart), '%m-%d-%Y') as eventStart, "
            + "DATE_FORMAT(DATE(e.eventEnd), '%m-%d-%Y') as eventEnd, "
            + "DATE_FORMAT(DATE(e.returnDate), '%m-%d-%Y') as returnDate, u.username "
            + "FROM events e "
            + "INNER JOIN users u "
            + "ON e.userId = u.userId";

    private static final String SQL_GET_ALL_PRODUCT_ITEMS_BY_EVENTID
            = "SELECT pi.* "
            + "FROM event_product_items epi "
            + "INNER JOIN product_items pi "
            + "ON epi.productItemId = pi.productItemId "
            + "WHERE eventId = ?";

    private static final String SQL_SELECT_NOTES_BY_EVENTID
            = "SELECT n.notesId, DATE_FORMAT(DATE(dateEntered), '%m-%d-%Y') as dateEntered, n.notes "
            + "FROM events_notes en "
            + "INNER JOIN notes n "
            + "ON en.notesId = n.notesId "
            + "WHERE eventId = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EventView> displayAllEvents() {
        List<EventView> evList = jdbcTemplate.query(SQL_GET_ALL_EVENTS, new EventViewMapper());

        for (EventView ev : evList) {
            ev.setNotes(jdbcTemplate.query(SQL_SELECT_NOTES_BY_EVENTID, new NoteMapper(), ev.getEventId()));
            ev.setProductItems(jdbcTemplate.query(SQL_GET_ALL_PRODUCT_ITEMS_BY_EVENTID, new ProductItemMapper(), ev.getEventId()));
        }
        
        return evList;
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

    private static final class EventViewMapper implements RowMapper<EventView> {

        @Override
        public EventView mapRow(ResultSet rs, int i) throws SQLException {
            EventView e = new EventView();

            e.setEventDesc(rs.getString("eventDesc"));
            //pulling out the start date
            String dateParser = rs.getTimestamp("eventStart").toString();
            e.setEventStart(rs.getString("eventStart"));

            //pulling out the end date
            dateParser = rs.getDate("eventEnd").toString();
            e.setEventEnd(rs.getString("eventEnd"));

            //pulling out the return date
            dateParser = rs.getDate("returnDate").toString();
            e.setReturnDate(rs.getString("returnDate"));

            e.setUsername(rs.getString("username"));

            e.setEventId(rs.getInt("eventId"));

            return e;
        }
       
    }
}
