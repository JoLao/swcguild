/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;

import com.swcguild.myscarletexpo.model.Event;
/**
 *
 * @author klove
 */
public interface EventDao {
    
    public void checkInProducts(Event event, int productId, int numOfProducts);
    public void createEvent(Event event);
    public void createEventProductItem(int eventId, int productItemId);
}
