/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.myscarletexpo.dao.interfaces;


import com.swcguild.myscarletexpo.model.User;
import java.util.List;

/**
 *
 * @author klove
 */
public interface UserDao {

    public void addUser(User user);

    public void updateUser(User user);

    public void updateProfile(User user);

    public List<User> getAllUsers();

    public User getUserByUserName(String userName);

    public List<User> getUsersByProfileId(int profileId);
    
    public User getUserByUserId(int userId);
}
