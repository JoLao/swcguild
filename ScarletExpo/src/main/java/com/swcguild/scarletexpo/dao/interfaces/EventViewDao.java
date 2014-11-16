/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;

import com.swcguild.scarletexpo.model.view.EventView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface EventViewDao {

    List<EventView> displayAllEvents();
    
}
