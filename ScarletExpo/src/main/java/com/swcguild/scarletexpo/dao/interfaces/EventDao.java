/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;

import com.swcguild.scarletexpo.model.Event;
import java.util.List;

/**
 *
 * @author klove
 */
public interface EventDao {
    
    public void checkOutProducts(Event event, int productId, int numOfProducts);
    public void createEvent(Event event);
    public void createEventProductItem(int eventId, int productItemId);
    public void updateEvent(Event event);
    public void updateEventReturnDate(Event event);
    public List<Event> getAllEvents();
    public Event getEventsByEventId(int eventId);
    public List<Event> getEventsByUserId(int userId);
    public List<Event> getEventsByStartDate(String startDate);
    public List<Event> getEventsByEndDate(String endDate);
}
