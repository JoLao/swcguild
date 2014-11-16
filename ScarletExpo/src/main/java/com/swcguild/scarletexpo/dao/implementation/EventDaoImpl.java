/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.EventDao;
import com.swcguild.scarletexpo.model.Event;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EventDaoImpl implements EventDao {

    private static final String SQL_INSERT_EVENT
            = "INSERT INTO events (eventDesc, eventStart, eventEnd, returnDate, userId) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_EVENT_PRODUCT_ITEM
            = "INSERT INTO event_product_items (eventId, productItemId) "
            + "VALUES (?, ?)";

    private static final String SQL_UPDATE_EVENT
            = "UPDATE events "
            + "SET eventStart = ? "
            + ", eventEnd = ? "
            + "WHERE eventId = ?";
            
    private static final String SQL_UPDATE_EVENT_RETURN_DATE
            = "UPDATE events "
            + "SET returnDate = ? "            
            + "WHERE eventId = ?";
    
    private static final String SQL_INSERT_EVENT_PRODUCT_ITEMS
            = "INSERT INTO event_product_items "
            + "SELECT ?, productItemId "
            + "FROM product_items "
            + "WHERE productId = ?"
            + "AND isActive = 1 "
            + "AND isCheckedOut = 0 "
            + "AND isDamaged = 0 "
            + "LIMIT ?";

    private static final String SQL_UPDATE_PRODUCT_ITEMS
            = "UPDATE product_items "
            + "SET isCheckedOut = 1 "
            + "WHERE productItemId IN "
            + "(SELECT productItemId "
            + "FROM event_product_items "
            + "WHERE eventId = ?)";

    private static final String SQL_GET_ALL_EVENTS            
            = "SELECT * FROM events";            

    private static final String SQL_GET_EVENT_BY_EVENTID
            = "SELECT e.eventId, e.eventDesc, DATE_FORMAT(DATE(e.eventStart), '%Y-%m-%d') as eventStart, "
            + "DATE_FORMAT(DATE(e.eventEnd), '%Y-%m-%d') as eventEnd, "
            + "DATE_FORMAT(DATE(e.returnDate), '%Y-%m-%d') as returnDate, "
            + "userId FROM events e "
            + "WHERE eventId = ?";

    private static final String SQL_GET_EVENT_BY_USERID
            = "SELECT * FROM events"
            + " WHERE userId = ?";

    private static final String SQL_GET_EVENTS_BY_END_DATE
            = "SELECT * FROM events"
            + " WHERE eventEnd = ?";

    private static final String SQL_GET_EVENTS_BY_START_DATE
            = "SELECT * FROM events"
            + " WHERE eventStart = ?";

    private JdbcTemplate jdbcTemplate;

    //formating date string - ex 01/01/2014
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createEvent(Event event) {
        try {
//            Date startDate = formatter.parse(event.getEventStart());
//            Date endDate = formatter.parse(event.getEventEnd());
//            Date returnDate = formatter.parse(event.getReturnDate());

            jdbcTemplate.update(SQL_INSERT_EVENT,
                    event.getEventDesc(),
                    event.getEventStart(),//startDate,
                    event.getEventEnd(),//endDate,
                    event.getReturnDate(),//returnDate,
                    event.getUserId());

            event.setEventId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createEventProductItem(int eventId, int productItemId) {
        jdbcTemplate.update(SQL_INSERT_EVENT_PRODUCT_ITEM,
                eventId,
                productItemId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void checkOutProducts(Event event, int productId, int numOfProducts) {

        jdbcTemplate.update(SQL_INSERT_EVENT,
                event.getEventDesc(),
                event.getEventStart(),
                event.getUserId());

        event.setEventId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        jdbcTemplate.update(SQL_INSERT_EVENT_PRODUCT_ITEMS,
                event.getEventId(),
                productId,
                numOfProducts);

        jdbcTemplate.update(SQL_UPDATE_PRODUCT_ITEMS,
                event.getEventId());
    }
    
    @Override
    public void updateEvent(Event event) {
        jdbcTemplate.update(SQL_UPDATE_EVENT, event.getEventStart(), event.getEventEnd(), event.getEventId());
    }

    @Override    
    public void updateEventReturnDate(Event event) {               
        jdbcTemplate.update(SQL_UPDATE_EVENT_RETURN_DATE, event.getReturnDate(), event.getEventId());
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eList = jdbcTemplate.query(SQL_GET_ALL_EVENTS, new EventMapper());

        return eList;
    }

    @Override
    public Event getEventsByEventId(int eventId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_EVENT_BY_EVENTID, new EventMapper(), eventId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Event> getEventsByUserId(int userId) {
        List<Event> eList = jdbcTemplate.query(SQL_GET_EVENT_BY_USERID, new EventMapper(), userId);

        return eList;
    }

    @Override
    public List<Event> getEventsByStartDate(String startDate) {
        List<Event> eList = jdbcTemplate.query(SQL_GET_EVENTS_BY_START_DATE, new EventMapper(), startDate);

        return eList;
    }

    @Override
    public List<Event> getEventsByEndDate(String endDate) {
        List<Event> eList = jdbcTemplate.query(SQL_GET_EVENTS_BY_END_DATE, new EventMapper(), endDate);

        return eList;
    }

    //helper class
    private static final class EventMapper implements RowMapper<Event> {

        @Override
        public Event mapRow(ResultSet rs, int i) throws SQLException {
            Event e = new Event();

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

            e.setUserId(rs.getInt("userId"));

            e.setEventId(rs.getInt("eventId"));

            return e;
        }

    }

}
