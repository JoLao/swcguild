package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.User;

public interface UserDao {
    
    public User addUser(User newUser);
    
    public void deleteUser(String username);
    
}