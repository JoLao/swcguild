/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;

import com.swcguild.scarletexpo.model.User;
import com.swcguild.scarletexpo.model.view.UserView;
import java.util.List;

/**
 *
 * @author jlao
 */
public interface UserViewDao {
    public List<UserView> displayAllUsers();    
}
