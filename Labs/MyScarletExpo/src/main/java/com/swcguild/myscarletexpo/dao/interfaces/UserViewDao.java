/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;


import com.swcguild.myscarletexpo.model.view.UserView;
import java.util.List;

/**
 *
 * @author jlao
 */
public interface UserViewDao {
    public List<UserView> displayAllUsers();
}
