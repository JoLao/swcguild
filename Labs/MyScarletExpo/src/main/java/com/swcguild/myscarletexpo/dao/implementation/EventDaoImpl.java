/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.implementation;

import com.swcguild.myscarletexpo.dao.interfaces.EventDao;
import com.swcguild.myscarletexpo.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author klove
 */
public class EventDaoImpl implements EventDao {

    private static final String INSERT_EVENT
            = "INSERT INTO events (eventDesc, eventStart, userId) "
            + "VALUES (?, ?, ?)";
    
    private static final String INSERT_EVENT_PRODUCT_ITEM
            = "INSERT INTO event_product_items (eventId, productItemId) "
            + "VALUES (?, ?)";
    
    private static final String INSERT_EVENT_PRODUCT_ITEMS
            = "INSERT INTO event_product_items "
            + "SELECT ?, productItemId "
            + "FROM product_items "
            + "WHERE productId = ?" 
            + "AND isActive = 1 " 
            + "AND isCheckedOut = 0 " 
            + "AND isDamaged = 0 "
            + "LIMIT ?";
    
    private static final String UPDATE_PRODUCT_ITEMS
            = "UPDATE product_items " 
            + "SET isCheckedOut = 1 " 
            + "WHERE productItemId IN " 
            + "(SELECT productItemId " 
            + "FROM event_product_items " 
            + "WHERE eventId = ?)";
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
    public void createEvent(Event event) {
        jdbcTemplate.update(INSERT_EVENT, 
                            event.getEventDesc(),
                            event.getEventStart(),
                            event.getUserId());
        
        event.setEventId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
    public void createEventProductItem(int eventId, int productItemId) {
        jdbcTemplate.update(INSERT_EVENT_PRODUCT_ITEM,                             
                            eventId,
                            productItemId); 
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void checkInProducts(Event event, int productId, int numOfProducts) {
        
        jdbcTemplate.update(INSERT_EVENT, 
                            event.getEventDesc(),
                            event.getEventStart(),
                            event.getUserId());
        
        event.setEventId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        jdbcTemplate.update(INSERT_EVENT_PRODUCT_ITEMS, 
                            event.getEventId(),
                            productId,
                            numOfProducts);
        
        jdbcTemplate.update(UPDATE_PRODUCT_ITEMS, 
                            event.getEventId());
    }

}
